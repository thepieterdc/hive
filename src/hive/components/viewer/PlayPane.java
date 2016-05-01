package hive.components.viewer;

import hive.components.hexagons.FreeHexagon;
import hive.components.hexagons.UnitHexagon;
import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Unit;
import hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;

import java.util.Map;

/**
 * PlayPane component for the Viewer-mode. The playing field of the game.
 * <p>
 * Created at 19/03/16 22:17
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class PlayPane extends StackPane implements InvalidationListener {
	private final ViewerModel model;

	/**
	 * PlayPane constructor.
	 *
	 * @param m the model
	 */
	public PlayPane(ViewerModel m) {
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

		for (Map.Entry<Unit, HexCoordinate> e : state.units().entrySet()) {
			Unit u = e.getKey();

			HexCoordinate c = e.getValue();
			u.location(c);

			UnitHexagon uH = new UnitHexagon(u, 4);
			uH.translate(c.x() * 4, c.y() * 4);
			g.getChildren().add(uH);
		}
		for (HexCoordinate c : state.freeHexagons()) {
			FreeHexagon h = new FreeHexagon(4);
			h.translate(c.x() * 4, c.y() * 4);
			g.getChildren().add(h);
		}

		this.getChildren().addAll(g);
	}

	@Override
	public String toString() {
		return "PlayPane[]";
	}
}