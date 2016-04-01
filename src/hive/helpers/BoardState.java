package hive.helpers;

import hive.TransferPiece;
import hive.components.DefaultHexagon;
import hive.components.UnitHexagon;
import hive.data.Orientation;
import hive.exceptions.UnmarshalException;
import hive.helpers.moves.FirstMove;
import hive.helpers.moves.StartMove;
import javafx.scene.Node;

import java.util.*;

/**
 * A state of the playfield; which units are on which coordinate.
 * <p>
 * Created at 19/03/16 21:41
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class BoardState {
	private final HashMap<HexCoordinate, Node> coordinates;
	private final HashMap<Unit, HexCoordinate> units = new HashMap<>(22);

	/**
	 * BoardState constructor.
	 *
	 * @param f the first move
	 */
	private BoardState(FirstMove f) {
		this.coordinates = new HashMap<>(surroundings(new HexCoordinate(0, 0)));
		this.coordinates.put(new HexCoordinate(0, 0), new UnitHexagon(f.unit()));

		this.units.put(f.unit(), new HexCoordinate(0, 0));
	}

	/**
	 * BoardState constructor.
	 *
	 * @param u a map of the units and their coordinates
	 */
	private BoardState(Map<Unit, HexCoordinate> u) {
		this.coordinates = new HashMap<>(surroundings(u));
		this.units.putAll(u);
	}

	/**
	 * BoardState constructor.
	 * <p><i>Represents a StartMove.</i></p>
	 */
	private BoardState() {
		this.coordinates = new HashMap<>(1);
		this.coordinates.put(new HexCoordinate(0, 0), new DefaultHexagon());
	}

	/**
	 * Calculates the next BoardState from a given BoardState.
	 *
	 * @param previous the previous(current) BoardState
	 * @param move     the move to apply to the given BoardState
	 * @return the next BoardState
	 */
	private static BoardState calculate(BoardState previous, Move move) {
		HashMap<Unit, HexCoordinate> unitsMap = new HashMap<>(previous.units());
		if (!unitsMap.containsKey(move.otherUnit())) {
			throw new UnmarshalException("Other unit not on board: " + move.otherUnit().type());
		}
		unitsMap.put(move.unit(), HexCoordinate.fromOrientation(unitsMap.get(move.otherUnit()), move.orientation()));
		return new BoardState(unitsMap);
	}

	/**
	 * @return a map of hexagonal coordinates and nodes
	 */
	public Map<HexCoordinate, Node> coordinates() {
		return Collections.unmodifiableMap(this.coordinates);
	}

	/**
	 * Calculates the surrounding hexagons for a given "center" hexagon.
	 *
	 * @param c the hexagonal coordinate
	 * @return the surrounding hexagons of the given hexagonal coordinate
	 */
	private static Map<HexCoordinate, Node> surroundings(HexCoordinate c) {
		Map<HexCoordinate, Node> surrounds = new HashMap<>(7);
		for (Orientation o : Orientation.values()) {
			surrounds.put(HexCoordinate.fromOrientation(c, o), new DefaultHexagon());
		}
		return surrounds;
	}

	/**
	 * Calculates the surrounding hexagons for a given swarm of hexagons.
	 *
	 * @param m the map of hexagons
	 * @return a map of hexagonal coordinates and their surroudings
	 */
	private static Map<HexCoordinate, Node> surroundings(Map<Unit, HexCoordinate> m) {
		Map<HexCoordinate, Node> surrounds = new HashMap<>(m.size() * 7);
		for (Map.Entry<Unit, HexCoordinate> e : m.entrySet()) {
			surrounds.put(e.getValue(), new UnitHexagon(e.getKey()));
			surroundings(e.getValue()).forEach(surrounds::putIfAbsent);
		}
		return surrounds;
	}

	@Override
	public String toString() {
		return "BoardState[hexagons=" + this.coordinates.size() + ", units=" + this.units.size() + ']';
	}

	/**
	 * Converts a BoardState to a list of TransferPieces.
	 *
	 * @return the list of TransferPiece objects
	 */
	public List<TransferPiece> transferPieces() {
		List<TransferPiece> lijst = new ArrayList<>(this.units.size());
		for (Map.Entry<Unit, HexCoordinate> unitHexCoordinateEntry : this.units.entrySet()) {
			Unit u = unitHexCoordinateEntry.getKey();
			HexCoordinate c = unitHexCoordinateEntry.getValue();
			lijst.add(new TransferPiece(u.type().abbreviation(), u.player().id(), u.rank(), c.row(), c.column()));
		}
		Collections.sort(lijst);
		return lijst;
	}

	/**
	 * @return the map of units on the BoardState
	 */
	public Map<Unit, HexCoordinate> units() {
		return Collections.unmodifiableMap(this.units);
	}

	/**
	 * Unmarshals a list of moves.
	 *
	 * @param moves the list of moves
	 * @return a map of BoardStates for every move
	 */
	public static HashMap<Integer, BoardState> unmarshal(List<Move> moves) {
		if (moves == null) {
			throw new IllegalArgumentException("Parameter \"moves\" is null.");
		}
		if (moves.isEmpty()) {
			throw new UnmarshalException("List of moves is empty.");
		}
		if (!(moves.get(0) instanceof StartMove)) {
			moves.add(0, new StartMove());
		}

		HashMap<Integer, BoardState> boardStates = new HashMap<>(50);
		boardStates.put(0, new BoardState());

		if (moves.size() == 1) {
			return boardStates;
		}

		if (!(moves.get(1) instanceof FirstMove)) {
			throw new UnmarshalException("First move is not instance of FirstMove.");
		}

		boardStates.put(1, new BoardState((FirstMove) moves.get(1)));

		int totalMoves = moves.size();
		for (int moveIndex = 2; moveIndex < totalMoves; moveIndex++) {
			boardStates.put(moveIndex, calculate(boardStates.get(moveIndex - 1), moves.get(moveIndex)));
		}
		return boardStates;
	}
}
