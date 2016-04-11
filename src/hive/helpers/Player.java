package hive.helpers;

import javafx.scene.paint.Color;

/**
 * Represents a player playing the game.
 * <p>
 * Created at 25/03/16 18:06
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Player {
	private final Color color;
	private final char id;
	private final String name;

	public Player(char i, Color col) {
		this(i, col, String.valueOf(i));
	}

	public Player(char i, Color col, String n) {
		this.color = col;
		this.id = i;
		this.name = n;
	}

	public Color color() {
		return this.color;
	}

	public char id() {
		return this.id;
	}

	public String name() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Player[color=" + this.color + ", id=" + this.id + ", name=" + this.name + ']';
	}
}
