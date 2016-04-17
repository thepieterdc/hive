package hive.models;

import hive.components.UnitHexagon;
import hive.components.UnitPane;
import hive.data.Players;
import hive.helpers.Player;
import hive.helpers.moves.StartMove;

import java.util.Collections;

/**
 * Model for the Play part.
 * <p>
 * Created at 17/03/16 14:08
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class PlayModel extends HiveModel {

	private final Player player1;
	private final Player player2;

	public PlayModel(String p1, String p2) {
		super(Collections.singletonList(new StartMove()));
		this.player1 = new Player(Players.BLACK, p1);
		this.player2 = new Player(Players.WHITE, p2);
	}

	@Override
	public UnitHexagon callback_UnitPane(UnitPane u, UnitHexagon uH) {
		return u.unit(uH, this);
	}

	public Player player1() {
		return this.player1;
	}

	public Player player2() {
		return this.player2;
	}

	public Player turn() {
		return this.totalMoves % 2 == 0 ? this.player1 : this.player2;
	}
}
