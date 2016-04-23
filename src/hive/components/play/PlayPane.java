package hive.components.play;

import hive.components.FreeHexagon;
import hive.components.hexagons.UnitHexagon;
import hive.data.Orientation;
import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Move;
import hive.helpers.Unit;
import hive.helpers.moves.FirstMove;
import hive.models.PlayModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;

import java.util.Map;

/**
 * PlayPane component for the Play-mode. The playing field of the game.
 * <p>
 * Created at 19/03/16 22:17
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class PlayPane extends StackPane implements InvalidationListener {
	private final PlayModel model;

	/**
	 * PlayPane constructor.
	 *
	 * @param m the model
	 */
	public PlayPane(PlayModel m) {
		if (m == null) {
			throw new IllegalArgumentException("Parameter \"m\" is null.");
		}
		this.model = m;
		this.model.addListener(this);

		this.heightProperty().addListener(this);
		this.widthProperty().addListener(this);
	}

	@Override
	public void invalidated(Observable observable) {
		this.getChildren().clear();

		Group g = new Group();

		BoardState state = this.model.boardState();
		//BoardState.Dimensions dims = state.dimensions();

		double factor = 4;
		if (factor > 0) {
			for (Map.Entry<Unit, HexCoordinate> e : state.units().entrySet()) {
				Unit u = e.getKey();

				HexCoordinate c = e.getValue();

				UnitHexagon uH = new UnitHexagon(u);
				uH.enable(this.model.turn().equals(u.player()));
				uH.scale(factor);
				uH.translate(c.x() * factor, c.y() * factor);

				if(u.player().equals(this.model.turn())) {
					uH.setOnMouseClicked(event -> this.model.selectedUnitProperty().set(u));
					this.model.selectedUnitProperty().addListener((o, od, nw) -> uH.select(u.equals(nw)));
				}

				g.getChildren().add(uH);
			}
			for (HexCoordinate c : state.freeHexagons()) {
				FreeHexagon h = new FreeHexagon();
				h.scale(factor);
				h.translate(c.x() * factor, c.y() * factor);

				h.setOnMouseClicked(e -> {
					if(this.model.selectedUnitProperty().get() != null) {
						if (this.model.totalMoves() == 1) {
							this.model.move(new FirstMove(this.model.selectedUnitProperty().get()));
						} else {
							Map.Entry<Unit, HexCoordinate> otherUnit = state.neighbouringUnit(c);
							this.model.move(new Move(this.model.selectedUnitProperty().get(), otherUnit.getKey(), Orientation.fromHexCoordinates(c, otherUnit.getValue())));
						}
					}
				});

				g.getChildren().add(h);
			}
		}

		this.getChildren().add(g);
	}

	@Override
	public String toString() {
		return "PlayPane[]";
	}
}