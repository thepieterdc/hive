package hive.components.viewer;

import hive.components.AbstractUnitPane;
import hive.components.hexagons.UnitHexagon;
import hive.models.ViewerModel;

/**
 * UnitPane component (Viewer mode).
 * <p>
 * Created at 29/04/16 9:39
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class UnitPane extends AbstractUnitPane {
	/**
	 * UnitPane constructor.
	 *
	 * @param m the model
	 */
	public UnitPane(ViewerModel m) {
		super(m);
	}

	@Override
	protected void onClear() {
		//Does nothing because the UnitHexagons contain no listeners//
	}

	@Override
	protected UnitHexagon patch(UnitHexagon uH) {
		return uH;
	}
}