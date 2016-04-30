package hive.helpers.pathfinding;

import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Move;
import hive.helpers.statevalidators.ContinuousContactValidator;
import hive.helpers.statevalidators.SingleSwarmValidator;
import hive.interfaces.Validatable;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Finds paths between two hexagons.
 * <p>
 * Created at 29/04/16 19:28
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public abstract class PathFinder {
	protected final Set<Validatable<BoardState>> validators;

	protected PathFinder() {
		this.validators = new HashSet<>(2);
		this.validators.add(new SingleSwarmValidator());
		this.validators.add(new ContinuousContactValidator());
	}

	protected static boolean canPassThrough(BoardState state, HexCoordinate start, HexCoordinate dest) {
		return state.freeNeighbours(start).stream().filter(h -> dest.distanceTo(h) == 1).collect(Collectors.toSet()).size() == 2;
	}

	public abstract boolean valid(BoardState state, Move m, HexCoordinate dest);

	protected boolean validState(BoardState s) {
		for (Validatable<BoardState> v : this.validators) {
			if (!v.valid(s)) {
				return false;
			}
		}
		return true;
	}
}
