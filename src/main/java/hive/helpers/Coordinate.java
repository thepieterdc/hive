package hive.helpers;

import hive.interfaces.Locatable;
import hive.interfaces.Representable;

import java.util.Arrays;
import java.util.List;

/**
 * A cartesian coordinate.
 * <p>
 * Created at 16/03/16 19:19
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class Coordinate implements Locatable, Representable {
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

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Coordinate && ((Locatable) obj).x() == this.x && ((Locatable) obj).y() == this.y;
	}

	@Override
	public int hashCode() {
		return (int) (this.x * 100 + this.y);
	}

	@Override
	public String representation() {
		return "[" + this.x + ", " + this.y + ']';
	}

	@Override
	public String toString() {
		return "Coordinate[x=" + this.x + ", y=" + this.y + ']';
	}

	@Override
	public double x() {
		return this.x;
	}

	@Override
	public double y() {
		return this.y;
	}
}
