package hive.helpers;

import java.util.Arrays;
import java.util.List;

/**
 * A cartesian coordinate.
 * <p>
 * Created at 16/03/16 19:19
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class Coordinate {
	private final double x;
	private final double y;

	/**
	 * Coordinate constructor.
	 *
	 * @param xCoord the x-coordinate
	 * @param yCoord the y-coordinate
	 */
	public Coordinate(double xCoord, double yCoord) {
		this.x = xCoord;
		this.y = yCoord;
	}

	/**
	 * @return a list of the coordinates as doubles; for convenient usage in Polygon classes
	 */
	public List<Double> asList() {
		return Arrays.asList(this.x, this.y);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Coordinate && ((Coordinate) obj).x() == this.x && ((Coordinate) obj).y() == this.y;
	}

	@Override
	public int hashCode() {
		return (int) (this.x * 100 + this.y);
	}

	@Override
	public String toString() {
		return "Coordinate[x=" + this.x + ", y=" + this.y + ']';
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
