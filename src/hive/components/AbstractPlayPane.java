package hive.components;

import hive.components.hexagons.FreeHexagon;
import hive.components.hexagons.UnitHexagon;
import hive.helpers.HexCoordinate;
import hive.models.HiveModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;

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
		this.removeListeners();
		this.getChildren().clear();

		final Group g = new Group();

		final double factor = Math.max(this.getLayoutBounds().getWidth() / 220, 3.5);

		this.model.boardState().units().forEach((u, c) -> {
			UnitHexagon uH = new UnitHexagon(u, factor);
			uH.translate(c.x() * factor, c.y() * factor);
			g.getChildren().add(this.parseUnitHexagon(uH));
		});
		this.model.boardState().freeHexagons().forEach(c -> {
			FreeHexagon h = new FreeHexagon(factor);
			h.translate(c.x() * factor, c.y() * factor);
			g.getChildren().add(this.parseFreeHexagon(h, c));
		});

		this.getChildren().addAll(g);
	}

	protected abstract FreeHexagon parseFreeHexagon(FreeHexagon fH, HexCoordinate c);

	protected abstract UnitHexagon parseUnitHexagon(UnitHexagon uH);

	protected abstract void removeListeners();
}