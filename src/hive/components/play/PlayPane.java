package hive.components.play;

import hive.components.hexagons.FreeHexagon;
import hive.components.hexagons.UnitHexagon;
import hive.exceptions.IllegalMoveException;
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

		this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		this.heightProperty().addListener(this);
		this.widthProperty().addListener(this);
	}

	@Override
	public void invalidated(Observable observable) {
		this.getChildren().clear();

		Group g = new Group();

		BoardState state = this.model.boardState();

		double factor = Math.max(this.getLayoutBounds().getWidth()/210, 4);

		for (Map.Entry<Unit, HexCoordinate> e : state.units().entrySet()) {
			Unit u = e.getKey();

			HexCoordinate c = e.getValue();
			u.location(c);

			UnitHexagon uH = new UnitHexagon(u, factor);
			uH.enable(this.model.turn().equals(u.player()));
			uH.translate(c.x() * factor, c.y() * factor);

			if (u.player().equals(this.model.turn())) {
				uH.setOnMouseClicked(event -> this.model.selectedUnitProperty().set(u));
				this.model.selectedUnitProperty().addListener((o, od, nw) -> uH.select(u.equals(nw)));
			}

			g.getChildren().add(uH);
		}
		for (HexCoordinate c : state.freeHexagons()) {
			FreeHexagon h = new FreeHexagon(factor);
			h.translate(c.x() * factor, c.y() * factor);

			h.setOnMouseClicked(e -> {
				if (this.model.selectedUnitProperty().get() != null) {
					if (this.model.totalMoves() == 1) {
						this.model.move(new FirstMove(this.model.selectedUnitProperty().get()));
					} else {
						try {
							Move m = Move.fromCoordinates(state, this.model.selectedUnitProperty().get(), c);
							if (!this.model.move(m, c)) {
								h.enable(false);
							}
						} catch (IllegalMoveException ignored) {
							h.enable(false);
						}
					}
				}
			});

			this.model.selectedUnitProperty().addListener(o -> h.enable(true));

			g.getChildren().add(h);
		}

		this.getChildren().addAll(g);
	}

	@Override
	public String toString() {
		return "PlayPane[]";
	}
}