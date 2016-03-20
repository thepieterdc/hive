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

	public Unit(Color player, UnitType type) {
		this(player, type, 0);
	}

	public Unit(Color player, UnitType type, int rank) {
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

	public Color player() {
		return this.player;
	}

	public int rank() {
		return this.rank;
	}

	public UnitType type() {
		return this.type;
	}
}
