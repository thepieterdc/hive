package be.thepieterdc.hive.data;

/**
 * An orientation on the hexagonal grid.
 * <p>
 * Created at 19/03/16 12:43
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public enum Orientation {
	LEFTMIDDLE("-", Direction.LEFT, -1, 0),
	LEFTUPPER("\\", Direction.LEFT, -1, 1),
	LEFTUNDER("/", Direction.LEFT, -1, -1),
	RIGHTMIDDLE("-", Direction.RIGHT, 1, 0),
	RIGHTUPPER("/", Direction.RIGHT, 1, 1),
	RIGHTUNDER("\\", Direction.RIGHT, 1, -1);

	private final String representation;
	private final Direction direction;
	private final int xDelta;
	private final int yDelta;

	Orientation(String r, Direction d, int xDelta, int yDelta) {
		this.representation = r;
		this.direction = d;
		this.xDelta = xDelta;
		this.yDelta = yDelta;
	}

	public Direction direction() {
		return this.direction;
	}

	public static Orientation fromRepresentation(char rep, Direction dir) {
		return fromRepresentation(String.valueOf(rep), dir);
	}

	public static Orientation fromRepresentation(String rep, Direction dir) {
		for(Orientation o : Orientation.values()) {
			if(o.direction.equals(dir) && o.representation.equals(rep)) {
				return o;
			}
		}
		throw new IllegalArgumentException("Orientation not found: "+rep);
	}

	public String representation() {
		return this.representation;
	}

	public int xDelta() {
		return this.xDelta;
	}

	public int yDelta() {
		return this.yDelta;
	}
}