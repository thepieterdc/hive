package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.Player;
import be.thepieterdc.hive.data.UnitType;
import be.thepieterdc.hive.helpers.HexCoordinate;
import be.thepieterdc.hive.helpers.Unit;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.Map;

/**
 * Grid that holds all playable units.
 * <p>
 * Created at 19/03/16 9:28
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
class UnitPane extends GridPane implements InvalidationListener {
	private final ViewerModel model;
	private final Map<Unit, UnitPane.UnitPaneItem> unitHexagons = new HashMap<>(22);

	private static class UnitPaneItem {
		private final int column;
		private final UnitHexagon hexagon;
		private final int row;

		UnitPaneItem(UnitHexagon uh, int r, int c) {
			this.column = c;
			this.hexagon = uh;
			this.row = r;
		}

		int column() {
			return this.column;
		}

		UnitHexagon hexagon() {
			return this.hexagon;
		}

		int row() {
			return this.row;
		}
	}

	UnitPane(ViewerModel m) {
		this.model = m;
		this.model.addListener(this);

		this.addUnits(Player.ONE, 0);
		this.addUnits(Player.TWO, 1);
		this.setAlignment(Pos.CENTER);
		this.setMaxWidth(Integer.MAX_VALUE);
		this.setMinHeight(168);
	}

	private void addUnits(Player p, int r) {
		Unit A1 = new Unit(p, UnitType.ANT, 1);
		Unit A2 = new Unit(p, UnitType.ANT, 2);
		Unit A3 = new Unit(p, UnitType.ANT, 3);
		Unit B1 = new Unit(p, UnitType.BEATLE, 1);
		Unit B2 = new Unit(p, UnitType.BEATLE, 2);
		Unit G1 = new Unit(p, UnitType.GRASSHOPPER, 1);
		Unit G2 = new Unit(p, UnitType.GRASSHOPPER, 2);
		Unit G3 = new Unit(p, UnitType.GRASSHOPPER, 3);
		Unit Q = new Unit(p, UnitType.QUEEN);
		Unit S1 = new Unit(p, UnitType.SPIDER, 1);
		Unit S2 = new Unit(p, UnitType.SPIDER, 2);
		this.unitHexagons.put(A1, new UnitPane.UnitPaneItem(new UnitHexagon(A1, 4), r, 0));
		this.unitHexagons.put(A2, new UnitPane.UnitPaneItem(new UnitHexagon(A2, 4), r, 1));
		this.unitHexagons.put(A3, new UnitPane.UnitPaneItem(new UnitHexagon(A3, 4), r, 2));
		this.unitHexagons.put(B1, new UnitPane.UnitPaneItem(new UnitHexagon(B1, 4), r, 3));
		this.unitHexagons.put(B2, new UnitPane.UnitPaneItem(new UnitHexagon(B2, 4), r, 4));
		this.unitHexagons.put(G1, new UnitPane.UnitPaneItem(new UnitHexagon(G1, 4), r, 5));
		this.unitHexagons.put(G2, new UnitPane.UnitPaneItem(new UnitHexagon(G2, 4), r, 6));
		this.unitHexagons.put(G3, new UnitPane.UnitPaneItem(new UnitHexagon(G3, 4), r, 7));
		this.unitHexagons.put(Q, new UnitPane.UnitPaneItem(new UnitHexagon(Q, 4), r, 8));
		this.unitHexagons.put(S1, new UnitPane.UnitPaneItem(new UnitHexagon(S1, 4), r, 9));
		this.unitHexagons.put(S2, new UnitPane.UnitPaneItem(new UnitHexagon(S2, 4), r, 10));
	}

	@Override
	public void invalidated(Observable observable) {
		this.getChildren().clear();
		Map<Unit, HexCoordinate> state = this.model.boardState().units();
		for (Map.Entry<Unit, UnitPane.UnitPaneItem> entry : this.unitHexagons.entrySet()) {
			UnitPane.UnitPaneItem item = entry.getValue();
			if (!state.containsKey(entry.getKey())) {
				this.add(item.hexagon(), item.column(), item.row());
			}
		}
	}

	@Override
	public String toString() {
		return "UnitPane[]";
	}
}