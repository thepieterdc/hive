package hive.components;

import hive.data.Players;
import hive.helpers.Unit;
import hive.models.HiveModel;
import hive.models.PlayModel;
import hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * UnitPane component - a horizontal bar that contains all playable units.
 * <p>
 * Created at 19/03/16 9:28
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class UnitPane extends GridPane implements InvalidationListener {
	private static final ColumnConstraints COLUMN_CONSTRAINTS = new ColumnConstraints(9, 9, Double.MAX_VALUE);

	private final HiveModel model;
	private final Map<Unit, UnitPane.UnitPaneItem> unitHexagons = new HashMap<>(22);

	private static class UnitPaneItem {
		private final int column;
		private final UnitHexagon hexagon;
		private final int row;

		/**
		 * UnitPaneItem constructor.
		 *
		 * @param uh the UnitHexagon
		 * @param r  the row to place it
		 * @param c  the column to place it
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
	 *
	 * @param m the model
	 */
	public UnitPane(HiveModel m) {
		if (m == null) {
			throw new IllegalArgumentException("Parameter \"m\" is null.");
		}
		this.model = m;
		this.model.addListener(this);

		AtomicInteger i = new AtomicInteger(0);
		Arrays.stream(this.model.units()).forEach(u -> this.unitHexagons.put(u, new UnitPane.UnitPaneItem(new UnitHexagon(u, 4), u.player().equals(Players.BLACK.player()) ? 0 : 1, i.getAndIncrement() % 11)));

		COLUMN_CONSTRAINTS.setHgrow(Priority.ALWAYS);
		IntStream.range(0, 11).forEach(v -> this.getColumnConstraints().add(COLUMN_CONSTRAINTS));

		this.setAlignment(Pos.CENTER);
		this.setMaxWidth(Integer.MAX_VALUE);
		this.setMinHeight(168);
	}

	@Override
	public void invalidated(Observable observable) {
		this.getChildren().clear();
		this.unitHexagons.entrySet().stream().filter(u -> !this.model.boardState().units().containsKey(u.getKey())).forEach(u -> this.add(this.model.callback_UnitPane(this, u.getValue().hexagon()), u.getValue().column(), u.getValue().row()));
	}

	@Override
	public String toString() {
		return "UnitPane[]";
	}

	public UnitHexagon unit(UnitHexagon uH, ViewerModel m) {
		return uH;
	}

	public UnitHexagon unit(UnitHexagon uH, PlayModel m) {
		System.out.println("jeeeeeej");
		uH.setOnMouseClicked(System.out::println);
		return uH;
	}
}