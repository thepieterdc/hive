package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.Direction;
import be.thepieterdc.hive.data.Orientation;
import be.thepieterdc.hive.data.UnitType;
import be.thepieterdc.hive.exceptions.MalformedMoveException;
import be.thepieterdc.hive.helpers.moves.FirstMove;
import be.thepieterdc.hive.helpers.moves.StartMove;
import javafx.scene.paint.Color;

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
	private final String repr;
	private final Unit unit;

	public Move(Unit u, Unit other, Orientation o, String r) {
		this.orientation = o;
		this.otherUnit = other;
		this.repr = r;
		this.unit = u;
	}

	public static Move fromRepresentation(String r) throws MalformedMoveException {
		try {
			String original = r;

			r = r.toLowerCase();
			if (r.equals("start")) {
				return new StartMove();
			}

			Color thisCol = String.valueOf(r.charAt(0)).equals("b") ? Color.BLACK : Color.WHITE;
			UnitType thisType = UnitType.fromAbbreviation(r.charAt(1));
			int thisRank = thisType.equals(UnitType.QUEEN) ? 0 : r.charAt(2) - 48;
			Unit thisUnit = new Unit(thisCol, thisType, thisRank);

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

			Color otherCol = String.valueOf(r.charAt(colorPos)).equals("b") ? Color.BLACK : Color.WHITE;
			UnitType otherType = UnitType.fromAbbreviation(r.charAt(typePos));
			int otherRank = otherType.equals(UnitType.QUEEN) ? 0 : r.charAt(rankPos) - 48;
			Unit otherUnit = new Unit(otherCol, otherType, otherRank);

			return new Move(thisUnit, otherUnit, o != null ? o : Orientation.fromRepresentation(r.charAt(orientationPos), Direction.RIGHT), original);
		} catch(Exception e) {
			throw new MalformedMoveException(r);
		}
	}

	public Orientation orientation() {
		return this.orientation;
	}

	public Unit otherUnit() {
		return this.otherUnit;
	}

	public String representation() {
		return this.repr;
	}

	public Unit unit() {
		return this.unit;
	}
}