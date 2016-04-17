package hive.models;

import hive.components.UnitHexagon;
import hive.components.UnitPane;
import hive.helpers.Move;

import java.util.List;

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
