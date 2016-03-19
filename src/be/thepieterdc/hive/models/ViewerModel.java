package be.thepieterdc.hive.models;

import be.thepieterdc.hive.helpers.Model;
import be.thepieterdc.hive.helpers.Move;
import javafx.scene.paint.Color;

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

	private final Color player1;
	private final Color player2;

	private final int totalMoves;

	public ViewerModel(List<Move> moves, Color player1Color, Color player2Color) {
		this.moves = moves;
		this.player1 = player1Color;
		this.player2 = player2Color;
		this.totalMoves = this.moves.size();
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

	public Color player1() {
		return this.player1;
	}

	public Color player2() {
		return this.player2;
	}

	public int totalMoves() {
		return this.totalMoves;
	}
}
