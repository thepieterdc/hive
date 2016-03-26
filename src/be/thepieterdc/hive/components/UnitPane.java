package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.Player;
import be.thepieterdc.hive.helpers.HexCoordinate;
import be.thepieterdc.hive.helpers.Unit;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.HashMap;
import java.util.Map;

/**
 * UnitPane component - a horizontal bar that contains all playable units.
 * <p>
 * Created at 19/03/16 9:28
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class UnitPane extends GridPane implements InvalidationListener {
	private static final ColumnConstraints COLUMN_CONSTRAINTS = new ColumnConstraints(9, 9, Double.MAX_VALUE);

	private final ViewerModel model;
	private final Map<Unit, UnitPane.UnitPaneItem> unitHexagons = new HashMap<>(22);

	private static class UnitPaneItem {
		private final int column;
		private final UnitHexagon hexagon;
		private final int row;

		/**
		 * UnitPaneItem constructor.
		 * @param uh the UnitHexagon
		 * @param r the row to place it
		 * @param c the column to place it
		 */
		public UnitPaneItem(UnitHexagon uh, int r, int c) {
			this.column = c;
			this.hexagon = uh;
			this.row = r;
		}

		/**
		 * @return the column to place the UnitHexagon.
		 */
		public int column() {
			return this.column;
		}

		/**
		 * @return the UnitHexagon.
		 */
		public UnitHexagon hexagon() {
			return this.hexagon;
		}

		/**
		 * @return the row to place the UnitHexagon.
		 */
		public int row() {
			return this.row;
		}
	}

	/**
	 * UnitPane constructor.
	 * @param m the model
	 */
	public UnitPane(ViewerModel m) {
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

		COLUMN_CONSTRAINTS.setHgrow(Priority.ALWAYS);
		for(int c = 0; c < 11; c++) {
			this.getColumnConstraints().add(COLUMN_CONSTRAINTS);
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