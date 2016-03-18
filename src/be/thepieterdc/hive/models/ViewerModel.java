package be.thepieterdc.hive.models;

import be.thepieterdc.hive.helpers.Model;
import be.thepieterdc.hive.helpers.Move;

import java.util.List;

/**
 * Model for the Viewer part.
 * <p>
 * Created at 17/03/16 14:08
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class ViewerModel extends Model {
	private Move move = null;
	private int moveIndex;
	private final List<Move> moves;
	private final int totalMoves;

	/**
	 * ViewerModel constructor.
	 * @param moves the moves to set
	 */
	public ViewerModel(List<Move> moves) {
		this.moves = moves;
		this.totalMoves = this.moves.size();
	}

	/**
	 * move-setter.
	 * @param index the index of the move
	 */
	public void move(int index) {
		Move m = this.moves.get(index);
		if (!m.equals(this.move)) {
			this.moveIndex = index;
			this.move = m;
			this.notifyListeners();
		}
	}

	/**
	 * move-setter.
	 * @param m the move to set
	 */
	public void move(Move m) {
		this.move(this.moves.indexOf(m));
	}

	/**
	 * move-getter.
	 * @return the move
	 */
	public Move move() {
		return this.move;
	}

	/**
	 * moveIndex-getter.
	 * @return the index of the move
	 */
	public int moveIndex() {
		return this.moveIndex;
	}

	/**
	 * moves-getter.
	 * @return the moves
	 */
	public List<Move> moves() {
		return this.moves;
	}

	/**
	 * totalMoves-getter.
	 * @return the total amount of moves
	 */
	public int totalMoves() {
		return this.totalMoves;
	}
}
