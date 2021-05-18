package hive.helpers;

import hive.data.Orientation;
import hive.interfaces.Locatable;
import hive.interfaces.Representable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A hexagonal (axial) coordinate.
 * <p>
 * Created at 20/03/16 14:04
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class HexCoordinate implements Locatable, Representable {
	private final int column;
	private final int row;

	/**
	 * HexCoordinate constructor.
	 *
	 * @param r the row
	 * @param c the column
	 */
	public HexCoordinate(int r, int c) {
		this.column = c;
		this.row = r;
	}

	/**
	 * @return the column
	 */
	public int column() {
		return this.column;
	}

	/**
	 * Calculates the distance between 2 hexagons using the Chebyshev distance formula.
	 *
	 * @param base   the base coordinate
	 * @param target the target coordinate
	 * @return the distance between the two coordinates
	 */
	public static int distance(HexCoordinate base, HexCoordinate target) {
		return (Math.abs(base.column() - target.column())
				+ Math.abs(base.column() + base.row() - target.column() - target.row())
				+ Math.abs(base.row() - target.row())) / 2;
	}

	/**
	 * @param target the target coordinate
	 * @return the distance from the current coordinate to the given coordinate.
	 */
	public int distanceTo(HexCoordinate target) {
		return distance(this, target);
	}

	/**
	 * Returns a HexCoordinate from a given HexCoordinate and an Orientation.
	 *
	 * @param base the given HexCoordinate
	 * @param o    the Orientation
	 * @return the new HexCoordinate after the Orientation deltas have been applied
	 */
	public static HexCoordinate fromOrientation(HexCoordinate base, Orientation o) {
		if (base == null) {
			throw new IllegalArgumentException("Parameter \"base\" is null.");
		}
		if (o == null) {
			throw new IllegalArgumentException("Parameter \"o\" is null.");
		}
		return new HexCoordinate(base.row() + o.rowDelta(), base.column() + o.columnDelta());
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof HexCoordinate && ((HexCoordinate) obj).row() == this.row && ((HexCoordinate) obj).column() == this.column;
	}

	@Override
	public int hashCode() {
		return this.row * 100 + this.column;
	}

	@Override
	public String representation() {
		return "[" + this.row + ", " + this.column + ']';
	}

	/**
	 * @return the row
	 */
	public int row() {
		return this.row;
	}

	/**
	 * @return the surroundings of the current coordinate
	 */
	public Set<HexCoordinate> surroundings() {
		return surroundings(this);
	}

	/**
	 * @param c the center coordinate
	 * @return the surrounding coordinates
	 */
	public static Set<HexCoordinate> surroundings(HexCoordinate c) {
		return surroundings(c, Collections.emptySet());
	}

	/**
	 * @param c    the center coordinate
	 * @param skip the coordinates to exclude from the result
	 * @return the surrounding coordinates without the given "skip" set
	 */
	public static Set<HexCoordinate> surroundings(HexCoordinate c, Collection<HexCoordinate> skip) {
		return EnumSet.allOf(Orientation.class)
			.stream()
			.map(o -> fromOrientation(c, o))
			.filter(co -> !skip.contains(co))
			.collect(Collectors.toSet());
	}

	@Override
	public String toString() {
		return "HexCoordinate[column=" + this.column + ", row=" + this.row + ']';
	}

	/**
	 * @return the x(screen)-coordinate
	 */
	@Override
	public double x() {
		return 11 * 1.7320508075688772 * (this.column + this.row) - 9.5 * this.row;
	}

	/**
	 * @return the y(screen)-coordinate
	 */
	@Override
	public double y() {
		return 11 * 1.5 * this.row;
	}
}
