package hive.helpers.pathfinding;

import hive.helpers.HexCoordinate;

import java.util.List;

/**
 * A path/route between 2 HexCoordinates.
 * <p>
 * Created at 28/04/16 20:32
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Path {
	private final HexCoordinate[] coordinates;
	private final int tiles;

	public Path(HexCoordinate... coords) {
		this.coordinates = coords.clone();
		this.tiles = this.coordinates.length - 1;
	}

	public Path(List<HexCoordinate> coords) {
		this(coords.toArray(new HexCoordinate[coords.size()]));
	}

	public HexCoordinate first() {
		return this.coordinates[0];
	}

	public HexCoordinate last() {
		return this.coordinates[this.tiles - 1];
	}

	public String representation() {
		StringBuilder sb = new StringBuilder(this.coordinates.length * 50);
		for (HexCoordinate hc : this.coordinates) {
			sb.append(hc);
			sb.append(", ");
		}
		return sb.toString();
	}

	public int tiles() {
		return this.tiles;
	}

	@Override
	public String toString() {
		return "Path[tiles=" + this.tiles + ", coordinates={" + this.representation() + "}]";
	}
}
