package hive.helpers.statevalidators;

import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Unit;
import hive.interfaces.Validatable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Validates rule "Single Swarm".
 * <p>
 * Created at 30/04/16 11:57
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class SingleSwarmValidator implements Validatable<BoardState> {

	@Override
	public boolean valid(BoardState state) {
		return walk(state) == state.units().size();
	}

	private static int walk(BoardState state) {
		return walkRecursion(state, state.unitCoordinates().get(0), new HashSet<>(state.units().size())).size();
	}

	private static Collection<HexCoordinate> walkRecursion(BoardState state, HexCoordinate coord, Set<HexCoordinate> skip) {
		if (!skip.contains(coord)) {
			skip.add(coord);

			for (Map.Entry<Unit, HexCoordinate> n : state.neighbours(coord).entrySet()) {
				skip.addAll(walkRecursion(state, n.getValue(), skip));
			}
		}
		return skip;
	}
}
