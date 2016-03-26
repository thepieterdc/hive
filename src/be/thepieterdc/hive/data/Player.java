package be.thepieterdc.hive.data;

import javafx.scene.paint.Color;

/**
 * The players.
 * <p>
 * Created at 25/03/16 18:06
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public enum Player {
	ONE('b', Color.BLANCHEDALMOND),
	TWO('w', Color.BLANCHEDALMOND.invert());

	private final Color color;
	private final char id;

	Player(char i, Color col) {
		this.color = col;
		this.id = i;
	}

	public Color color() {
		return this.color;
	}

	public static Player fromId(char i) {
		for (Player p : Player.values()) {
			if (p.id() == i) {
				return p;
			}
		}
		throw new IllegalArgumentException("Player not found for identifier: " + i);
	}

	public char id() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Player[color=" + this.color + ", id=" + this.id + ']';
	}
}
