package hive.components.viewer;

import hive.components.AbstractPlayPane;
import hive.components.hexagons.UnitHexagon;
import hive.models.ViewerModel;

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
	protected UnitHexagon parseUnitHexagon(UnitHexagon uH) {
		return uH;
	}

	@Override
	public String toString() {
		return "PlayPane[]";
	}
}