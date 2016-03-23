package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.Orientation;

/**
 * A coordinate on the playing grid.
 * <p>
 * Created at 20/03/16 14:04
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class GridCoordinate {
	private final int column;
	private final int row;

	public GridCoordinate(int row, int col) {
		this.column = col;
		this.row = row;
	}

	public int column() {
		return this.column;
	}

	public static GridCoordinate fromOrientation(GridCoordinate base, Orientation o) {
		return new GridCoordinate(base.row+o.rowDelta(), base.column+o.columnDelta());
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof GridCoordinate && ((GridCoordinate) obj).row == this.row && ((GridCoordinate) obj).column == this.column;
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
		return "GridCoordinate[row="+this.row+", column="+this.column+"]";
	}
}
