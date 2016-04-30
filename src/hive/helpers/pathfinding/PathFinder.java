package hive.helpers.pathfinding;

import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Move;
import hive.helpers.statevalidators.ContinuousContactValidator;
import hive.helpers.statevalidators.SingleSwarmValidator;
import hive.interfaces.Validatable;

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

	public abstract boolean valid(BoardState state, Move m, HexCoordinate dest);
}
