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

	private final Color player1Color;
	private final Color player2Color;

	private final int totalMoves;

	/**
	 * ViewerModel constructor.
	 * @param moves the moves to set
	 * @param player1Color the color for player 1
	 * @param player2Color the color for player 2
	 */
	public ViewerModel(List<Move> moves, Color player1Color, Color player2Color) {
		this.moves = moves;
		this.player1Color = player1Color;
		this.player2Color = player2Color;
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
	 * player1Color-getter.
	 * @return the color of player 1
	 */
	public Color player1Color() {
		return this.player1Color;
	}

	/**
	 * player2Color-getter.
	 * @return the color of player 2
	 */
	public Color player2Color() {
		return this.player2Color;
	}

	/**
	 * totalMoves-getter.
	 * @return the total amount of moves
	 */
	public int totalMoves() {
		return this.totalMoves;
	}
}
