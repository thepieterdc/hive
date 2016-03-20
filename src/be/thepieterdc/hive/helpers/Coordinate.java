package be.thepieterdc.hive.helpers;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a coordinate.
 * <p>
 * Created at 16/03/16 19:19
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Coordinate {
	private final int x;
	private final int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public List<Double> asList() {
		return Arrays.asList((double) this.x, (double) this.y);
	}

	@Override
	public String toString() {
		return "Coordinate[x="+this.x+", y="+this.y+"]";
	}

	public int x() {
		return this.x;
	}

	public int y() {
		return this.y;
	}
}
