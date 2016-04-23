package hive.helpers;

import hive.data.Players;
import hive.data.UnitType;

/**
 * A unit that can be played.
 * <p>
 * Created at 19/03/16 11:18
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class Unit {
	private HexCoordinate location;
	private final Player player;
	private final int rank;
	private final UnitType type;

	/**
	 * Unit constructor.
	 *
	 * @param p the player
	 * @param t the unit type
	 * @param r the rank
	 */
	public Unit(Player p, UnitType t, int r) {
		if (p == null) {
			throw new IllegalArgumentException("Parameter \"p\" is null.");
		}
		if (t == null) {
			throw new IllegalArgumentException("Parameter \"t\" is null.");
		}
		if (r <= 0) {
			throw new IllegalArgumentException("Parameter \"r\" is negative or zero.");
		}
		this.player = p;
		this.rank = r;
		this.type = t;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Unit && ((Unit) obj).player() == this.player && ((Unit) obj).type() == this.type && ((Unit) obj).rank() == this.rank;
	}

	/**
	 * Returns a Unit from a given representation.
	 *
	 * @param r the representation
	 * @return the Unit found
	 */
	public static Unit fromRepresentation(CharSequence r) {
		if (r == null) {
			throw new IllegalArgumentException("Parameter \"r\" is null.");
		}
		UnitType t = UnitType.fromAbbreviation(r.charAt(1));
		return new Unit(Players.fromId(r.charAt(0)), t, t == UnitType.QUEEN ? 1 : r.charAt(2) - 48);
	}

	@Override
	public int hashCode() {
		return player.hashCode() + rank + type.hashCode();
	}

	public HexCoordinate location() {
		return this.location;
	}

	public void location(HexCoordinate c) {
		this.location = c;
	}

	/**
	 * @return the player
	 */
	public Player player() {
		return this.player;
	}

	/**
	 * @return the rank
	 */
	public int rank() {
		return this.rank;
	}

	/**
	 * @return the string representation
	 */
	public String representation() {
		return String.valueOf(this.player.id()) + this.type.abbreviation() + (this.type == UnitType.QUEEN ? "" : Integer.valueOf(this.rank));
	}

	@Override
	public String toString() {
		return "Unit[player=" + this.player + ", type=" + this.type.prettyName() + ", rank=" + this.rank + ", representation=" + this.representation() + ']';
	}

	/**
	 * @return the unit type
	 */
	public UnitType type() {
		return this.type;
	}
}
