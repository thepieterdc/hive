package hive.models;

import hive.components.UnitPane;
import hive.components.hexagons.UnitHexagon;
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

	protected HiveModel(List<Move> moveList) {
		this.boardStates = new HashMap<>(100);
		this.boardStates.putAll(BoardState.unmarshal(moveList));

		this.moves = new ArrayList<>(moveList);

		this.totalMoves = this.moves.size();
	}

	public BoardState boardState() {
		return this.boardStates.get(this.moveIndex);
	}

	public abstract UnitHexagon callback_UnitPane(UnitPane u, UnitHexagon uH);

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

	public abstract void move(Move m);

	public Move move() {
		return this.move;
	}

	public int moveIndex() {
		return this.moveIndex;
	}

	public List<Move> moves() {
		return Collections.unmodifiableList(this.moves);
	}

	public int totalMoves() {
		return this.totalMoves;
	}

	public Unit[] units() {
		return this.units.clone();
	}
}
