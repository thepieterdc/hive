package hive.components;

import hive.components.hexagons.FreeHexagon;
import hive.components.hexagons.UnitHexagon;
import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Unit;
import hive.models.HiveModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;

import java.util.Map;

/**
 * Abstract PlayPane component - The playing field of the game.
 * <p>
 * Created at 1/05/16 21:50
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public abstract class AbstractPlayPane extends StackPane implements InvalidationListener {
	private final HiveModel model;

	/**
	 * AbstractPlayPane constructor.
	 *
	 * @param m the model
	 */
	protected AbstractPlayPane(HiveModel m) {
		if (m == null) {
			throw new IllegalArgumentException("Parameter \"m\" is null.");
		}
		this.model = m;
		this.model.addListener(this);

		this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		this.heightProperty().addListener(this);
		this.widthProperty().addListener(this);
	}

	@Override
	public void invalidated(Observable observable) {
		this.getChildren().clear();

		Group g = new Group();

		BoardState state = this.model.boardState();

		double factor = Math.max(this.getLayoutBounds().getWidth() / 210, 4);

		for (Map.Entry<Unit, HexCoordinate> e : state.units().entrySet()) {
			Unit u = e.getKey();

			HexCoordinate c = e.getValue();
			u.location(c);

			UnitHexagon uH = new UnitHexagon(u, factor);
			uH.translate(c.x() * factor, c.y() * factor);
			g.getChildren().add(uH);
		}
		for (HexCoordinate c : state.freeHexagons()) {
			FreeHexagon h = new FreeHexagon(factor);
			h.translate(c.x() * factor, c.y() * factor);
			g.getChildren().add(h);
		}

		this.getChildren().addAll(g);
	}

	@Override
	public String toString() {
		return "PlayPane[]";
	}
}