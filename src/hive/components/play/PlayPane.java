package hive.components.play;

import hive.components.FreeHexagon;
import hive.components.hexagons.UnitHexagon;
import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Unit;
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
		//TODO De listeners eens wissen//
		this.getChildren().clear();

		Group g = new Group();

		BoardState state = this.model.boardState();
		BoardState.Dimensions dims = state.dimensions();

		double factor = Math.max(this.getWidth() / this.getHeight() * 12 / Math.max(dims.hMax - dims.hMin + 1, dims.vMax - dims.vMin + 1), 4);
		if (factor > 0) {
			for (Map.Entry<Unit, HexCoordinate> e : state.units().entrySet()) {
				Unit u = e.getKey();

				HexCoordinate c = e.getValue();

				UnitHexagon uH = new UnitHexagon(u);
				uH.scale(factor);
				uH.translate(c.x() * factor, c.y() * factor);
				g.getChildren().add(uH);
			}
			for (HexCoordinate c : state.freeHexagons()) {
				FreeHexagon h = new FreeHexagon();
				h.scale(factor);
				h.translate(c.x() * factor, c.y() * factor);

				g.getChildren().add(h);
			}
			/*

			for (Map.Entry<HexCoordinate, Node> gridCoordinateNodeEntry : state.entrySet()) {
				HexCoordinate c = gridCoordinateNodeEntry.getKey();
				Node h = gridCoordinateNodeEntry.getValue();
				Unit u = this.model.boardState().unit(c);

				h.setOnMouseClicked(event -> {
					if (this.model.selectedUnitProperty().get() != null && this.model.boardState().free(c)) {
						//TODO: Doe hier mss iets aan//
						if (this.model.totalMoves() == 1) {
							this.model.move(new FirstMove(this.model.selectedUnitProperty().get()));
						} else {
							Map.Entry<Unit, HexCoordinate> otherUnit = this.model.boardState().neighbouringUnit(c);
							this.model.move(new Move(this.model.selectedUnitProperty().get(), otherUnit.getKey(), Orientation.fromHexCoordinates(c, otherUnit.getValue())));
						}
					} else if (u != null && this.model.turn().equals(u.player())) {
						this.model.selectedUnitProperty().set(u);
					}
				});

				if (h instanceof UnitHexagon) {
					this.model.selectedUnitProperty().addListener((o, od, nw) -> ((UnitHexagon) h).select(((UnitHexagon) h).unit().equals(nw)));
				}

				((Scalable) h).scale(factor);
				((Translatable) h).translate(c.x() * factor, c.y() * factor);
				g.getChildren().add(h);
			}
			*/
		}

		this.getChildren().add(g);
	}

	@Override
	public String toString() {
		return "PlayPane[]";
	}
}