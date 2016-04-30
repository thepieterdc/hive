package hive.helpers.pathfinding;

import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Move;
import hive.helpers.Unit;
import hive.helpers.statevalidators.ContinuousContactValidator;
import hive.helpers.statevalidators.SingleSwarmValidator;
import hive.interfaces.Validatable;

import java.util.*;
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
		return state.freeNeighbours(start).stream().filter(h -> dest.distanceTo(h) == 1).collect(Collectors.toSet()).size() >= 1;
	}

	protected boolean pathFind(BoardState state, Unit u, HexCoordinate dest) {
		return this.pathFindRecursion(state, u, dest, new ArrayList<>(state.freeHexagons().size()));
	}

	private boolean pathFindRecursion(BoardState state, Unit u, HexCoordinate dest, Collection<HexCoordinate> path) {
		if(u.location().equals(dest)) {
			return true;
		}
		HexCoordinate start = u.location();
		for(HexCoordinate h : state.freeNeighbours(u.location())) {
			if(!path.contains(h)) {
				path.add(h);
				u.location(h);
				BoardState newState = BoardState.calculate(state, u, h);
				if(this.validState(newState)) {
					if (this.pathFindRecursion(newState, u, dest, path)) {
						return true;
					}
				}
				u.location(start);
				path.remove(h);
			}
		}
		return false;
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
