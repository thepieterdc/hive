package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.components.DefaultHexagon;
import be.thepieterdc.hive.components.UnitHexagon;
import be.thepieterdc.hive.data.Orientation;
import be.thepieterdc.hive.exceptions.UnmarshalException;
import be.thepieterdc.hive.helpers.moves.FirstMove;
import be.thepieterdc.hive.helpers.moves.StartMove;
import javafx.scene.Node;

import java.util.*;

/**
 * Represents a state of the board.
 * <p>
 * Created at 19/03/16 21:41
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class BoardState {
	private final HashMap<HexCoordinate, Node> coordinates = new HashMap<>();
	private final HashMap<Unit, HexCoordinate> units = new HashMap<>();

	private BoardState(FirstMove f) {
		//Hermaken//
		this.coordinates.putAll(surroundings(new HexCoordinate(0, 0), new UnitHexagon(f.unit())));
		this.units.put(f.unit(), new HexCoordinate(0, 0));
	}

	private BoardState(HashMap<Unit, HexCoordinate> unitsMap) {
		this.coordinates.putAll(surroundingsFromUnits(unitsMap));
		this.units.putAll(unitsMap);
	}

	//TODO: parameter verwijderen?
	private BoardState(StartMove s) {
		this.coordinates.put(new HexCoordinate(0, 0), new DefaultHexagon());
	}

	private static BoardState calculate(BoardState previous, Move move) {
		HashMap<Unit, HexCoordinate> unitsMap = new HashMap<>(previous.units);
		if(!unitsMap.containsKey(move.otherUnit())) {
			throw new UnmarshalException("Other unit not on board: "+move.otherUnit().type());
		}
		unitsMap.put(move.unit(), HexCoordinate.fromOrientation(unitsMap.get(move.otherUnit()), move.orientation()));
		return new BoardState(unitsMap);
	}

	public HashMap<HexCoordinate, Node> coordinates() {
		return this.coordinates;
	}

	//TODO misschien(zeker) omwisselen; dat deze surroundings alles berekent//
	private static HashMap<HexCoordinate, Node> surroundings(HexCoordinate c, Node n) {
		HashMap<HexCoordinate, Node> m = new HashMap<>();
		m.put(c, n);
		return surroundingsFromCoords(m);
	}

	private static HashMap<HexCoordinate, Node> surroundingsFromUnits(HashMap<Unit, HexCoordinate> m) {
		HashMap<HexCoordinate, Node> surrounds = new HashMap<>();
		for(Map.Entry<Unit, HexCoordinate> entry : m.entrySet()) {
			HexCoordinate c = entry.getValue();
			surrounds.put(c, new UnitHexagon(entry.getKey()));

			for(Orientation o : Orientation.values()) {
				HexCoordinate coord = HexCoordinate.fromOrientation(c, o);
				if(!m.containsValue(coord)) {
					surrounds.put(coord, new DefaultHexagon());
				}
			}
		}
		return surrounds;
	}

	private static HashMap<HexCoordinate, Node> surroundingsFromCoords(HashMap<HexCoordinate, Node> m) {
		HashMap<HexCoordinate, Node> surrounds = new HashMap<>();
		for(Map.Entry<HexCoordinate, Node> entry : m.entrySet()) {
			HexCoordinate c = entry.getKey();
			if(entry.getValue() != null) {
				surrounds.put(entry.getKey(), entry.getValue());
			}

			for(Orientation o : Orientation.values()) {
				HexCoordinate coord = HexCoordinate.fromOrientation(c, o);
				if(!m.containsKey(coord)) {
					surrounds.put(coord, new DefaultHexagon());
				}
			}
		}
		return surrounds;
	}

	@Override
	public String toString() {
		return "BoardState[hexagons="+this.coordinates.size()+", units="+this.units.size()+"]";
	}

	public List<TransferPiece> transferPieces() {
		List<TransferPiece> lijst = new ArrayList<>();
		for (Map.Entry<Unit, HexCoordinate> unitHexCoordinateEntry : this.units.entrySet()) {
			Unit u = unitHexCoordinateEntry.getKey();
			HexCoordinate c = unitHexCoordinateEntry.getValue();
			lijst.add(new TransferPiece(u.type().abbreviation(), u.player().id(), u.rank(), c.row(), c.column()));
		}
		Collections.sort(lijst);
		return lijst;
	}

	public HashMap<Unit, HexCoordinate> units() {
		return this.units;
	}

	public static HashMap<Integer, BoardState> unmarshal(List<Move> moves) throws UnmarshalException {
		if(moves.size() == 0) throw new UnmarshalException("List of moves is empty.");
		if(!(moves.get(0) instanceof StartMove)) throw new UnmarshalException("Start move is not instance of StartMove.");

		HashMap<Integer, BoardState> map = new HashMap<>();

		map.put(0, new BoardState((StartMove) moves.get(0)));

		if(moves.size() == 1) {
			return map;
		}

		if(!(moves.get(1) instanceof FirstMove)) throw new UnmarshalException("First move is not instance of FirstMove.");

		map.put(1, new BoardState((FirstMove) moves.get(1)));

		for(int moveIndex = 2; moveIndex < moves.size(); moveIndex++) {
			map.put(moveIndex, calculate(map.get(moveIndex-1), moves.get(moveIndex)));
		}
		return map;
	}
}
