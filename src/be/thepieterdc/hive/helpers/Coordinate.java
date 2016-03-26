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

	public Coordinate(double xCoord, double yCoord) {
		this.x = xCoord;
		this.y = yCoord;
	}

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
		return "Coordinate[x="+this.x+", y="+this.y+ ']';
	}

	public double x() {
		return this.x;
	}

	public double y() {
		return this.y;
	}
}
