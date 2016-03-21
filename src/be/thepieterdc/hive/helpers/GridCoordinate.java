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
	private final int x;
	private final int y;

	public GridCoordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static GridCoordinate fromOrientation(GridCoordinate base, Orientation o) {
		return new GridCoordinate(base.x()+o.xDelta(), base.y()+o.yDelta());
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof GridCoordinate && ((GridCoordinate) obj).x == this.x && ((GridCoordinate) obj).y == this.y;
	}

	@Override
	public int hashCode() {
		return (int) (this.x * 100 + this.y);
	}

	@Override
	public String toString() {
		return "GridCoordinate[x="+this.x+", y="+this.y+"]";
	}

	public int x() {
		return this.x;
	}

	public int y() {
		return this.y;
	}
}
