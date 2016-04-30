package hive.exceptions;

/**
 * Exception that is thrown when a move cannot be done because it violates the gameplay rules.
 * <p>
 * Created at 30/04/16 11:07
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class IllegalMoveException extends Exception {

	public IllegalMoveException() {
		super("Illegal move.");
	}
}
