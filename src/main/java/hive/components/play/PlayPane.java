package hive.components.play;

import hive.components.AbstractPlayPane;
import hive.components.hexagons.FreeHexagon;
import hive.components.hexagons.UnitHexagon;
import hive.exceptions.IllegalMoveException;
import hive.helpers.HexCoordinate;
import hive.helpers.Move;
import hive.helpers.moves.FirstMove;
import hive.models.PlayModel;

import java.util.Optional;

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
		h.setOnMouseClicked(e -> Optional.ofNullable(this.model.selectedUnit().get()).ifPresent(u -> {
			try {
				h.enable(this.model.totalMoves() == 1 ? this.model.move(new FirstMove(u)) : this.model.move(Move.fromCoordinates(this.model.boardState(), u, c), c));
			} catch (IllegalMoveException ignored) {
				h.enable(false);
			}
		}));
		this.model.selectedUnit().addListener(o -> h.enable(true));
		return h;
	}
	
	@Override
	protected UnitHexagon parseUnitHexagon(UnitHexagon uH) {
		uH.enable(this.model.turn().equals(uH.unit().player()));
		if (uH.unit().player().equals(this.model.turn())) {
			uH.setOnMouseClicked(event -> this.model.selectedUnit().set(uH.unit()));
			this.model.selectedUnit().addListener(o -> uH.select(uH.unit().equals(this.model.selectedUnit().get())));
		}
		return uH;
	}
	
	@Override
	public String toString() {
		return "PlayPane[]";
	}
}