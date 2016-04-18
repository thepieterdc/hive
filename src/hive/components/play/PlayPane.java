package hive.components.play;

import hive.data.Orientation;
import hive.helpers.HexCoordinate;
import hive.helpers.Move;
import hive.helpers.Unit;
import hive.helpers.moves.FirstMove;
import hive.interfaces.Scalable;
import hive.interfaces.Translatable;
import hive.models.PlayModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.Node;
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

		Map<HexCoordinate, Node> state = this.model.boardState().coordinates();

		int horizMin = Integer.MAX_VALUE;
		int horizMax = Integer.MIN_VALUE;
		int vertMin = Integer.MAX_VALUE;
		int vertMax = Integer.MIN_VALUE;

		for (HexCoordinate h : state.keySet()) {
			horizMin = Math.min(horizMin, h.row());
			horizMax = Math.max(horizMax, h.row());
			vertMin = Math.min(vertMin, h.column());
			vertMax = Math.max(vertMax, h.column());
		}

		double factor = Math.min(this.getWidth(), this.getHeight()) / Math.min(horizMax - horizMin + 1, vertMax - vertMin + 1) / 25.0;

		if (factor > 0) {
			for (Map.Entry<HexCoordinate, Node> gridCoordinateNodeEntry : state.entrySet()) {
				HexCoordinate c = gridCoordinateNodeEntry.getKey();
				Node h = gridCoordinateNodeEntry.getValue();

				h.setOnMouseClicked(event -> {
					if(this.model.selectedUnitProperty().getValue() != null && this.model.boardState().free(c)) {
						if (this.model.totalMoves() == 1) {
							this.model.move(new FirstMove(this.model.selectedUnitProperty().getValue()));
						} else {
							Map.Entry<Unit, HexCoordinate> otherUnit = this.model.boardState().neighbouringUnit(c);
							this.model.move(new Move(this.model.selectedUnitProperty().getValue(), otherUnit.getKey(), Orientation.fromHexCoordinates(c, otherUnit.getValue())));
						}
					}
				});

				((Scalable) h).scale(factor);
				((Translatable) h).translate(c.x() * factor, c.y() * factor);
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