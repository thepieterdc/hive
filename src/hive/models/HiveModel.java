package hive.models;

import hive.helpers.BoardState;
import hive.helpers.Model;
import hive.helpers.Move;
import hive.helpers.Unit;

import java.util.*;

/**
 * Model that can be used both for the PlayMode and the Viewer mode.
 * <p>
 * Created at 14/04/16 16:27
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public abstract class HiveModel extends Model {
	protected final Map<Integer, BoardState> boardStates;
	protected Move move;
	protected int moveIndex;
	protected final List<Move> moves;
	protected int totalMoves;
	protected final Unit[] units = new Unit[22];

	/**
	 * HiveModel constructor.
	 *
	 * @param moveList the list of moves
	 */
	protected HiveModel(List<Move> moveList) {
		this.boardStates = new HashMap<>(100);
		this.boardStates.putAll(BoardState.unmarshal(moveList));

		this.moves = new ArrayList<>(moveList);

		this.totalMoves = this.moves.size();
	}

	/**
	 * @return the current state
	 */
	public BoardState boardState() {
		return this.boardStates.get(this.moveIndex);
	}

	/**
	 * @return the boardstates
	 */
	public Map<Integer, BoardState> boardStates() {
		return Collections.unmodifiableMap(this.boardStates);
	}

	/**
	 * Displays a given move on the board.
	 *
	 * @param index the move to set
	 */
	public void move(int index) {
		if (index < 0 || index >= this.moves.size()) {
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
	 * @return the list of moves
	 */
	public List<Move> moves() {
		return Collections.unmodifiableList(this.moves);
	}

	/**
	 * @return the total amount of moves played
	 */
	public int totalMoves() {
		return this.totalMoves;
	}

	/**
	 * @return the array of units available
	 */
	public Unit[] units() {
		return this.units.clone();
	}
}
