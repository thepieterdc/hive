package hive.helpers;

import java.util.HashSet;
import java.util.Set;

/**
 * Pathfinding functions.
 * <p>
 * Created at 23/04/16 16:37
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class PathFinding {
	public static boolean pathExists(HexCoordinate begin, HexCoordinate dest, BoardState state, int length) {
		System.out.println("Distance: "+length);
		return pathExistsRecursion(begin, dest, state, length, new HashSet<>(9));
	}

	private static boolean pathExistsRecursion(HexCoordinate begin, HexCoordinate dest, BoardState state, int length, Set<HexCoordinate> visited) {
		if(begin.distanceTo(dest) > length) {
			return false;
		} else if(begin.equals(dest) && length == 0) {
			return true;
		} else {
			Set<HexCoordinate> neighbours = state.freeNeighbours(begin, visited);
			if(length == 1) {
				return neighbours.contains(dest);
			}

			for(HexCoordinate n : neighbours) {
				visited.add(begin);
				if(pathExistsRecursion(n, dest, state, length-1, visited)) {
					return true;
				}
				visited.remove(begin);
			}
		}
		return false;
	}
}
