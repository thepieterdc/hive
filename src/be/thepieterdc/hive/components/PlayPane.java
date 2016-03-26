package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.HexCoordinate;
import be.thepieterdc.hive.interfaces.Scalable;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.util.Map;

/**
 * The playing field of the game.
 * <p>
 * Created at 19/03/16 22:17
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
class PlayPane extends StackPane implements InvalidationListener {
	private final ViewerModel model;

	PlayPane(ViewerModel m) {
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

		for (Map.Entry<HexCoordinate, Node> gridCoordinateNodeEntry : state.entrySet()) {
			HexCoordinate c = gridCoordinateNodeEntry.getKey();
			Node h = gridCoordinateNodeEntry.getValue();
			h.setTranslateX(c.x() * factor);
			h.setTranslateY(c.y() * factor);
			((Scalable) h).scale(factor);
			g.getChildren().add(h);
		}

		this.getChildren().add(g);
	}

	@Override
	public String toString() {
		return "PlayPane[]";
	}
}