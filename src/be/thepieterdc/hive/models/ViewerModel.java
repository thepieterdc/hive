package be.thepieterdc.hive.models;

import be.thepieterdc.hive.data.Player;
import be.thepieterdc.hive.data.UnitType;
import be.thepieterdc.hive.helpers.BoardState;
import be.thepieterdc.hive.helpers.Model;
import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.helpers.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Model for the Viewer part.
 * <p>
 * Created at 17/03/16 14:08
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class ViewerModel extends Model {
	private final HashMap<Integer, BoardState> boardStates;
	private Move move;
	private int moveIndex;
	private final List<Move> moves;
	private final int totalMoves;
	private final Unit[] units = new Unit[22];

	/**
	 * ViewerModel constructor.
	 * @param moveList the list of moves
	 * @param states the list of BoardStates
	 */
	public ViewerModel(List<Move> moveList, HashMap<Integer, BoardState> states) {
		if(moveList == null) {
			throw new IllegalArgumentException("Parameter \"moveList\" is null.");
		}
		if(states == null) {
			throw new IllegalArgumentException("Parameter \"states\" is null.");
		}
		this.boardStates = new HashMap<>(states);
		this.moves = new ArrayList<>(moveList);
		this.totalMoves = this.moves.size();
		this.addUnits();
	}

	/**
	 * Adds all units to the list of units.
	 */
	private void addUnits() {
		int i = 0;
		for (Player p : Player.values()) {
			for (UnitType u : UnitType.values()) {
				int capacity = u.capacity();
				for (int c = 0; c < capacity; c++) {
					this.units[i] = new Unit(p, u, c + 1);
					i++;
				}
			}
		}
	}

	/**
	 * @return the current BoardState.
	 */
	public BoardState boardState() {
		return this.boardStates.get(this.moveIndex);
	}

	/**
	 * Sets the current move to a new index.
	 * @param index the new move
	 */
	public void move(int index) {
		if(index < 0 || index >= this.moves.size()) {
			throw new IllegalArgumentException("Parameter \"index\" is out of bounds.");
		}
		Move m = this.moves.get(index);
		if (!m.equals(this.move)) {
			this.moveIndex = index;
			this.move = m;
			this.notifyListeners();
		}
	}

	/**
	 * Sets the current move to a new move.
	 * @param m the new move
	 */
	public void move(Move m) {
		if(m == null) {
			throw new IllegalArgumentException("Parameter \"move\" is null.");
		}
		this.move(this.moves.indexOf(m));
	}

	/**
	 * @return the current move
	 */
	public Move move() {
		return this.move;
	}

	/**
	 * @return the index of the current move
	 */
	public int moveIndex() {
		return this.moveIndex;
	}

	/**
	 * @return a list containing all the moves
	 */
	public List<Move> moves() {
		return Collections.unmodifiableList(this.moves);
	}

	@Override
	public String toString() {
		return "ViewerModel[boardStates=" + this.boardStates.size() + ", move=" + this.move.representation() + ", moveIndex=" + this.moveIndex + ", totalmoves=" + this.totalMoves + ']';
	}

	/**
	 * @return the total amount of moves
	 */
	public int totalMoves() {
		return this.totalMoves;
	}

	/**
	 * @return an array of all the playable units
	 */
	public Unit[] units() {
		return this.units.clone();
	}
}
