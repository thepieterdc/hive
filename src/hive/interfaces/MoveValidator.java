package hive.interfaces;

import hive.helpers.BoardState;
import hive.helpers.Move;

/**
 * Validates a move.
 * <p>
 * Created at 23/04/16 13:09
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
@FunctionalInterface
public interface MoveValidator {
	boolean validate(BoardState state, Move m);
}
