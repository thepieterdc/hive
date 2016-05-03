package hive.exceptions;

import hive.Hive;
import hive.interfaces.Representable;

import java.text.MessageFormat;

/**
 * Exception that is thrown when a move cannot be done because it violates the gameplay rules.
 * <p>
 * Created at 30/04/16 11:07
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class IllegalMoveException extends Exception {

	public IllegalMoveException(Representable u, Representable dest) {
		super(MessageFormat.format(Hive.BUNDLE.getString("exceptions_illegalmove_msg"), u.representation(), dest.representation()));
	}
}
