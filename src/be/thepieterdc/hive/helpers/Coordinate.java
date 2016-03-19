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
	private final double x;
	private final double y;

	/**
	 * Coordinate constructor.
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 */
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return a list of the coordinates, for simpler usage in Polygon contexts.
	 */
	public List<Double> asList() {
		return Arrays.asList(this.x, this.y);
	}

	@Override
	public String toString() {
		return "Coordinate[x="+this.x+", y="+this.y+"]";
	}

	/**
	 * @return the x-coordinate
	 */
	public double x() {
		return this.x;
	}

	/**
	 * @return the y-coordinate
	 */
	public double y() {
		return this.y;
	}
}
