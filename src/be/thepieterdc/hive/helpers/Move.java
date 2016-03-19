package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.Direction;
import be.thepieterdc.hive.data.UnitType;
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
	private final Direction direction;
	private final Unit otherUnit;
	private final String repr;
	private final Unit unit;

	/**
	 * Move constructor.
	 * @param u the unit
	 * @param other the other unit
	 * @param d the direction
	 * @param r the representation
	 */
	public Move(Unit u, Unit other, Direction d, String r) {
		this.direction = d;
		this.otherUnit = other;
		this.repr = r;
		this.unit = u;
	}

	/**
	 * Creates a Move from the short representation.
	 * @param r the string representation
	 * @return the Move created
	 */
	public static Move fromRepresentation(String r) {
		String rep = r;
		r = r.toLowerCase();
		if(r.equals("start")) {
			return new StartMove();
		}

		Color thisCol = String.valueOf(r.charAt(0)).equals("b") ? Color.BLACK : Color.WHITE;
		UnitType thisType = UnitType.fromAbbreviation(r.charAt(1));
		int thisRank = thisType.equals(UnitType.QUEEN) ? 0 : (int) r.charAt(2);
		Unit thisUnit = new Unit(thisCol, thisType, thisRank);

		if(!r.contains(" ")) {
			//return new FirstMove(thisUnit);
		}
		r = r.substring(r.indexOf(' '));

		//Location of the /\- direction indicator can be on both sides of the move//
		int directionPos = 0;
		int colorPos = 1;
		int typePos = 2;
		int rankPos = 3;
		try {
			Direction d = Direction.fromRepresentation(r.charAt(0));
		} catch(IllegalArgumentException e) {
			colorPos = 0;
			typePos = 1;
			rankPos = 2;
			directionPos = 2;
		}

		Color otherCol = String.valueOf(r.charAt(colorPos)).equals("b") ? Color.BLACK : Color.WHITE;
		UnitType otherType = UnitType.fromAbbreviation(r.charAt(typePos));
		int otherRank = otherType.equals(UnitType.QUEEN) ? 0 : (int) r.charAt(rankPos);
		Unit otherUnit = new Unit(thisCol, thisType, thisRank);

		return new Move(thisUnit, otherUnit, null, rep);
	}

	@Override
	public String toString() {
		return this.repr;
	}
}
