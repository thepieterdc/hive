package hive.components.viewer;

import hive.components.AbstractPlayPane;
import hive.components.hexagons.FreeHexagon;
import hive.components.hexagons.UnitHexagon;
import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Unit;
import hive.models.ViewerModel;
import javafx.beans.Observable;
import javafx.scene.Group;

import java.util.Map;

/**
 * PlayPane component for the Viewer-mode. The playing field of the game.
 * <p>
 * Created at 19/03/16 22:17
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class PlayPane extends AbstractPlayPane {
	private final ViewerModel model;

	/**
	 * PlayPane constructor.
	 *
	 * @param m the model
	 */
	public PlayPane(ViewerModel m) {
		super(m);
		this.model = m;
	}

	@Override
	public void invalidated(Observable observable) {
		this.getChildren().clear();

		Group g = new Group();

		BoardState state = this.model.boardState();

		double factor = Math.max(this.getLayoutBounds().getWidth()/210, 4);

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