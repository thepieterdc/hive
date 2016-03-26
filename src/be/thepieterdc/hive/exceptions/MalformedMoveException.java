package be.thepieterdc.hive.exceptions;

/**
 * A move is incorrectly formatted.
 * <p>
 * Created at 19/03/16 18:06
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class MalformedMoveException extends RuntimeException {

	private final String move;

	public MalformedMoveException(String m) {
		super("The following move is invalid: " + m);
		this.move = m;
	}

	public String move() {
		return this.move;
	}
}
