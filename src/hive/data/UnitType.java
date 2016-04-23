package hive.data;

import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.PathFinding;
import hive.helpers.Unit;
import hive.interfaces.UnitMoveValidator;
import javafx.scene.shape.SVGPath;

import java.util.List;

/**
 * UnitType enum; contains all the unit types used in this game.
 * <p>
 * Created at 15/03/16 16:31
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public enum UnitType {
	ANT(3, Svg.UNIT_ANT, (u, s, d) -> true),
	BEETLE(2, Svg.UNIT_BEETLE, (u, s, d) -> u.location().distanceTo(d) == 1),
	GRASSHOPPER(3, Svg.UNIT_GRASSHOPPER, new UnitMoveValidator() {
		@Override
		public boolean validate(Unit u, BoardState state, HexCoordinate dest) {
			List<HexCoordinate> path = PathFinding.colinearPath(u.location(), dest);
			//if path contains units -> false
			//if not colinear -> false
			return false;
		}
	}),
	LADYBUG(0, Svg.UNIT_LADYBUG, (u, s, d) -> true), //Not implemented//
	MOSQUITO(0, Svg.UNIT_MOSQUITO, (u, s, d) -> true), //Not implemented//
	PILLBUG(0, Svg.UNIT_PILLBUG, (u, s, d) -> true), //Not implemented//
	QUEEN(1, Svg.UNIT_QUEEN, (u, s, d) -> u.location().distanceTo(d) == 1),
	SPIDER(2, Svg.UNIT_SPIDER, (u, state, dest) -> PathFinding.pathExists(u.location(), dest, state, 3));

	private final int cap;
	private final Svg path;
	private final UnitMoveValidator validator;

	/**
	 * UnitType constructor.
	 *
	 * @param c the start capacity of this unit
	 * @param p the vector image of this unit
	 */
	UnitType(int c, Svg p, UnitMoveValidator v) {
		this.cap = c;
		this.path = p;
		this.validator = v;
	}

	/**
	 * @return the abbreviation
	 */
	public char abbreviation() {
		return this.name().charAt(0);
	}

	public boolean canMove(Unit u, BoardState s, HexCoordinate dest) {
		return this.validator.validate(u, s, dest);
	}

	/**
	 * @return the start capacity of this unit
	 */
	public int capacity() {
		return this.cap;
	}

	/**
	 * Returns a UnitType from a given abbreviation.
	 *
	 * @param a the abbreviation
	 * @return the UnitType found
	 */
	public static UnitType fromAbbreviation(char a) {
		if (a == 0) {
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