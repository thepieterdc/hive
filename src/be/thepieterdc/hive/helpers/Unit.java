package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.UnitType;
import javafx.scene.paint.Color;

/**
 * A playable unit.
 * <p>
 * Created at 19/03/16 11:18
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Unit {
	private final Color player;
	private final int rank;
	private final UnitType type;

	/**
	 * Unit constructor.
	 * @param player the player color
	 * @param type the unit type
	 */
	public Unit(Color player, UnitType type) {
		this(player, type, 0);
	}

	/**
	 * Unit constructor.
	 * @param player the player color
	 * @param type the unit type
	 * @param rank the rank of the unit
	 */
	public Unit(Color player, UnitType type, int rank) {
		this.player = player;
		this.rank = rank;
		this.type = type;
	}
}
