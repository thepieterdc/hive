package hive.helpers;

import hive.TransferPiece;
import hive.data.Orientation;
import hive.exceptions.UnmarshalException;
import hive.helpers.moves.FirstMove;
import hive.helpers.moves.StartMove;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A state of the playfield; which units are on which coordinate.
 * <p>
 * Created at 19/03/16 21:41
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class BoardState {
	private final Set<HexCoordinate> freeHexagons;
	private final Map<Unit, HexCoordinate> units = new HashMap<>(22);

	public static class Dimensions {
		public final int hMax;
		public final int hMin;
		public final int vMax;
		public final int vMin;

		public Dimensions(int hMax, int hMin, int vMax, int vMin) {
			this.hMax = hMax;
			this.hMin = hMin;
			this.vMax = vMax;
			this.vMin = vMin;
		}
	}

	/**
	 * BoardState constructor.
	 *
	 * @param f the first move
	 */
	private BoardState(FirstMove f) {
		this.freeHexagons = HexCoordinate.surroundings(new HexCoordinate(0, 0));
		this.units.put(f.unit(), new HexCoordinate(0, 0));
	}

	/**
	 * BoardState constructor.
	 *
	 * @param u a map of the units and their coordinates
	 */
	private BoardState(Map<Unit, HexCoordinate> u) {
		this.units.putAll(u);
		this.freeHexagons = surroundings(this.units);
	}

	/**
	 * BoardState constructor.
	 * <p><i>To be used for a StartMove.</i></p>
	 */
	private BoardState() {
		this.freeHexagons = Collections.singleton(new HexCoordinate(0, 0));
	}

	/**
	 * Calculates the BoardState for the FirstMove.
	 *
	 * @param previous the previous(current) BoardState.
	 * @param move     the firstmove to apply to the given BoardState
	 * @return the next BoardState
	 */
	public static BoardState calculate(FirstMove first) {
		return new BoardState(first);
	}

	/**
	 * Calculates the next BoardState from a given BoardState.
	 *
	 * @param previous the previous(current) BoardState
	 * @param move     the move to apply to the given BoardState
	 * @return the next BoardState
	 * @throws UnmarshalException the moves could not be translated to game states
	 */
	public static BoardState calculate(BoardState previous, Move move) {
		HashMap<Unit, HexCoordinate> unitsMap = new HashMap<>(previous.units());
		if (!unitsMap.containsKey(move.otherUnit())) {
			throw new UnmarshalException("Other unit not on board: " + move.otherUnit().type());
		}
		unitsMap.put(move.unit(), HexCoordinate.fromOrientation(unitsMap.get(move.otherUnit()), move.orientation()));
		return new BoardState(unitsMap);
	}

	//Hexagons overlopen is genoeg aangezien units nooit op de rand kunnen staan//
	public BoardState.Dimensions dimensions() {
		int hMax = 0;
		int hMin = 0;
		int vMax = 0;
		int vMin = 0;
		for (HexCoordinate c : this.freeHexagons) {
			hMax = Math.max(hMax, c.row());
			hMin = Math.min(hMax, c.row());
			vMax = Math.max(hMax, c.column());
			vMin = Math.min(hMax, c.column());
		}
		return new BoardState.Dimensions(hMax, hMin, vMax, vMin);
	}

	public boolean free(HexCoordinate c) {
		return this.freeHexagons.contains(c);
	}

	public Set<HexCoordinate> freeHexagons() {
		return Collections.unmodifiableSet(this.freeHexagons);
	}

	public Set<HexCoordinate> freeNeighbours(HexCoordinate c) {
		return this.freeNeighbours(c, Collections.emptySet());
	}

	public Set<HexCoordinate> freeNeighbours(HexCoordinate c, Collection<HexCoordinate> skip) {
		return HexCoordinate.surroundings(c).stream().filter(h -> freeHexagons.contains(h) && !skip.contains(h)).collect(Collectors.toSet());
	}

	public Map<Unit, HexCoordinate> neighbours(HexCoordinate h) {
		return this.units.entrySet().stream().filter(e -> Orientation.fromHexCoordinates(h, e.getValue()) != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	/**
	 * Calculates the surrounding hexagons for a given swarm of hexagons.
	 *
	 * @param m the map of hexagons
	 * @return a map of hexagonal coordinates and their surroundings
	 */
	private static Set<HexCoordinate> surroundings(Map<Unit, HexCoordinate> m) {
		Collection<HexCoordinate> unitCoords = m.entrySet().stream().collect(HashSet::new, (h, e) -> h.add(e.getValue()), HashSet::addAll);
		return m.entrySet().stream().collect(HashSet::new, (h, e) -> h.addAll(HexCoordinate.surroundings(e.getValue(), unitCoords)), HashSet::addAll);
	}

	@Override
	public String toString() {
		return "BoardState[freeHexagons=" + this.freeHexagons.size() + ", units=" + this.units.size() + ']';
	}

	/**
	 * Converts a BoardState to a list of TransferPieces.
	 *
	 * @return the list of TransferPiece objects
	 */
	public List<TransferPiece> transferPieces() {
		List<TransferPiece> lijst = this.units.entrySet().stream().map(e -> new TransferPiece(e.getKey().type().abbreviation(), e.getKey().player().id(), e.getKey().rank(), e.getValue().row(), e.getValue().column())).collect(Collectors.toList());
		Collections.sort(lijst);
		return lijst;
	}

	public Unit unit(HexCoordinate c) {
		return this.units.entrySet().stream().filter(e -> e.getValue().equals(c)).map(Map.Entry::getKey).findFirst().orElse(null);
	}

	/**
	 * @return the map of units in the BoardState
	 */
	public Map<Unit, HexCoordinate> units() {
		return Collections.unmodifiableMap(this.units);
	}

	/**
	 * Unmarshals a list of moves.
	 *
	 * @param moves the list of moves
	 * @return a map of BoardStates for every move
	 * @throws UnmarshalException the moves could not be translated to game states
	 */
	public static Map<Integer, BoardState> unmarshal(List<Move> moves) {
		if (moves == null) {
			throw new IllegalArgumentException("Parameter \"moves\" is null.");
		}
		if (moves.isEmpty()) {
			throw new UnmarshalException("List of moves is empty.");
		}
		if (moves.get(0).type() != Move.MoveType.START) {
			moves.add(0, new StartMove());
		}

		HashMap<Integer, BoardState> boardStates = new HashMap<>(50);
		boardStates.put(0, new BoardState());

		if (moves.size() == 1) {
			return boardStates;
		}

		if (moves.get(1).type() != Move.MoveType.FIRST) {
			throw new UnmarshalException("First move is not instance of FirstMove.");
		}

		boardStates.put(1, new BoardState((FirstMove) moves.get(1)));

		IntStream.range(2, moves.size()).forEach(i -> boardStates.put(i, calculate(boardStates.get(i - 1), moves.get(i))));

		return boardStates;
	}
}
