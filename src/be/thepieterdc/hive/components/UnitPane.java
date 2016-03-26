package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.Player;
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
final class UnitPane extends GridPane implements InvalidationListener {
	private final ViewerModel model;
	private final Map<Unit, UnitPane.UnitPaneItem> unitHexagons = new HashMap<>(22);

	private static class UnitPaneItem {
		private final int column;
		private final UnitHexagon hexagon;
		private final int row;

		UnitPaneItem(UnitHexagon uh, int r, int c) {
			if(uh == null) {
				throw new IllegalArgumentException("Parameter \"uh\" is null.");
			}
			if(r < 0) {
				throw new IllegalArgumentException("Parameter \"r\" is negative.");
			}
			if(c < 0) {
				throw new IllegalArgumentException("Parameter \"c\" is negative.");
			}
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
		if(m == null) {
			throw new IllegalArgumentException("Parameter \"m\" is null.");
		}
		this.model = m;
		this.model.addListener(this);

		int i = 0;
		for (Unit u : this.model.units()) {
			this.unitHexagons.put(u, new UnitPane.UnitPaneItem(new UnitHexagon(u, 4), u.player() == Player.ONE ? 0 : 1, i % 11));
			i++;
		}

		this.setAlignment(Pos.CENTER);
		this.setMaxWidth(Integer.MAX_VALUE);
		this.setMinHeight(168);
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