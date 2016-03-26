package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.Orientation;

/**
 * A hexagonal (axial) coordinate.
 * <p>
 * Created at 20/03/16 14:04
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class HexCoordinate {
	private final int column;
	private final int row;

	/**
	 * HexCoordinate constructor.
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
	 * Returns a HexCoordinate from a given HexCoordinate and an Orientation.
	 * @param base the given HexCoordinate
	 * @param o the Orientation
	 * @return the new HexCoordinate after the Orientation deltas have been applied
	 */
	public static HexCoordinate fromOrientation(HexCoordinate base, Orientation o) {
		if(base == null) {
			throw new IllegalArgumentException("Parameter \"base\" is null.");
		}
		if(o == null) {
			throw new IllegalArgumentException("Parameter \"o\" is null.");
		}
		return new HexCoordinate(base.row()+o.rowDelta(), base.column()+o.columnDelta());
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof HexCoordinate && ((HexCoordinate) obj).row() == this.row && ((HexCoordinate) obj).column() == this.column;
	}

	@Override
	public int hashCode() {
		return this.row * 100 + this.column;
	}

	/**
	 * @return the row
	 */
	public int row() {
		return this.row;
	}

	@Override
	public String toString() {
		return "HexCoordinate[column="+this.column+", row="+this.row+ ']';
	}

	/**
	 * @return the x(screen)-coordinate
	 */
	public double x() {
		return 11 * 1.7320508075688772 * (this.column + this.row) - 9.5*this.row;
	}

	/**
	 * @return the y(screen)-coordinate
	 */
	public double y() {
		return 11 * 1.5 * this.row;
	}
}
