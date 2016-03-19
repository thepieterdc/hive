package be.thepieterdc.hive.data;

/**
 * An orientation on the hexagonal grid.
 * <p>
 * Created at 19/03/16 12:43
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public enum Orientation {
	LEFTMIDDLE("-", Direction.LEFT),
	LEFTUPPER("\\", Direction.LEFT),
	LEFTUNDER("/", Direction.LEFT),
	RIGHTMIDDLE("-", Direction.RIGHT),
	RIGHTUPPER("/", Direction.RIGHT),
	RIGHTUNDER("\\", Direction.RIGHT);

	private final String representation;
	private final Direction direction;

	Orientation(String r, Direction d) {
		this.representation = r;
		this.direction = d;
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
}