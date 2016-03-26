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
		return String.valueOf(this.unit().player().id()) + this.unit().type().abbreviation() + (this.unit().rank() != 0 ? this.unit().rank() : "");
	}
}