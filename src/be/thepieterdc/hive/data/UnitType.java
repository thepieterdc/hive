package be.thepieterdc.hive.data;

import javafx.scene.shape.SVGPath;

/**
 * UnitType enum; contains all the unit types used in this game.
 * <p>
 * Created at 15/03/16 16:31
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public enum UnitType {
	ANT(3, Svg.UNIT_ANT),
	BEATLE(2, Svg.UNIT_BEATLE),
	GRASSHOPPER(3, Svg.UNIT_GRASSHOPPER),
	LADYBUG(0, Svg.UNIT_LADYBUG),
	MOSQUITO(0, Svg.UNIT_MOSQUITO),
	PILLBUG(0, Svg.UNIT_PILLBUG),
	QUEEN(1, Svg.UNIT_QUEEN),
	SPIDER(2, Svg.UNIT_SPIDER);

	private final int cap;
	private final Svg path;

	/**
	 * UnitType constructor.
	 * @param c the start capacity of this unit
	 * @param p the vector image of this unit
	 */
	UnitType(int c, Svg p) {
		this.cap = c;
		this.path = p;
	}

	/**
	 * @return the abbreviation
	 */
	public char abbreviation() {
		return this.name().charAt(0);
	}

	/**
	 * @return the start capacity of this unit
	 */
	public int capacity() {
		return this.cap;
	}

	/**
	 * Returns a UnitType from a given abbreviation.
	 * @param a the abbreviation
	 * @return the UnitType found
	 */
	public static UnitType fromAbbreviation(char a) {
		if(a == 0) {
			throw new IllegalArgumentException("Parameter \"a\" is empty.");
		}
		for (UnitType u : UnitType.values()) {
			if (u.abbreviation() == a) {
				return u;
			}
		}
		throw new IllegalArgumentException("UnitType not found: " + a);
	}

	/**
	 * @return the vector path of this unit
	 */
	public SVGPath path() {
		return this.path.path();
	}

	/**
	 * @return a pretty formatted name of the unit; for nice printing
	 */
	public String prettyName() {
		return this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase();
	}

	@Override
	public String toString() {
		return "UnitType[abbreviation=" + this.abbreviation() + ", capacity=" + this.cap + ", prettyName=" + this.prettyName() + ']';
	}
}