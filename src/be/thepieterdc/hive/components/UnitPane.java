package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.UnitType;
import be.thepieterdc.hive.helpers.GridCoordinate;
import be.thepieterdc.hive.helpers.Unit;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

/**
 * Grid that holds all playable units.
 * <p>
 * Created at 19/03/16 9:28
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnitPane extends GridPane implements InvalidationListener {
	private final ViewerModel model;
	private final HashMap<Unit, UnitPaneItem> unitHexagons = new HashMap<>();

	private class UnitPaneItem {
		private final int column;
		private final UnitHexagon hexagon;
		private final int row;

		UnitPaneItem(UnitHexagon uh, int row, int col) {
			this.column = col;
			this.hexagon = uh;
			this.row = row;
		}
	}

	public UnitPane(ViewerModel m) {
		this.model = m;
		this.model.addListener(this);

		Unit p1A1 = new Unit(Color.WHITE, UnitType.ANT, 1);
		Unit p1A2 = new Unit(Color.WHITE, UnitType.ANT, 2);
		Unit p1A3 = new Unit(Color.WHITE, UnitType.ANT, 3);
		Unit p1B1 = new Unit(Color.WHITE, UnitType.BEATLE, 1);
		Unit p1B2 = new Unit(Color.WHITE, UnitType.BEATLE, 2);
		Unit p1G1 = new Unit(Color.WHITE, UnitType.GRASSHOPPER, 1);
		Unit p1G2 = new Unit(Color.WHITE, UnitType.GRASSHOPPER, 2);
		Unit p1G3 = new Unit(Color.WHITE, UnitType.GRASSHOPPER, 3);
		Unit p1Q = new Unit(Color.WHITE, UnitType.QUEEN);
		Unit p1S1 = new Unit(Color.WHITE, UnitType.SPIDER, 1);
		Unit p1S2 = new Unit(Color.WHITE, UnitType.SPIDER, 2);
		this.unitHexagons.put(p1A1, new UnitPaneItem(new UnitHexagon(p1A1, 5), 0, 0));
		this.unitHexagons.put(p1A2, new UnitPaneItem(new UnitHexagon(p1A2, 5), 0, 1));
		this.unitHexagons.put(p1A3, new UnitPaneItem(new UnitHexagon(p1A3, 5), 0, 2));
		this.unitHexagons.put(p1B1, new UnitPaneItem(new UnitHexagon(p1B1, 5), 0, 3));
		this.unitHexagons.put(p1B2, new UnitPaneItem(new UnitHexagon(p1B2, 5), 0, 4));
		this.unitHexagons.put(p1G1, new UnitPaneItem(new UnitHexagon(p1G1, 5), 0, 5));
		this.unitHexagons.put(p1G2, new UnitPaneItem(new UnitHexagon(p1G2, 5), 0, 6));
		this.unitHexagons.put(p1G3, new UnitPaneItem(new UnitHexagon(p1G3, 5), 0, 7));
		this.unitHexagons.put(p1Q, new UnitPaneItem(new UnitHexagon(p1Q, 5), 0, 8));
		this.unitHexagons.put(p1S1, new UnitPaneItem(new UnitHexagon(p1S1, 5), 0, 9));
		this.unitHexagons.put(p1S2, new UnitPaneItem(new UnitHexagon(p1S2, 5), 0, 10));

		Unit p2A1 = new Unit(Color.BLACK, UnitType.ANT, 1);
		Unit p2A2 = new Unit(Color.BLACK, UnitType.ANT, 2);
		Unit p2A3 = new Unit(Color.BLACK, UnitType.ANT, 3);
		Unit p2B1 = new Unit(Color.BLACK, UnitType.BEATLE, 1);
		Unit p2B2 = new Unit(Color.BLACK, UnitType.BEATLE, 2);
		Unit p2G1 = new Unit(Color.BLACK, UnitType.GRASSHOPPER, 1);
		Unit p2G2 = new Unit(Color.BLACK, UnitType.GRASSHOPPER, 2);
		Unit p2G3 = new Unit(Color.BLACK, UnitType.GRASSHOPPER, 3);
		Unit p2Q = new Unit(Color.BLACK, UnitType.QUEEN);
		Unit p2S1 = new Unit(Color.BLACK, UnitType.SPIDER, 1);
		Unit p2S2 = new Unit(Color.BLACK, UnitType.SPIDER, 2);
		this.unitHexagons.put(p2A1, new UnitPaneItem(new UnitHexagon(p2A1, 5), 1, 0));
		this.unitHexagons.put(p2A2, new UnitPaneItem(new UnitHexagon(p2A2, 5), 1, 1));
		this.unitHexagons.put(p2A3, new UnitPaneItem(new UnitHexagon(p2A3, 5), 1, 2));
		this.unitHexagons.put(p2B1, new UnitPaneItem(new UnitHexagon(p2B1, 5), 1, 3));
		this.unitHexagons.put(p2B2, new UnitPaneItem(new UnitHexagon(p2B2, 5), 1, 4));
		this.unitHexagons.put(p2G1, new UnitPaneItem(new UnitHexagon(p2G1, 5), 1, 5));
		this.unitHexagons.put(p2G2, new UnitPaneItem(new UnitHexagon(p2G2, 5), 1, 6));
		this.unitHexagons.put(p2G3, new UnitPaneItem(new UnitHexagon(p2G3, 5), 1, 7));
		this.unitHexagons.put(p2Q, new UnitPaneItem(new UnitHexagon(p2Q, 5), 1, 8));
		this.unitHexagons.put(p2S1, new UnitPaneItem(new UnitHexagon(p2S1, 5), 1, 9));
		this.unitHexagons.put(p2S2, new UnitPaneItem(new UnitHexagon(p2S2, 5), 1, 10));
	}

	@Override
	public void invalidated(Observable observable) {
		this.getChildren().clear();
		HashMap<Unit, GridCoordinate> state = this.model.boardState().units();
		for (Map.Entry<Unit, UnitPaneItem> entry : this.unitHexagons.entrySet()) {
			UnitPaneItem item = entry.getValue();
			if(!state.containsKey(entry.getKey())) {
				this.add(item.hexagon, item.column, item.row);
			}
		}
	}
}
