package hive.data;

import hive.helpers.StringUtils;
import hive.helpers.pathfinding.PathFinder;
import hive.helpers.pathfinding.pathfinders.AntPathFinder;
import hive.helpers.pathfinding.pathfinders.GrasshopperPathFinder;
import hive.helpers.pathfinding.pathfinders.QueenBeetlePathFinder;
import hive.helpers.pathfinding.pathfinders.SpiderPathFinder;
import hive.interfaces.Representable;
import javafx.scene.shape.SVGPath;

import java.util.EnumSet;
import java.util.function.Supplier;

/**
 * UnitType enum; contains all the unit types used in this game.
 * <p>
 * Created at 15/03/16 16:31
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public enum UnitType implements Representable {
	ANT(3, Svg.UNIT_ANT, AntPathFinder::new),
	BEETLE(2, Svg.UNIT_BEETLE, QueenBeetlePathFinder::new),
	GRASSHOPPER(3, Svg.UNIT_GRASSHOPPER, GrasshopperPathFinder::new),
	LADYBUG(0, Svg.UNIT_LADYBUG, null), //Not implemented//
	MOSQUITO(0, Svg.UNIT_MOSQUITO, null), //Not implemented//
	PILLBUG(0, Svg.UNIT_PILLBUG, null), //Not implemented//
	QUEEN(1, Svg.UNIT_QUEEN, QueenBeetlePathFinder::new),
	SPIDER(2, Svg.UNIT_SPIDER, SpiderPathFinder::new);

	private final int cap;
	private final Svg path;
	private final Supplier<PathFinder> pathFinder;

	/**
	 * UnitType constructor.
	 *
	 * @param c the start capacity of this unit
	 * @param p the vector image of this unit
	 */
	UnitType(int c, Svg p, Supplier<PathFinder> pf) {
		this.cap = c;
		this.path = p;
		this.pathFinder = pf;
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
	 *
	 * @param a the abbreviation
	 * @return the UnitType found
	 */
	public static UnitType fromAbbreviation(char a) {
		if (a == 0) {
			throw new IllegalArgumentException("Parameter \"a\" is empty.");
		}
		return EnumSet.allOf(UnitType.class).stream().filter(u -> u.abbreviation() == a).findAny().orElseThrow(() -> new IllegalArgumentException("UnitType not found: " + a));
	}

	/**
	 * @return the vector path of this unit
	 */
	public SVGPath path() {
		return this.path.path();
	}

	/**
	 * @return the PathFinder for the current unit.
	 */
	public Supplier<PathFinder> pathFinder() {
		return this.pathFinder;
	}

	@Override
	public String representation() {
		return StringUtils.ucfirst(this.name());
	}

	@Override
	public String toString() {
		return "UnitType[abbreviation=" + this.abbreviation() + ", capacity=" + this.cap + ", repr=" + this.representation() + ']';
	}
}