package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.GridCoordinate;
import be.thepieterdc.hive.helpers.Unit;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Node;
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
		System.out.println("------------------------------------------------------");
		System.out.println("---[ Coords ] ---");
		HashMap<GridCoordinate, Node> state = this.model.boardState().coordinates();
		for (Map.Entry<GridCoordinate, Node> gridCoordinateNodeEntry : state.entrySet()) {
			System.out.println(gridCoordinateNodeEntry.getKey()+" - "+gridCoordinateNodeEntry.getValue());
		}
		System.out.println("------------------------------------------------------");
		System.out.println("---[ Units ] ---");
		HashMap<Unit, GridCoordinate> units = this.model.boardState().units();
		for (Map.Entry<Unit, GridCoordinate> unitGridCoordinateEntry : units.entrySet()) {
			System.out.println(unitGridCoordinateEntry.getKey()+" @ "+unitGridCoordinateEntry.getValue());
		}
	}
}