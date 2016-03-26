package be.thepieterdc.hive.helpers.moves;

import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.helpers.Unit;

/**
 * The first move.
 * <p>
 * Created at 19/03/16 13:17
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class FirstMove extends Move {
	public FirstMove(Unit u, String r) {
		super(u, null, null);
	}

	@Override
	public String representation() {
		return this.unit().representation();
	}

	@Override
	public String toString() {
		return "FirstMove["+this.unit().representation()+"]";
	}
}