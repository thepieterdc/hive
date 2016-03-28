package hive.exceptions;

/**
 * Exception that is thrown when a move is incorrectly formatted.
 * <p>
 * Created at 19/03/16 18:06
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class MalformedMoveException extends RuntimeException {

	private final String move;

	/**
	 * MalformedMoveException constructor.
	 *
	 * @param m the representation of the move
	 * @param c the cause for the exception
	 */
	public MalformedMoveException(String m, Throwable c) {
		super("The following move is invalid: " + m, c);
		this.move = m;
	}

	/**
	 * @return the representation of the move
	 */
	public String move() {
		return this.move;
	}
}
