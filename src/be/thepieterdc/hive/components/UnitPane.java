package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.UnitType;
import be.thepieterdc.hive.helpers.Unit;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.GridPane;

import java.util.HashMap;

/**
 * Grid that holds all playable units.
 * <p>
 * Created at 19/03/16 9:28
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnitPane extends GridPane implements InvalidationListener {
	private final ViewerModel model;
	private final HashMap<UnitHexagon, UnitPaneItem> unitHexagons = new HashMap<>();

	private class UnitPaneItem {
		private final int col;
		private final int row;
		private boolean visible = true;

		UnitPaneItem(int row, int col) {
			this.col = col;
			this.row = row;
		}

		public void hide() {
			this.visible = false;
		}

		public void show() {
			this.visible = true;
		}

		public boolean visible() {
			return this.visible;
		}
	}

	public UnitPane(ViewerModel m) {
		this.model = m;
		this.model.addListener(this);

		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player1(), UnitType.ANT, 1), 5), new UnitPaneItem(0, 0));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player1(), UnitType.ANT, 2), 5), new UnitPaneItem(0, 1));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player1(), UnitType.ANT, 3), 5), new UnitPaneItem(0, 2));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player1(), UnitType.BEATLE, 1), 5), new UnitPaneItem(0, 3));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player1(), UnitType.BEATLE, 2), 5), new UnitPaneItem(0, 4));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player1(), UnitType.GRASSHOPPER, 1), 5), new UnitPaneItem(0, 5));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player1(), UnitType.GRASSHOPPER, 2), 5), new UnitPaneItem(0, 6));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player1(), UnitType.GRASSHOPPER, 3), 5), new UnitPaneItem(0, 7));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player1(), UnitType.QUEEN), 5), new UnitPaneItem(0, 8));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player1(), UnitType.SPIDER, 1), 5), new UnitPaneItem(0, 9));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player1(), UnitType.SPIDER, 2), 5), new UnitPaneItem(0, 10));

		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player2(), UnitType.ANT, 1), 5), new UnitPaneItem(1, 0));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player2(), UnitType.ANT, 2), 5), new UnitPaneItem(1, 1));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player2(), UnitType.ANT, 3), 5), new UnitPaneItem(1, 2));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player2(), UnitType.BEATLE, 1), 5), new UnitPaneItem(1, 3));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player2(), UnitType.BEATLE, 2), 5), new UnitPaneItem(1, 4));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player2(), UnitType.GRASSHOPPER, 1), 5), new UnitPaneItem(1, 5));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player2(), UnitType.GRASSHOPPER, 2), 5), new UnitPaneItem(1, 6));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player2(), UnitType.GRASSHOPPER, 3), 5), new UnitPaneItem(1, 7));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player2(), UnitType.QUEEN), 5), new UnitPaneItem(1, 8));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player2(), UnitType.SPIDER, 1), 5), new UnitPaneItem(1, 9));
		this.unitHexagons.put(new UnitHexagon(new Unit(this.model.player2(), UnitType.SPIDER, 2), 5), new UnitPaneItem(1, 10));
	}

	@Override
	public void invalidated(Observable observable) {
		System.out.println("TODO: Remove from grid");
	}
}
