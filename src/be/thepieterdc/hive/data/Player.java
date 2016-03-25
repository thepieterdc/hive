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
	ONE("b", Color.BLANCHEDALMOND),
	TWO("w", Color.AQUAMARINE);

	private final Color color;
	private final String id;

	Player(String id, Color col) {
		this.color = col;
		this.id = id;
	}

	public Color color() {
		return this.color;
	}

	public static Player fromId(String i) {
		for(Player p : Player.values()) {
			if(p.id.equals(i)) {
				return p;
			}
		}
		throw new IllegalArgumentException("Player not found for identifier: "+i);
	}

	public String id() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Player[id="+this.id+", color="+this.color+"]";
	}
}
