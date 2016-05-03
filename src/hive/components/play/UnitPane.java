package hive.components.play;

import hive.components.AbstractUnitPane;
import hive.components.hexagons.UnitHexagon;
import hive.models.PlayModel;

/**
 * UnitPane component (Play mode).
 * <p>
 * Created at 29/04/16 9:20
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class UnitPane extends AbstractUnitPane {
	private final PlayModel model;

	/**
	 * UnitPane constructor.
	 *
	 * @param m the model
	 */
	public UnitPane(PlayModel m) {
		super(m);
		this.model = m;
	}

	@Override
	protected void onClear() {
		//TODO: remove listeners @58//
	}

	@Override
	protected UnitHexagon patch(UnitHexagon uH) {
		if (uH.unit().player().equals(this.model.turn())) {
			uH.enable(true);
			uH.setOnMouseClicked(e -> {
				System.out.println(this.model.selectedUnit().get());
				this.model.selectedUnit().set(uH.unit());
				System.out.println(this.model.selectedUnit().get());
			});
		} else {
			uH.enable(false);
			uH.setOnMouseClicked(null);
		}
		this.model.selectedUnit().addListener(o -> {
			System.out.println("test called");
			uH.select(uH.unit().equals(this.model.selectedUnit().get()));
		});
		return uH;
	}

	@Override
	public String toString() {
		return "UnitPane[units=" + this.getChildren().size() + ']';
	}
}