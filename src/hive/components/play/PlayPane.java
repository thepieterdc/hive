package hive.components.play;

import hive.components.AbstractPlayPane;
import hive.components.hexagons.FreeHexagon;
import hive.components.hexagons.UnitHexagon;
import hive.exceptions.IllegalMoveException;
import hive.helpers.HexCoordinate;
import hive.helpers.Move;
import hive.helpers.moves.FirstMove;
import hive.models.PlayModel;

/**
 * PlayPane component for the Play-mode. The playing field of the game.
 * <p>
 * Created at 19/03/16 22:17
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class PlayPane extends AbstractPlayPane {
	private final PlayModel model;

	/**
	 * PlayPane constructor.
	 *
	 * @param m the model
	 */
	public PlayPane(PlayModel m) {
		super(m);
		this.model = m;
	}

	@Override
	protected FreeHexagon parseFreeHexagon(FreeHexagon h, HexCoordinate c) {
		h.setOnMouseClicked(e -> {
			if (this.model.selectedUnitProperty().get() != null) {
				try {
					h.enable(this.model.totalMoves() == 1 ? this.model.move(new FirstMove(this.model.selectedUnitProperty().get())) : this.model.move(Move.fromCoordinates(this.model.boardState(), this.model.selectedUnitProperty().get(), c), c));
				} catch (IllegalMoveException ignored) {
					h.enable(false);
				}
			}
		});
		this.model.selectedUnitProperty().addListener(o -> h.enable(true));
		return h;
	}

	@Override
	protected UnitHexagon parseUnitHexagon(UnitHexagon uH) {
		uH.enable(this.model.turn().equals(uH.unit().player()));
		if (uH.unit().player().equals(this.model.turn())) {
			uH.setOnMouseClicked(event -> this.model.selectedUnitProperty().set(uH.unit()));
			this.model.selectedUnitProperty().addListener((o, od, nw) -> uH.select(uH.unit().equals(nw)));
		}
		return uH;
	}

	@Override
	public String toString() {
		return "PlayPane[]";
	}
}