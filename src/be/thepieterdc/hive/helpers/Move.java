package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.Direction;
import be.thepieterdc.hive.data.Orientation;
import be.thepieterdc.hive.exceptions.MalformedMoveException;
import be.thepieterdc.hive.helpers.moves.FirstMove;
import be.thepieterdc.hive.helpers.moves.StartMove;

/**
 * Represents a move.
 * <p>
 * Created at 17/03/16 17:10
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class Move {
	private final Orientation orientation;
	private final Unit otherUnit;
	private final Unit unit;

	private Move(Unit u, Unit ot, Orientation or) {
		this.orientation = or;
		this.otherUnit = ot;
		this.unit = u;
	}

	public static Move fromRepresentation(String r) {
		if ("start".equals(r.toLowerCase())) {
			return new StartMove();
		}
		try {
			Unit thisUnit = Unit.fromRepresentation(r.substring(0, 2));

			if (!r.contains(" ")) {
				return new FirstMove(thisUnit, r);
			}

			String rep = r.substring(r.indexOf(' ') + 1);

			Orientation o = Orientation.fromRepresentation(rep, rep.charAt(0) <= 97 ? Direction.LEFT : Direction.RIGHT);

			Unit otherUnit = Unit.fromRepresentation(rep.replace(o.representation(), ""));

			return new Move(thisUnit, otherUnit, o);
		} catch(RuntimeException ignored) {
			throw new MalformedMoveException(r);
		}
	}

	Orientation orientation() {
		return this.orientation;
	}

	Unit otherUnit() {
		return this.otherUnit;
	}

	public String representation() {
		return this.unit.representation() + ' ' + (this.orientation.direction() == Direction.LEFT ? this.orientation.representation()+this.otherUnit.representation():this.otherUnit.representation()+this.orientation.representation());
	}

	@Override
	public String toString() {
		return "Move[orientation="+this.orientation+", otherUnit="+this.otherUnit+", representation="+this.representation()+", unit="+this.unit+ ']';
	}

	Unit unit() {
		return this.unit;
	}
}