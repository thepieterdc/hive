package be.thepieterdc.hive.exceptions;

/**
 * A move could not be unmarshalled.
 * <p>
 * Created at 20/03/16 12:46
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class UnmarshalException extends RuntimeException {
	public UnmarshalException(String m) {
		super(m);
	}
}
