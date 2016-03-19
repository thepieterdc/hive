package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.Coordinate;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.Parent;
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

		for (Map.Entry<Coordinate, Hexagon> child : state.entrySet()) {
			hexagons.getChildren().add(child.getValue());
		}

		Parent parent = this.getParent();
		System.out.println(parent);

		this.getChildren().add(hexagons);

	}
}