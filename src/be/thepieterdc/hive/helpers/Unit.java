package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.Player;
import be.thepieterdc.hive.data.UnitType;

/**
 * A playable unit.
 * <p>
 * Created at 19/03/16 11:18
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class Unit {
	private final Player player;
	private final int rank;
	private final UnitType type;

	public Unit(Player p, UnitType t, int r) {
		if(p == null) {
			throw new IllegalArgumentException("Parameter \"p\" is null.");
		}
		if(t == null) {
			throw new IllegalArgumentException("Parameter \"t\" is null.");
		}
		if(r <= 0) {
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

	static Unit fromRepresentation(String r) {
		if(r == null) {
			throw new IllegalArgumentException("Parameter \"r\" is null.");
		}
		UnitType t = UnitType.fromAbbreviation(r.charAt(1));
		return new Unit(Player.fromId(r.charAt(0)), t, t == UnitType.QUEEN ? 1 : r.charAt(2) - 48);
	}

	@Override
	public int hashCode() {
		return player.hashCode() + rank + type.hashCode();
	}

	public Player player() {
		return this.player;
	}

	public int rank() {
		return this.rank;
	}

	public String representation() {
		return String.valueOf(this.player.id()) + this.type.abbreviation() + (this.type == UnitType.QUEEN ? "" : Integer.valueOf(this.rank));
	}

	@Override
	public String toString() {
		return "Unit[player=" + this.player + ", type=" + this.type.prettyName() + ", rank=" + this.rank + ", representation=" + this.representation() + ']';
	}

	public UnitType type() {
		return this.type;
	}
}
