package hive.helpers.pathfinding.pathfinders;

import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Move;
import hive.helpers.pathfinding.PathFinder;

/**
 * PathFinder: Spider.
 * <p>
 * Created at 1/05/16 12:03
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class SpiderPathFinder extends PathFinder {
	@Override
	public String toString() {
		return "SpiderPathFinder[]";
	}

	@Override
	public boolean valid(BoardState state, Move m, HexCoordinate dest) {
		return m.unit().location().distanceTo(dest) <= 3 && this.pathFindExact(state, m.unit(), dest, 3);
	}
}
