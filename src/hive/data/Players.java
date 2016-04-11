package hive.data;

import hive.helpers.Player;
import javafx.scene.paint.Color;

/**
 * An enum containing the two players in the Viewer-mode.
 * <p>
 * Created at 11/04/16 12:31
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public enum Players {
	BLACK('b', Color.BLANCHEDALMOND),
	WHITE('w', Color.BLANCHEDALMOND.invert());

	private final Player player;

	Players(char i, Color col) {
		this.player = new Player(i, col);
	}

	public static Player fromId(char i) {
		for(Players p : Players.values()) {
			if(p.player().id() == i) {
				return p.player();
			}
		}
		return null;
	}

	public Player player() {
		return this.player;
	}
}
