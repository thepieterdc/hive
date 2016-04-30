package hive.helpers.pathfinding.pathfinders;

import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.pathfinding.Path;
import hive.helpers.pathfinding.PathFinder;

/**
 * Description here
 * <p>
 * Created at 29/04/16 19:36
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class QueenPathFinder implements PathFinder {
	@Override
	public Path[] find(BoardState state, HexCoordinate start, HexCoordinate dest) {
		return start.distanceTo(dest) == 1 ? new Path(start, dest) : null;
	}
}
