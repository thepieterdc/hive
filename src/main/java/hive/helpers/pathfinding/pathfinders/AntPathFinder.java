package hive.helpers.pathfinding.pathfinders;

import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Move;
import hive.helpers.pathfinding.PathFinder;

/**
 * PathFinder: Ant.
 * <p>
 * Created at 30/04/16 15:56
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class AntPathFinder extends PathFinder {
	@Override
	public String toString() {
		return "AntPathFinder[]";
	}

	@Override
	public boolean valid(BoardState state, Move m, HexCoordinate dest) {
		return this.pathFind(state, m.unit(), dest);
	}
}
