package hive.helpers.pathfinding;

import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Unit;

/**
 * Finds paths between two hexagons.
 * <p>
 * Created at 29/04/16 19:28
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public abstract class PathFinder {
	public abstract boolean reachable(BoardState state, Unit u, HexCoordinate dest);
}
