package be.thepieterdc.hive.data;

/**
 * A direction on the hexagonal grid.
 * <p>
 * Created at 19/03/16 12:43
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public enum Direction {
	LEFT("-r"),
	LEFTUPPER("\\a"),
	LEFTUNDER("/a"),
	RIGHT("r-"),
	RIGHTUPPER("a/"),
	RIGHTUNDER("a\\");

	private final String representation;

	/**
	 * Direction constructor.
	 * @param r the representation
	 */
	Direction(String r) {
		this.representation = r;
	}

	/**
	 * Finds the Direction for a given representation.
	 * @param rep the representation; include an "r" to indicate where the unit type is situated
	 * @return the Direction found
	 */
	public static Direction fromRepresentation(String rep) {
		for(Direction d : Direction.values()) {
			if(d.representation.equals(rep)) {
				return d;
			}
		}
		throw new IllegalArgumentException("Direction not found.");
	}

	/**
	 * @return a pretty formatted name of this unit
	 */
	public String prettyName() {
		return this.name().substring(0, 1).toUpperCase()+this.name().substring(1);
	}

	@Override
	public String toString() {
		return "Direction[name="+this.prettyName()+", representation="+this.representation+"]";
	}
}
