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
		return pathExistsRecursion(begin, dest, state, length, new HashSet<>(9));
	}

	private static boolean pathExistsRecursion(HexCoordinate begin, HexCoordinate dest, BoardState state, int length, Set<HexCoordinate> visited) {
		if(begin.equals(dest)) {
			return true;
		} else if(length == 0 || begin.distanceTo(dest) > length) {
			return false;
		} else {
			Set<HexCoordinate> neighbours = state.freeNeighbours(begin);
			System.out.println(neighbours.size());
			if(length == 1) {
				return neighbours.contains(dest);
			}
			Set<HexCoordinate> toCheck = state.freeNeighbours(begin);
			toCheck.removeIf(visited::contains);

			for(HexCoordinate n : toCheck) {
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
