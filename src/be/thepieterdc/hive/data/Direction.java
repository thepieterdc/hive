package be.thepieterdc.hive.data;

/**
 * A direction on the hexagonal grid.
 * <p>
 * Created at 19/03/16 12:43
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public enum Direction {
	LEFT("\\");

	private final String representation;

	/**
	 * Direction constructor.
	 * @param r the representation
	 */
	Direction(String r) {
		this.representation = r;
	}

	public String prettyName() {
		return this.name().substring(0, 1).toUpperCase()+this.name().substring(1);
	}

	@Override
	public String toString() {
		return "Direction[name="+this.prettyName()+", representation="+this.representation+"]";
	}
}
