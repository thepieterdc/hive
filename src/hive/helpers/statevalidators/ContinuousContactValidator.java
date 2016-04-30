package hive.helpers.statevalidators;

import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Unit;
import hive.interfaces.Validatable;

import java.util.Map;

/**
 * Validates rule "Continuous Contact".
 * <p>
 * Created at 30/04/16 11:57
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class ContinuousContactValidator implements Validatable<BoardState> {

	@Override
	public boolean valid(BoardState state) {
		for (Map.Entry<Unit, HexCoordinate> u : state.units().entrySet()) {
			if (state.neighbours(u.getValue()).isEmpty()) {
				return false;
			}
		}
		return true;
	}
}
