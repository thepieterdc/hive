package hive.helpers;

import hive.data.Direction;
import hive.data.Orientation;
import hive.exceptions.IllegalMoveException;
import hive.exceptions.MalformedMoveException;
import hive.helpers.moves.FirstMove;
import hive.helpers.moves.StartMove;
import hive.interfaces.Representable;

import java.util.Map;

/**
 * Represents a move.
 * <p>
 * Created at 17/03/16 17:10
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Move implements Representable {
	private final Orientation orientation;
	private final Unit otherUnit;
	private final Unit unit;

	/**
	 * The move types.
	 */
	public enum MoveType {
		START, FIRST, REGULAR
	}

	/**
	 * Move constructor.
	 *
	 * @param u  the base unit
	 * @param ot the other unit
	 * @param or the Orientation of the move
	 */
	public Move(Unit u, Unit ot, Orientation or) {
		this.orientation = or;
		this.otherUnit = ot;
		this.unit = u;
	}

	/**
	 * Calculates a move from a unit placement.
	 *
	 * @param state the current boardstate
	 * @param u     the unit
	 * @param dest  the new destination of the unit
	 * @return the move calculated
	 * @throws IllegalMoveException the move is invalid
	 */
	public static Move fromCoordinates(BoardState state, Unit u, HexCoordinate dest) throws IllegalMoveException {
		return state
			.neighbours(dest)
			.entrySet()
			.stream()
			.map(e -> new Move(u, e.getKey(), Orientation.fromHexCoordinates(dest, e.getValue()).orElse(null)))
			.findAny()
			.orElseThrow(() -> new IllegalMoveException(u, dest));
	}

	/**
	 * Returns a Move from a given representation.
	 *
	 * @param r the string representation
	 * @return the Move found
	 */
	public static Move fromRepresentation(String r) {
		if (r == null) {
			throw new IllegalArgumentException("Parameter \"r\" is null.");
		}
		if ("start".equalsIgnoreCase(r)) {
			return new StartMove();
		}
		try {
			Unit thisUnit = Unit.fromRepresentation(r);

			if (!r.contains(" ")) {
				return new FirstMove(thisUnit);
			}

			String rep = r.substring(r.indexOf(' ') + 1);

			Orientation o = Orientation.fromRepresentation(rep, rep.charAt(0) <= 97 ? Direction.LEFT : Direction.RIGHT);

			Unit otherUnit = Unit.fromRepresentation(rep.replace(o.representation(), ""));

			return new Move(thisUnit, otherUnit, o);
		} catch (RuntimeException e) {
			throw new MalformedMoveException(r, e);
		}
	}

	/**
	 * @return the Orientation of the move
	 */
	public Orientation orientation() {
		return this.orientation;
	}

	/**
	 * @return the other unit
	 */
	public Unit otherUnit() {
		return this.otherUnit;
	}

	@Override
	public String representation() {
		return this.unit.representation() + ' ' + (this.orientation.direction() == Direction.LEFT ? this.orientation.representation() + this.otherUnit.representation() : this.otherUnit.representation() + this.orientation.representation());
	}

	@Override
	public String toString() {
		return "Move[orientation=" + this.orientation.direction().representation() + this.orientation.representation() + ", otherUnit=" + this.otherUnit.representation() + ", representation=" + this.representation() + ", unit=" + this.unit.representation() + ']';
	}

	/**
	 * Gets the type of the move.
	 * <i>Omits the use of instance of.</i>
	 *
	 * @return the type of the move
	 */
	public Move.MoveType type() {
		return Move.MoveType.REGULAR;
	}

	/**
	 * @return the base unit
	 */
	public Unit unit() {
		return this.unit;
	}
}