package hive.models;

import hive.components.UnitPane;
import hive.components.hexagons.UnitHexagon;
import hive.data.Players;
import hive.data.UnitType;
import hive.helpers.*;
import hive.helpers.moves.FirstMove;
import hive.helpers.moves.StartMove;
import hive.interfaces.MoveValidator;
import javafx.beans.property.SimpleObjectProperty;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Model for the Play part.
 * <p>
 * Created at 17/03/16 14:08
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class PlayModel extends HiveModel {

	private final Set<MoveValidator> moveValidators = new LinkedHashSet<>(2);

	private final Player player1;
	private final Player player2;

	private final SimpleObjectProperty<Unit> selectedUnitProperty;
	private final SimpleObjectProperty<Player> winnerProperty;

	public PlayModel(String p1, String p2) {
		super(Collections.singletonList(new StartMove()));
		this.player1 = new Player(Players.BLACK, p1);
		this.player2 = new Player(Players.WHITE, p2);
		this.selectedUnitProperty = new SimpleObjectProperty<>();
		this.winnerProperty = new SimpleObjectProperty<>();

		AtomicInteger i = new AtomicInteger();
		Arrays.asList(this.player1, this.player2).forEach(p -> EnumSet.allOf(UnitType.class).forEach(u -> IntStream.range(0, u.capacity()).forEach(c -> units[i.getAndIncrement()] = new Unit(p, u, c + 1))));

		this.addMoveValidators();
	}

	private void addMoveValidators() {
		//Validates placement//
		this.moveValidators.add((u, c) -> u.location() != null || this.totalMoves < 3 || this.boardState().neighbours(c).entrySet().stream().noneMatch(e -> !e.getKey().player().equals(u.player())));
		//Validates that a unit cannot be moved as long as the queen is not in game yet//
		this.moveValidators.add((u, c) -> u.location() == null || u.type() == UnitType.QUEEN || this.boardState().units().containsKey(new Unit(u.player(), UnitType.QUEEN, 1)));

		//
	}

	@Override
	public UnitHexagon callback_UnitPane(UnitPane u, UnitHexagon uH) {
		return UnitPane.unit(uH, this);
	}

	public void move(FirstMove m) {
		System.out.println(m);
		if (m == null) {
			throw new IllegalArgumentException("Parameter \"move\" is null.");
		}
		this.moves.add(m);
		this.totalMoves++;
		this.selectedUnitProperty.setValue(null);

		this.boardStates.put(this.totalMoves - 1, BoardState.calculate(m));
		this.move(this.totalMoves - 1);
	}

	@Override
	public boolean move(Move m) {
		if (m == null) {
			throw new IllegalArgumentException("Parameter \"move\" is null.");
		}

		for (MoveValidator v : this.moveValidators) {
			if (!v.validate(m.unit(), HexCoordinate.fromOrientation(m.otherUnit().location(), m.orientation()))) {
				return false;
			}
		}

		this.moves.add(m);
		this.totalMoves++;
		this.selectedUnitProperty.setValue(null);

		this.boardStates.put(this.totalMoves - 1, BoardState.calculate(this.boardState(), m));

		this.move(this.totalMoves - 1);
		return true;
	}

	public Player player1() {
		return this.player1;
	}

	public Player player2() {
		return this.player2;
	}

	public SimpleObjectProperty<Unit> selectedUnitProperty() {
		return this.selectedUnitProperty;
	}

	public Player turn() {
		return this.totalMoves % 2 == 0 ? this.player1 : this.player2;
	}

	public SimpleObjectProperty<Player> winnerProperty() {
		return this.winnerProperty;
	}
}
