package be.thepieterdc.hive.helpers;

import javafx.scene.paint.Color;

/**
 * Represents a player.
 * <p>
 * Created at 25/03/16 18:06
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Player {
	private final Color color;
	private final String id;

	public Player(String id, Color col) {
		this.color = col;
		this.id = id;
	}

	public Color color() {
		return this.color;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Player && ((Player) obj).id.equals(this.id);
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	public String id() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Player[id="+this.id+", color="+this.color+"]";
	}
}
