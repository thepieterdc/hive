package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.Orientation;

/**
 * An axial hexagon coordinate.
 * <p>
 * Created at 20/03/16 14:04
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class HexCoordinate {
	private final int column;
	private final int row;

	public HexCoordinate(int row, int col) {
		this.column = col;
		this.row = row;
	}

	public int column() {
		return this.column;
	}

	public static HexCoordinate fromOrientation(HexCoordinate base, Orientation o) {
		return new HexCoordinate(base.row+o.rowDelta(), base.column+o.columnDelta());
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof HexCoordinate && ((HexCoordinate) obj).row == this.row && ((HexCoordinate) obj).column == this.column;
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
		return "HexCoordinate[row="+this.row+", column="+this.column+"]";
	}

	public double x() {
		return 10 * Math.sqrt(3) * (this.column + this.row) - 9*this.row;
	}

	public double y() {
		return 10 * 3/2 * this.row;
	}
}
