package hive.components.viewer;

import hive.components.AbstractPlayPane;
import hive.components.hexagons.FreeHexagon;
import hive.components.hexagons.UnitHexagon;
import hive.helpers.HexCoordinate;
import hive.models.ViewerModel;
import javafx.scene.Group;

/**
 * PlayPane component for the Viewer-mode. The playing field of the game.
 * <p>
 * Created at 19/03/16 22:17
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class PlayPane extends AbstractPlayPane {

	/**
	 * PlayPane constructor.
	 *
	 * @param m the model
	 */
	public PlayPane(ViewerModel m) {
		super(m);
	}

	@Override
	protected FreeHexagon parseFreeHexagon(FreeHexagon fH, HexCoordinate c) {
		return fH;
	}

	@Override
	protected UnitHexagon parseUnitHexagon(UnitHexagon uH) {
		return uH;
	}

	@Override
	protected void removeListeners(Group children) {
		//
	}

	@Override
	public String toString() {
		return "PlayPane[]";
	}
}