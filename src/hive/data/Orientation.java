package hive.data;

import hive.helpers.HexCoordinate;

/**
 * Orientation enum; describes an orientation on the hexagonal grid.
 * <p>
 * Created at 19/03/16 12:43
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public enum Orientation {
	LEFTMIDDLE("-", Direction.LEFT, 0, -1),
	LEFTUPPER("\\", Direction.LEFT, -1, 0),
	LEFTUNDER("/", Direction.LEFT, 1, -1),
	RIGHTMIDDLE("-", Direction.RIGHT, 0, 1),
	RIGHTUPPER("/", Direction.RIGHT, -1, 1),
	RIGHTUNDER("\\", Direction.RIGHT, 1, 0);

	private final String representation;
	private final Direction direction;
	private final int rowDelta;
	private final int colDelta;

	/**
	 * Orientation constructor.
	 *
	 * @param r  the representation
	 * @param d  the direction
	 * @param rD the rowDelta
	 * @param cD the columnDelta
	 */
	Orientation(String r, Direction d, int rD, int cD) {
		this.representation = r;
		this.direction = d;
		this.rowDelta = rD;
		this.colDelta = cD;
	}

	/**
	 * @return the column delta
	 */
	public int columnDelta() {
		return this.colDelta;
	}

	/**
	 * @return the direction
	 */
	public Direction direction() {
		return this.direction;
	}

	public static Orientation fromHexCoordinates(HexCoordinate base, HexCoordinate hC) {
		//THROWS NO EXCEPTION SINCE THEY CAN BE NOT NEIGHBOURING//
		for (Orientation o : Orientation.values()) {
			if (HexCoordinate.fromOrientation(hC, o).equals(base)) {
				return o;
			}
		}
		return null;
	}

	/**
	 * Returns an Orientation from a given representation and direction.
	 *
	 * @param rep the representation
	 * @param dir the direction
	 * @return the Orientation identified
	 */
	public static Orientation fromRepresentation(String rep, Direction dir) {
		if (rep == null) {
			throw new IllegalArgumentException("Parameter \"rep\" is null.");
		}
		if (dir == null) {
			throw new IllegalArgumentException("Parameter \"dir\" is null.");
		}
		for (Orientation o : Orientation.values()) {
			if (o.direction() == dir && rep.contains(o.representation())) {
				return o;
			}
		}
		throw new IllegalArgumentException("Orientation not found: " + rep);
	}

	/**
	 * @return the string representation of the orientation
	 */
	public String representation() {
		return this.representation;
	}

	/**
	 * @return the row delta
	 */
	public int rowDelta() {
		return this.rowDelta;
	}

	@Override
	public String toString() {
		return "Orientation[columnDelta=" + this.colDelta + ", direction=" + this.direction + ", representation=" + this.representation + ", rowDelta=" + this.rowDelta + ']';
	}
}