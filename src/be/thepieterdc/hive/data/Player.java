package be.thepieterdc.hive.data;

import javafx.scene.paint.Color;

/**
 * Player enum; contains the two players that are playing the game.
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

	/**
	 * Player constructor.
	 * @param i the player's identifier
	 * @param col the player's color
	 */
	Player(char i, Color col) {
		this.color = col;
		this.id = i;
	}

	/**
	 * @return the player's color
	 */
	public Color color() {
		return this.color;
	}

	/**
	 * Returns a Player from a given identification.
	 * @param i the identification character
	 * @return the Player found
	 */
	public static Player fromId(char i) {
		if(i == 0) {
			throw new IllegalArgumentException("Parameter \"i\" is empty.");
		}
		for (Player p : Player.values()) {
			if (p.id() == i) {
				return p;
			}
		}
		throw new IllegalArgumentException("Player not found for identifier: " + i);
	}

	/**
	 * @return the identification character
	 */
	public char id() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Player[color=" + this.color + ", id=" + this.id + ']';
	}
}
