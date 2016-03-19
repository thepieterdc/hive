package be.thepieterdc.hive.data;

import javafx.scene.shape.SVGPath;

/**
 * Unit types used in the game.
 * <p>
 * Created at 15/03/16 16:31
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public enum UnitType {
	ANT(Svg.UNIT_ANT),
	BEATLE(Svg.UNIT_BEATLE),
	GRASSHOPPER(Svg.UNIT_GRASSHOPPER),
	LADYBUG(Svg.UNIT_LADYBUG),
	MOSQUITO(Svg.UNIT_MOSQUITO),
	PILLBUG(Svg.UNIT_PILLBUG),
	QUEEN(Svg.UNIT_QUEEN),
	SPIDER(Svg.UNIT_SPIDER);

	private final Svg path;

	UnitType(Svg p) {
		this.path = p;
	}

	public String abbreviation() {
		return this.name().substring(0, 1);
	}

	public static UnitType fromAbbreviation(char a) {
		return fromAbbreviation(String.valueOf(a));
	}

	public static UnitType fromAbbreviation(String a) {
		for(UnitType u : UnitType.values()) {
			if(u.abbreviation().equals(a.toUpperCase())) {
				return u;
			}
		}
		throw new IllegalArgumentException("UnitType not found: "+a);
	}

	public SVGPath path() {
		return this.path.path();
	}

	public String prettyName() {
		return this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase();
	}

	@Override
	public String toString() {
		return "UnitType[abbreviation="+this.abbreviation()+", prettyName="+this.prettyName()+"]";
	}
}