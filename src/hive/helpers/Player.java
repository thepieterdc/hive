package hive.helpers;

import hive.data.Players;
import hive.interfaces.Representable;
import javafx.scene.paint.Color;

/**
 * Represents a player playing the game.
 * <p>
 * Created at 25/03/16 18:06
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Player implements Representable {
	private final Color color;
	private final char id;
	private final String name;

	private final static String[] firstnames = new String[]{""};

	public Player(char i, Color col) {
		this(i, col, String.valueOf(i));
	}

	public Player(char i, Color col, String n) {
		this.color = col;
		this.id = i;
		this.name = n;
	}

	public Player(Players p, String n) {
		this(p.player().id(), p.player().color(), n);
	}

	public Color color() {
		return this.color;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Player && this.id == ((Player) obj).id() && this.color.equals(((Player) obj).color()) && this.name.equals(((Player) obj).name());
	}

	@Override
	public int hashCode() {
		return this.id + this.color.hashCode() + this.name.hashCode();
	}

	public char id() {
		return this.id;
	}

	public String name() {
		return this.name;
	}

	@Override
	public String representation() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Player[color=" + this.color + ", id=" + this.id + ", name=" + this.name + ']';
	}
}
