package hive.models;

import hive.components.UnitHexagon;
import hive.components.UnitPane;
import hive.data.Players;
import hive.data.UnitType;
import hive.helpers.Move;
import hive.helpers.Unit;

import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Model for the Viewer part.
 * <p>
 * Created at 17/03/16 14:08
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class ViewerModel extends HiveModel {
	/**
	 * ViewerModel constructor.
	 *
	 * @param moveList the list of moves
	 */
	public ViewerModel(List<Move> moveList) {
		super(moveList);

		AtomicInteger i = new AtomicInteger();
		EnumSet.allOf(Players.class).forEach(p -> EnumSet.allOf(UnitType.class).forEach(u -> IntStream.range(0, u.capacity()).forEach(c -> units[i.getAndIncrement()] = new Unit(p.player(), u, c + 1))));
	}

	@Override
	public UnitHexagon callback_UnitPane(UnitPane u, UnitHexagon uH) {
		return u.unit(uH, this);
	}

	@Override
	public String toString() {
		return "ViewerModel[boardStates=" + this.boardStates.size() + ", move=" + this.move.representation() + ", moveIndex=" + this.moveIndex + ", totalmoves=" + this.totalMoves + ']';
	}
}
