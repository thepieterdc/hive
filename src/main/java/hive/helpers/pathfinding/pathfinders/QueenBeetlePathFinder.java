package hive.helpers.pathfinding.pathfinders;

import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Move;
import hive.helpers.pathfinding.PathFinder;

/**
 * PathFinder: Queen, Beetle.
 * <p>
 * Created at 30/04/16 15:56
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class QueenBeetlePathFinder extends PathFinder {
	@Override
	public String toString() {
		return "QueenBeetlePathFinder[]";
	}

	@Override
	public boolean valid(BoardState state, Move m, HexCoordinate dest) {
		if (m.unit().location().distanceTo(dest) != 1) {
			return false;
		}
		BoardState newState = BoardState.calculate(state, m);
		return this.validState(newState) && PathFinder.canPassThrough(state, m.unit().location(), dest);
	}
}
