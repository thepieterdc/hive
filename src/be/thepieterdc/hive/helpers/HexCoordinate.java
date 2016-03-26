package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.Orientation;

/**
 * An axial hexagon coordinate.
 * <p>
 * Created at 20/03/16 14:04
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class HexCoordinate {
	private final int column;
	private final int row;

	HexCoordinate(int r, int c) {
		this.column = c;
		this.row = r;
	}

	public int column() {
		return this.column;
	}

	static HexCoordinate fromOrientation(HexCoordinate base, Orientation o) {
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

	public int row() {
		return this.row;
	}

	@Override
	public String toString() {
		return "HexCoordinate[column="+this.column+", row="+this.row+ ']';
	}

	public double x() {
		return 11 * 1.7320508075688772 * (this.column + this.row) - 9.5*this.row;
	}

	public double y() {
		return 11 * 1.5 * this.row;
	}
}
