package be.thepieterdc.hive.exceptions;

/**
 * A move is incorrectly formatted.
 * <p>
 * Created at 19/03/16 18:06
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class MalformedMoveException extends RuntimeException {

	private final String move;

	public MalformedMoveException(String m, Throwable c) {
		super("The following move is invalid: " + m, c);
		this.move = m;
	}

	public String move() {
		return this.move;
	}
}
