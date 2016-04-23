package hive.interfaces;

import hive.helpers.BoardState;
import hive.helpers.HexCoordinate;
import hive.helpers.Unit;

/**
 * Validates a unit move.
 * <p>
 * Created at 23/04/16 14:44
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
@FunctionalInterface
public interface UnitMoveValidator {
	boolean validate(Unit u, BoardState state, HexCoordinate dest);
}
