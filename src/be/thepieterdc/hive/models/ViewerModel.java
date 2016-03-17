package be.thepieterdc.hive.models;

import be.thepieterdc.hive.helpers.Model;
import be.thepieterdc.hive.helpers.Move;

import java.util.ArrayList;
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
	private final List<Move> moves;

	/**
	 * ViewerModel constructor.
	 *
	 * @param moves the moves to set
	 */
	public ViewerModel(List moves) {
		this.moves = new ArrayList<>();

		//Allow for moves to be passed as strings and as "move" objects
		for (Object o : moves) {
			if (o instanceof String) {

			}
		}
	}

	/**
	 * move-setter
	 *
	 * @param index the index of the move
	 */
	public void move(int index) {
		this.move(this.moves.get(index));
	}

	/**
	 * move-setter
	 *
	 * @param m the move to set
	 */
	public void move(Move m) {
		if (!m.equals(this.move)) {
			this.move = m;
			this.notifyListeners();
		}
	}

	/**
	 * move-getter.
	 *
	 * @return the move
	 */
	public Move move() {
		return this.move;
	}

	/**
	 * moves-getter.
	 *
	 * @return the moves
	 */
	public List<Move> moves() {
		return this.moves;
	}
}
