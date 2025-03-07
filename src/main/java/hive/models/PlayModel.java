package hive.models;

import hive.data.Players;
import hive.data.UnitType;
import hive.helpers.*;
import hive.helpers.moves.FirstMove;
import hive.helpers.moves.StartMove;
import hive.interfaces.PlacementValidator;
import hive.models.simple.SimpleObjectModel;
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
	private final Collection<PlacementValidator> placementValidators = new LinkedHashSet<>(3);

	private final Player player1;
	private final Player player2;

	private final SimpleObjectModel<Unit> selectedUnit;
	private final SimpleObjectProperty<Player> winnerProperty;

	/**
	 * PlayModel constructor.
	 *
	 * @param p1 the name of player 1
	 * @param p2 the name of player 2
	 */
	public PlayModel(String p1, String p2) {
		super(Collections.singletonList(new StartMove()));
		this.player1 = new Player(Players.BLACK, p1);
		this.player2 = new Player(Players.WHITE, p2);
		this.selectedUnit = new SimpleObjectModel<>();
		this.winnerProperty = new SimpleObjectProperty<>();

		AtomicInteger i = new AtomicInteger();
		Arrays.asList(this.player1, this.player2).forEach(p -> EnumSet.allOf(UnitType.class).forEach(u -> IntStream.range(0, u.capacity()).forEach(c -> units[i.getAndIncrement()] = new Unit(p, u, c + 1))));

		//Unit may not be neighbouring to an enemy unit.//
		this.placementValidators.add((u, c) -> u.location() != null || this.totalMoves < 3 || this.boardState().neighbours(c).keySet().stream().map(Unit::player).allMatch(p -> p.equals(u.player())));
		//Validates that a unit cannot be moved as long as the queen is not in game yet.//
		this.placementValidators.add((u, c) -> u.location() == null || u.type() == UnitType.QUEEN || this.boardState().units().containsKey(new Unit(u.player(), UnitType.QUEEN, 1)));
		//Validates that the queen is not played in the first move.//
		this.placementValidators.add((u, c) -> !(u.type() == UnitType.QUEEN && this.totalMoves < 3));
		//Validates that the queen is played in the second or third move.//
		this.placementValidators.add((u, c) -> u.type() == UnitType.QUEEN || this.totalMoves < 5 || this.boardState().units().containsKey(new Unit(u.player(), UnitType.QUEEN, 1)));
	}

	/**
	 * @param m the FirstMove to apply
	 * @return false if the move is illegal, true otherwise
	 */
	public boolean move(FirstMove m) {
		if (m == null) {
			throw new IllegalArgumentException("Parameter \"move\" is null.");
		}

		if (m.unit().type() == UnitType.QUEEN) {
			return false;
		}

		m.unit().location(new HexCoordinate(0, 0));

		this.moves.add(m);
		this.totalMoves++;

		this.selectedUnit.set(null);
		this.selectedUnit.removeListeners();

		this.boardStates.put(this.totalMoves - 1, BoardState.calculate(m));
		this.move(this.totalMoves - 1);
		return true;
	}

	/**
	 * @param m    the move to apply
	 * @param dest the destination coordinate
	 * @return false if the move is illegal, true otherwise
	 */
	public boolean move(Move m, HexCoordinate dest) {
		if (m == null) {
			throw new IllegalArgumentException("Parameter \"move\" is null.");
		}

		if (this.placementValidators.stream().anyMatch(v -> !v.validate(m.unit(), dest))) {
			return false;
		}

		if (m.unit().location() != null && !m.unit().pathFinder().get().valid(this.boardState(), m, dest)) {
			return false;
		}

		m.unit().location(dest);

		this.moves.add(m);
		this.totalMoves++;
		this.selectedUnit.set(null);

		this.boardStates.put(this.totalMoves - 1, BoardState.calculate(this.boardState(), m));

		this.selectedUnit.removeListeners();

		this.move(this.totalMoves - 1);

		// Set the winner.
		this.boardState()
			.units()
			.entrySet()
			.stream()
			.filter((e) -> e.getKey().type() == UnitType.QUEEN && this.boardState().freeNeighbours(e.getValue()).isEmpty())
			.map(e -> e.getKey().player())
			.findAny()
			.ifPresent(loser -> this.winnerProperty.set(loser.equals(this.player1) ? this.player2 : this.player1));

		return true;
	}

	/**
	 * @return the selected unit
	 */
	public SimpleObjectModel<Unit> selectedUnit() {
		return this.selectedUnit;
	}

	/**
	 * @return the current player
	 */
	public Player turn() {
		return this.totalMoves % 2 == 0 ? this.player1 : this.player2;
	}

	/**
	 * @return the winner
	 */
	public SimpleObjectProperty<Player> winnerProperty() {
		return this.winnerProperty;
	}
}
