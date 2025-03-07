package hive.helpers.moves;

import hive.helpers.Move;

/**
 * The start move; nothing.
 * <p>
 * Created at 19/03/16 13:17
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class StartMove extends Move {
	/**
	 * StartMove constructor.
	 */
	public StartMove() {
		super(null, null, null);
	}

	@Override
	public String representation() {
		return "Start";
	}

	@Override
	public String toString() {
		return "StartMove[]";
	}

	@Override
	public Move.MoveType type() {
		return Move.MoveType.START;
	}
}