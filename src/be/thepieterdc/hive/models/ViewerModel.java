package be.thepieterdc.hive.models;

import be.thepieterdc.hive.helpers.BoardState;
import be.thepieterdc.hive.helpers.Model;
import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.helpers.Player;

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
	private final Player player1;
	private final Player player2;

	private final int totalMoves;

	public ViewerModel(final List<Move> moves, final HashMap<Integer, BoardState> states, final Player player1, final Player player2) {
		this.boardStates = states;
		this.moves = moves;
		this.player1 = player1;
		this.player2 = player2;
		this.totalMoves = this.moves.size();
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

	public Player player(String id) {
		if(this.player1.id().equals(id)) {
			return this.player1;
		} else if(this.player2.id().equals(id)) {
			return this.player2;
		}
		throw new IllegalArgumentException("Player not found for id: "+id);
	}

	public Player player1() {
		return this.player1;
	}

	public Player player2() {
		return this.player2;
	}

	public int totalMoves() {
		return this.totalMoves;
	}
}
