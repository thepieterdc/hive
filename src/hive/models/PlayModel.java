package hive.models;

import hive.helpers.Model;
import hive.helpers.Player;
import javafx.scene.paint.Color;

/**
 * Model for the Play part.
 * <p>
 * Created at 17/03/16 14:08
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class PlayModel extends Model {

	private final Player player1;
	private final Player player2;

	public PlayModel(String p1, String p2) {
		this.player1 = new Player('b', Color.BLANCHEDALMOND, p1);
		this.player2 = new Player('w', Color.BLANCHEDALMOND.invert(), p2);
	}

	public Player player1() {
		return this.player1;
	}

	public Player player2() {
		return this.player2;
	}
}
