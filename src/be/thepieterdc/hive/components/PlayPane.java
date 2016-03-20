package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.Coordinate;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;

import java.util.HashMap;
import java.util.Map;

/**
 * Description here
 * <p>
 * Created at 19/03/16 22:17
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class PlayPane extends StackPane implements InvalidationListener {
	private final ViewerModel model;

	public PlayPane(ViewerModel m) {
		this.model = m;
		this.model.addListener(this);
	}

	@Override
	public void invalidated(Observable observable) {
		HashMap<Coordinate, Hexagon> state = this.model.boardState().state();

		this.getChildren().clear();

		Group hexagons = new Group();

		double minX = Integer.MAX_VALUE;
		double maxX = Integer.MIN_VALUE;
		double minY = Integer.MAX_VALUE;
		double maxY = Integer.MIN_VALUE;

		for (Map.Entry<Coordinate, Hexagon> child : state.entrySet()) {
			Coordinate coord = child.getKey();
			minX = Math.min(minX, coord.x());
			maxX = Math.max(maxX, coord.x());
			minY = Math.min(minY, coord.y());
			maxY = Math.max(maxY, coord.y());
		}

		int widthPieces = (int) (Math.abs(minX)+Math.abs(maxX)+1);
		int heightPieces = (int) (Math.abs(minY)+Math.abs(maxY)+1);

		double widthScreen = this.getBoundsInParent().getWidth();
		double heightScreen = this.getBoundsInParent().getHeight();

		double maxSizePieces = (Math.min(widthScreen, heightScreen) / Math.max(widthPieces, heightPieces) - 30)/20;


		for (Map.Entry<Coordinate, Hexagon> child : state.entrySet()) {
			Coordinate coord = child.getKey();
			Hexagon hex = child.getValue();
			hex.setLayoutX(coord.x());
			hex.setLayoutX(coord.y());
			hex.setScaleX(maxSizePieces);
			hex.setScaleY(maxSizePieces);
			hexagons.getChildren().addAll(hex);
		}

		this.getChildren().add(hexagons);
	}
}