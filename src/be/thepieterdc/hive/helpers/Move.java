package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.Direction;
import be.thepieterdc.hive.data.Orientation;
import be.thepieterdc.hive.data.Player;
import be.thepieterdc.hive.data.UnitType;
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
public class Move {
	private final Orientation orientation;
	private final Unit otherUnit;
	private final Unit unit;

	public Move(Unit u, Unit other, Orientation o) {
		this.orientation = o;
		this.otherUnit = other;
		this.unit = u;
	}

	public static Move fromRepresentation(String r) throws MalformedMoveException {
		String original = r;
		try {
			if (r.toLowerCase().equals("start")) {
				return new StartMove();
			}

			Player thisPlayer = Player.fromId(r.charAt(0));
			UnitType thisType = UnitType.fromAbbreviation(r.charAt(1));
			int thisRank = thisType.equals(UnitType.QUEEN) ? 1 : r.charAt(2) - 48;
			Unit thisUnit = new Unit(thisPlayer, thisType, thisRank);

			if (!r.contains(" ")) {
				return new FirstMove(thisUnit, original);
			}

			r = r.substring(r.indexOf(' ') + 1);

			//Location of the /\- orientation indicator can be on both sides of the move//
			Orientation o = null;
			int orientationPos = 0;
			int colorPos = 1;
			int typePos = 2;
			int rankPos = 3;
			try {
				o = Orientation.fromRepresentation(r.charAt(0), Direction.LEFT);
			} catch (IllegalArgumentException e) {
				colorPos--;
				typePos--;
				rankPos--;
				orientationPos = 3;
			}

			Player otherPlayer = Player.fromId(r.charAt(colorPos));
			UnitType otherType = UnitType.fromAbbreviation(r.charAt(typePos));
			int otherRank = otherType.equals(UnitType.QUEEN) ? 1 : r.charAt(rankPos) - 48;

			Unit otherUnit = new Unit(otherPlayer, otherType, otherRank);

			return new Move(thisUnit, otherUnit, o != null ? o : Orientation.fromRepresentation(r.charAt(otherType.equals(UnitType.QUEEN) ? orientationPos-1:orientationPos), Direction.RIGHT));
		} catch(Exception e) {
			throw new MalformedMoveException(original);
		}
	}

	public Orientation orientation() {
		return this.orientation;
	}

	public Unit otherUnit() {
		return this.otherUnit;
	}

	public String representation() {
		return this.unit.representation() + " " + (this.orientation.direction().equals(Direction.LEFT) ? this.orientation.representation()+this.otherUnit.representation():this.otherUnit.representation()+this.orientation.representation());
	}

	@Override
	public String toString() {
		return "Move[orientation="+this.orientation+", otherUnit="+this.otherUnit+", representation="+this.representation()+", unit="+this.unit+"]";
	}

	public Unit unit() {
		return this.unit;
	}
}