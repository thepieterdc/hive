package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.UnitType;

/**
 * A playable unit.
 * <p>
 * Created at 19/03/16 11:18
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Unit {
	private final Player player;
	private final int rank;
	private final UnitType type;

	public Unit(Player player, UnitType type) {
		this(player, type, 0);
	}

	public Unit(Player player, UnitType type, int rank) {
		this.player = player;
		this.rank = rank;
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Unit && ((Unit) obj).player.equals(this.player) && ((Unit) obj).type.equals(this.type) && ((Unit) obj).rank == this.rank;
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

	@Override
	public String toString() {
		return "Unit[player="+this.player+", type="+this.type.prettyName()+", rank="+this.rank+"]";
	}

	public UnitType type() {
		return this.type;
	}
}
