package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.exceptions.UnmarshallException;
import be.thepieterdc.hive.helpers.moves.StartMove;
import javafx.scene.Node;

import java.util.HashMap;
import java.util.List;

/**
 * Represents a state of the board.
 * <p>
 * Created at 19/03/16 21:41
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class BoardState {
	private final HashMap<Coordinate, Node> state = new HashMap<>();

	public BoardState(StartMove s) {
		this.state.put(new Coordinate(0, 0), null);
	}

	public static BoardState calculate(BoardState previous, Move move) {
		System.out.println("TODO WRITE");
		return previous;
	}

	public static HashMap<Integer, BoardState> unmarshall(List<Move> moves) throws UnmarshallException {
		HashMap<Integer, BoardState> map = new HashMap<>();
		return map;
	}

	public HashMap<Coordinate, Node> state() {
		return this.state;
	}
}
