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
	public String toString() {
		return "ContinuousContactValidator[]";
	}

	@Override
	public boolean valid(BoardState state) {
		return walk(state) == state.units().size();
	}

	/**
	 * @param state the current boardstate
	 * @return the amount of tiles traversed
	 */
	private static int walk(BoardState state) {
		return walkRecursion(state, state.unitCoordinates().get(0), new HashSet<>(state.units().size())).size();
	}

	/**
	 * @param state the current boardstate
	 * @param coord the current coordinate to check
	 * @param skip  the coordinates already passed
	 * @return the list of coordinates traversed
	 */
	private static Collection<HexCoordinate> walkRecursion(BoardState state, HexCoordinate coord, Set<HexCoordinate> skip) {
		if (!skip.contains(coord)) {
			skip.add(coord);

			for (HexCoordinate c : state.neighbours(coord).values()) {
				skip.addAll(walkRecursion(state, c, skip));
			}
		}
		return skip;
	}
}
