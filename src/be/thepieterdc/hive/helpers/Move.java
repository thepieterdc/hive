package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.UnitType;
import javafx.scene.paint.Color;

/**
 * Represents a move.
 * <p>
 * Created at 17/03/16 17:10
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Move {
	private final Color thisPlayer;
	private final UnitType thisColor;
	private final Color otherPlayer;
	private final UnitType other;

	/**
	 * Move constructor.
	 * @param player the player color
	 * @param type the unit type
	 */
	public Move(Color player, UnitType type) {
		this.player = player;
		this.unit = type;
	}

	/**
	 * Creates a Move from the short representation.
	 * @param r the string representation
	 * @return the Move created
	 */
	public static Move fromRepresentation(String r) {
		r = r.toLowerCase();
		if(r.equals("start")) {
			return new Move(null, null, null, null, null);
		}

		return new Move(Color.ALICEBLUE, UnitType.ANT);
	}

	/**
	 * @return the player color
	 */
	public Color player() {
		return this.player;
	}

	/**
	 * @return the short string representation of this move
	 */
	public String representation() {
		return "Wololo";
	}

	/**
	 * @return the unit type
	 */
	public UnitType unit() {
		return this.unit;
	}

	@Override
	public String toString() {
		return "Move[player="+this.player.toString()+", unit="+this.unit.prettyName()+"]";
	}
}
