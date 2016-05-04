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

	/**
	 * PathFinder constructor.
	 */
	protected PathFinder() {
		this.validators = new HashSet<>(2);
		this.validators.add(new SingleSwarmValidator());
		this.validators.add(new ContinuousContactValidator());
	}

	/**
	 * Returns true if the Unit can navigate to another coordinate by verifying there is enough space.
	 * <br>Also checks if there is 1 common neighbour; required for asserting that a Unit never leaves the swarm.
	 *
	 * @param state the boardstate
	 * @param start the current coordinate
	 * @param dest  the destination coordinate
	 * @return true if the unit can move to the destination coordinate
	 */
	protected static boolean canPassThrough(BoardState state, HexCoordinate start, HexCoordinate dest) {
		return HexCoordinate.surroundings(start).stream().filter(h -> dest.distanceTo(h) == 1).mapToInt(h -> state.free(h) ? 0 : 1).sum() % 2 != 0;
	}

	/**
	 * Checks if there is a path between the current location of the unit and the destination coordinate.
	 *
	 * @param state the current boardstate
	 * @param u     the unit
	 * @param dest  the destination coordinate
	 * @return true if the unit can reach the coordinate
	 */
	protected boolean pathFind(BoardState state, Unit u, HexCoordinate dest) {
		return this.pathFindRecursion(state, u, dest, new HashSet<>(state.freeHexagons().size()));
	}

	/**
	 * Checks if there is a path between the current location of the unit and the destination coordinate in a given.
	 * amount of steps.
	 *
	 * @param state  the current boardstate
	 * @param u      the unit
	 * @param dest   the destination coordinate
	 * @param length the amount of steps
	 * @return true if the unit can reach the coordinate in the given amount of steps
	 */
	protected boolean pathFindExact(BoardState state, Unit u, HexCoordinate dest, int length) {
		return this.pathFindExactRecursion(state, u, dest, new HashSet<>(state.freeHexagons().size()), length);
	}

	/**
	 * The backtracking algorithm for PathFinder#pathFindExact.
	 *
	 * @param state  the current boardstate
	 * @param u      the unit
	 * @param dest   the destination coordinate
	 * @param path   the temporary path
	 * @param length the desired length
	 * @return
	 */
	private boolean pathFindExactRecursion(BoardState state, Unit u, HexCoordinate dest, Collection<HexCoordinate> path, int length) {
		if (u.location().equals(dest) && length == 0) {
			return this.validState(state);
		}
		if (length == 0) {
			return false;
		}
		HexCoordinate start = u.location();
		for (HexCoordinate h : state.freeNeighbours(u.location())) {
			if (!path.contains(h) && canPassThrough(state, start, h)) {
				path.add(h);
				u.location(h);
				BoardState newState = BoardState.calculate(state, u, h);
				if (this.validState(newState) && this.pathFindExactRecursion(newState, u, dest, path, length - 1)) {
					return true;
				}
				u.location(start);
				path.remove(h);
			}
		}
		return false;
	}

	/**
	 * The backtracking algorithm for PathFinder#pathFind.
	 *
	 * @param state the current boardstate
	 * @param u     the unit
	 * @param dest  the destination coordinate
	 * @param path  the temporary path
	 * @return true if the unit can reach the destination coordinate
	 */
	private boolean pathFindRecursion(BoardState state, Unit u, HexCoordinate dest, Collection<HexCoordinate> path) {
		if (u.location().equals(dest)) {
			return this.validState(state);
		}
		HexCoordinate start = u.location();
		for (HexCoordinate h : state.freeNeighbours(u.location())) {
			if (!path.contains(h) && canPassThrough(state, start, h)) {
				path.add(h);
				u.location(h);
				BoardState newState = BoardState.calculate(state, u, h);
				if (this.validState(newState) && this.pathFindRecursion(newState, u, dest, path)) {
					return true;
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

	/**
	 * Validates the unit movement.
	 *
	 * @param state the current boardstate
	 * @param m     the move to apply
	 * @param dest  the destination of the unit
	 * @return true if the unit can move to the destination coordinate
	 */
	public abstract boolean valid(BoardState state, Move m, HexCoordinate dest);

	/**
	 * Validates a given boardstate.
	 *
	 * @param s the boardstate to validate
	 * @return true if the boardstate is valid
	 */
	protected boolean validState(BoardState s) {
		for (Validatable<BoardState> v : this.validators) {
			if (!v.valid(s)) {
				return false;
			}
		}
		return true;
	}
}
