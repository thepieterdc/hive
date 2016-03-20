package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.components.DefaultHexagon;
import be.thepieterdc.hive.components.Hexagon;
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
	private final HashMap<GridCoordinate, Node> coordinates = new HashMap<>();
	private final HashMap<Unit, GridCoordinate> units = new HashMap<>();

	private BoardState(FirstMove f) {
		this.state.putAll(surroundings(new GridCoordinate(0, 0), new UnitHexagon(f.unit())));
	}

	private BoardState(HashMap<GridCoordinate, Node> state) {
		this.state.putAll(surroundings(state));
	}

	private BoardState(StartMove s) {
		this.state.put(new GridCoordinate(0, 0), null);
	}

	private static BoardState calculate(BoardState previous, Move move) {
		previous.state
		return previous;
	}

	public HashMap<GridCoordinate, Node> coordinates() {
		return this.coordinates;
	}

	//TODO misschien omwisselen; dat deze surroundings alles berekent//
	private static HashMap<GridCoordinate, Node> surroundings(GridCoordinate c, Node n) {
		HashMap<GridCoordinate, Node> m = new HashMap<>();
		m.put(c, n);
		return surroundings(m);
	}

	private static HashMap<GridCoordinate, Node> surroundings(HashMap<GridCoordinate, Node> m) {
		HashMap<GridCoordinate, Node> surrounds = new HashMap<>();
		for(Map.Entry<GridCoordinate, Node> entry : m.entrySet()) {
			GridCoordinate c = entry.getKey();
			if(entry.getValue() != null) {
				surrounds.put(entry.getKey(), entry.getValue());
			}
			for(int y = c.y()-1; y <= c.y()+1; y++) {
				GridCoordinate left = new GridCoordinate(c.x()-1, y);
				if(!m.containsKey(left)) {
					surrounds.put(left, new DefaultHexagon());
				}
				GridCoordinate right = new GridCoordinate(c.x()-1, y);
				if(!m.containsKey(right)) {
					surrounds.put(right, new DefaultHexagon());
				}
			}
		}
		return surrounds;
	}

	public HashMap<Unit, GridCoordinate> units() {
		return this.units;
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
			System.out.println("\n\n");
			System.out.println(e.getKey()+"-----------------------------");
			for(Map.Entry<GridCoordinate, Node> n : e.getValue().state.entrySet()) {
				System.out.println(n.getKey());
				System.out.println(n.getValue());
			}
		}
		return map;
	}
}
