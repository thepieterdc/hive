package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.components.UnitHexagon;
import be.thepieterdc.hive.exceptions.UnmarshallException;
import be.thepieterdc.hive.helpers.moves.FirstMove;
import be.thepieterdc.hive.helpers.moves.StartMove;
import javafx.scene.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a state of the board.
 * <p>
 * Created at 19/03/16 21:41
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class BoardState {
	private final HashMap<Coordinate, Node> state = new HashMap<>();

	private BoardState(FirstMove f) {
		this.state.put(new Coordinate(0, 0), new UnitHexagon(f.unit()));
	}

	private BoardState(StartMove s) {
		this.state.put(new Coordinate(0, 0), null);
	}

	private static BoardState calculate(BoardState previous, Move move) {
		return previous;
	}

	public static HashMap<Integer, BoardState> unmarshall(List<Move> moves) throws UnmarshallException {
		if(moves.size() == 0) throw new UnmarshallException("List of moves is empty.");
		if(!(moves.get(0) instanceof StartMove)) throw new UnmarshallException("Start move is not instance of StartMove.");

		HashMap<Integer, BoardState> map = new HashMap<>();

		map.put(0, new BoardState((StartMove) moves.get(0)));

		if(moves.size() == 1) {
			return map;
		}

		if(!(moves.get(1) instanceof FirstMove)) throw new UnmarshallException("First move is not instance of FirstMove.");

		map.put(1, new BoardState((FirstMove) moves.get(1)));

		for(int moveIndex = 2; moveIndex < moves.size(); moveIndex++) {
			map.put(moveIndex, calculate(map.get(moveIndex-1), moves.get(moveIndex)));
		}

		for(Map.Entry<Integer, BoardState> e : map.entrySet()) {
			System.out.println(e.getKey()+"-----------------------------");
			for(Map.Entry<Coordinate, Node> n : e.getValue().state.entrySet()) {
				System.out.println(n.getKey());
				System.out.println(n.getValue());
			}
		}
		return map;
	}

	public HashMap<Coordinate, Node> state() {
		return this.state;
	}
}
