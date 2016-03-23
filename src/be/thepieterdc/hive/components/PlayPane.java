package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.HexCoordinate;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Group;
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
		this.getChildren().clear();
		Group g = new Group();
		HashMap<HexCoordinate, Node> state = this.model.boardState().coordinates();
		for (Map.Entry<HexCoordinate, Node> gridCoordinateNodeEntry : state.entrySet()) {
			HexCoordinate c = gridCoordinateNodeEntry.getKey();
			Node h = gridCoordinateNodeEntry.getValue();
			h.setTranslateX(c.x()*5);
			h.setTranslateY(c.y()*5);
			if(h instanceof UnitHexagon) {
				System.out.println("Unit hex:");
				System.out.println(((UnitHexagon) h).width());
				System.out.println(((UnitHexagon) h).height());
			} else if(h instanceof DefaultHexagon) {
				System.out.println("Regular hex:");
				h.setScaleX(5);
				h.setScaleY(5);
				System.out.println(((DefaultHexagon) h).width());
				System.out.println(((DefaultHexagon) h).height());
			}
			g.getChildren().add(h);
		}
		this.getChildren().add(g);
		/*
		System.out.println("------------------------------------------------------");
		System.out.println("---[ Coords ] ---");
		HashMap<HexCoordinate, Node> state = this.model.boardState().coordinates();
		for (Map.Entry<HexCoordinate, Node> gridCoordinateNodeEntry : state.entrySet()) {
			System.out.println(gridCoordinateNodeEntry.getKey()+" - "+gridCoordinateNodeEntry.getValue());
		}
		System.out.println("------------------------------------------------------");
		System.out.println("---[ Units ] ---");
		HashMap<Unit, HexCoordinate> units = this.model.boardState().units();
		for (Map.Entry<Unit, HexCoordinate> unitGridCoordinateEntry : units.entrySet()) {
			System.out.println(unitGridCoordinateEntry.getKey()+" @ "+unitGridCoordinateEntry.getValue());
		}
		*/
	}
}