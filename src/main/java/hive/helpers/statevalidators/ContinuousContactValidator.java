package hive.helpers.statevalidators;

import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Unit;
import hive.interfaces.Validatable;

import java.util.Map;

/**
 * Validates rule "Continuous Contact".
 * <p>
 * Created at 30/04/16 13:20
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class ContinuousContactValidator implements Validatable<BoardState> {
	@Override
	public String toString() {
		return "ContinuousContactValidator[]";
	}

	@Override
	public boolean valid(BoardState state) {
		return state.units().values().stream().noneMatch(c -> state.neighbours(c).isEmpty());
	}
}
