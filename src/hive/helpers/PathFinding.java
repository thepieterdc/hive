package hive.helpers;

import hive.data.Orientation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Pathfinding functions.
 * <p>
 * Created at 23/04/16 16:37
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class PathFinding {

	public static List<HexCoordinate> colinearPath(HexCoordinate begin, HexCoordinate dest) {
		int cD = begin.column() - dest.column();
		int rD = begin.row() - dest.row();

		Orientation o = Orientation.fromDeltas(MyMath.divide(cD, Math.abs(cD)), MyMath.divide(rD, Math.abs(rD)));
		List<HexCoordinate> coords = new ArrayList<>(begin.distanceTo(dest));
		for (int i = 1; i < begin.distanceTo(dest) - 1; i++) {
			coords.add(HexCoordinate.fromOrientation(coords.get(i-1), o));
		}
		coords.add(dest);
		return coords;
	}

	public static boolean pathExists(HexCoordinate begin, HexCoordinate dest, BoardState state, int length) {
		return pathExistsRecursion(begin, dest, state, length, new HashSet<>(9));
	}

	private static boolean pathExistsRecursion(HexCoordinate begin, HexCoordinate dest, BoardState state, int length, Set<HexCoordinate> visited) {
		if (begin.distanceTo(dest) > length) {
			return false;
		} else if (begin.equals(dest) && length == 0) {
			return true;
		} else {
			Set<HexCoordinate> neighbours = state.freeNeighbours(begin, visited);
			if (length == 1) {
				return neighbours.contains(dest);
			}

			for (HexCoordinate n : neighbours) {
				visited.add(begin);
				if (pathExistsRecursion(n, dest, state, length - 1, visited)) {
					return true;
				}
				visited.remove(begin);
			}
		}
		return false;
	}
}
