package be.thepieterdc.hive.models;

import be.thepieterdc.hive.data.Player;
import be.thepieterdc.hive.data.UnitType;
import be.thepieterdc.hive.helpers.BoardState;
import be.thepieterdc.hive.helpers.Model;
import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.helpers.Unit;

import java.util.HashMap;
import java.util.List;

/**
 * Model for the Viewer part.
 * <p>
 * Created at 17/03/16 14:08
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class ViewerModel extends Model {
	private final HashMap<Integer, BoardState> boardStates;
	private Move move = null;
	private int moveIndex;
	private final List<Move> moves;
	private final int totalMoves;
	private final Unit[] units = new Unit[22];

	public ViewerModel(final List<Move> moves, final HashMap<Integer, BoardState> states) {
		this.boardStates = states;
		this.moves = moves;
		this.totalMoves = this.moves.size();
		this.addUnits();
	}

	private void addUnits() {
		int i = 0;
		for(Player p : Player.values()) {
			for (UnitType u : UnitType.values()) {
				int capacity = u.capacity();
				for (int c = 0; c < capacity; c++) {
					this.units[i] = new Unit(p, u, c + 1);
					i++;
				}
			}
		}
	}

	public BoardState boardState(int index) {
		return this.boardStates.get(index);
	}

	public BoardState boardState() {
		return this.boardState(this.moveIndex);
	}

	public void move(int index) {
		Move m = this.moves.get(index);
		if (!m.equals(this.move)) {
			this.moveIndex = index;
			this.move = m;
			this.notifyListeners();
		}
	}

	public void move(Move m) {
		this.move(this.moves.indexOf(m));
	}

	public Move move() {
		return this.move;
	}

	public int moveIndex() {
		return this.moveIndex;
	}

	public List<Move> moves() {
		return this.moves;
	}

	@Override
	public String toString() {
		return "ViewerModel[boardStates="+this.boardStates.size()+", move="+this.move.representation()+", moveIndex="+this.moveIndex+", totalmoves="+this.totalMoves+"]";
	}

	public int totalMoves() {
		return this.totalMoves;
	}

	public Unit[] units() {
		return this.units.clone();
	}
}
