package hive.helpers.pathfinding;

import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Move;
import hive.helpers.Unit;
import hive.helpers.statevalidators.ContinuousContactValidator;
import hive.helpers.statevalidators.SingleSwarmValidator;
import hive.interfaces.Validatable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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

	//Also checks if there is 1 common neighbour//
	protected static boolean canPassThrough(BoardState state, HexCoordinate start, HexCoordinate dest) {
		return HexCoordinate.surroundings(start).stream().filter(h -> dest.distanceTo(h) == 1).mapToInt(h -> state.free(h) ? 0 : 1).sum() % 2 != 0;
	}

	protected boolean pathFind(BoardState state, Unit u, HexCoordinate dest) {
		return this.pathFindRecursion(state, u, dest, new HashSet<>(state.freeHexagons().size()));
	}

	protected boolean pathFindExact(BoardState state, Unit u, HexCoordinate dest, int length) {
		return this.pathFindExactRecursion(state, u, dest, new HashSet<>(state.freeHexagons().size()), length);
	}

	private boolean pathFindExactRecursion(BoardState state, Unit u, HexCoordinate dest, Collection<HexCoordinate> path, int length) {
		if(u.location().equals(dest) && length == 0) {
			return this.validState(state);
		}
		if(length == 0) {
			return false;
		}
		HexCoordinate start = u.location();
		for(HexCoordinate h : state.freeNeighbours(u.location())) {
			if(!path.contains(h) && canPassThrough(state, start, h)) {
				path.add(h);
				u.location(h);
				BoardState newState = BoardState.calculate(state, u, h);
				if(this.validState(newState)) {
					if (this.pathFindExactRecursion(newState, u, dest, path, length-1)) {
						return true;
					}
				}
				u.location(start);
				path.remove(h);
			}
		}
		return false;
	}

	private boolean pathFindRecursion(BoardState state, Unit u, HexCoordinate dest, Collection<HexCoordinate> path) {
		if(u.location().equals(dest)) {
			System.out.println(state.units().size());
			return this.validState(state);
		}
		HexCoordinate start = u.location();
		for(HexCoordinate h : state.freeNeighbours(u.location())) {
			if(!path.contains(h) && canPassThrough(state, start, h)) {
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

	@Override
	public String toString() {
		return "PathFinder[]";
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
