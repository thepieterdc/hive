package hive.helpers.pathfinding.pathfinders;

import hive.data.Orientation;
import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Move;
import hive.helpers.pathfinding.PathFinder;

/**
 * PathFinder: Grasshopper.
 * <p>
 * Created at 1/05/16 12:15
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class GrasshopperPathFinder extends PathFinder {
	@Override
	public String toString() {
		return "GrasshopperPathFinder[]";
	}

	@Override
	public boolean valid(BoardState state, Move m, HexCoordinate dest) {
		final int dist = m.unit().location().distanceTo(dest);
		double cD = (dest.column() - m.unit().location().column()) / (double) dist;
		double rD = (dest.row() - m.unit().location().row()) / (double) dist;

		if (Math.floor(cD) != cD || Math.floor(rD) != rD) {
			return false;
		}

		Orientation o = Orientation.fromDeltas((int) cD, (int) rD);

		HexCoordinate c = m.unit().location();
		BoardState newState = state;
		for(int i = 0; i < dist; i++) {
			c = HexCoordinate.fromOrientation(c, o);
			if(state.free(c) && !c.equals(dest)) {
				return false;
			}
			newState = BoardState.calculate(newState, m.unit(), c);
			if(!this.validState(newState)) {
				return false;
			}
		}
		return c.equals(dest);
	}
}
