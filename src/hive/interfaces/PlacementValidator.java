package hive.interfaces;

import hive.helpers.HexCoordinate;
import hive.helpers.Unit;

/**
 * Validates the placement of a unit.
 * <p>
 * Created at 29/04/16 18:43
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
@FunctionalInterface
public interface PlacementValidator {
	boolean validate(Unit u, HexCoordinate dest);
}
