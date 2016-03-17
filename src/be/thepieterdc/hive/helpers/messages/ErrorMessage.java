package be.thepieterdc.hive.helpers.messages;

import be.thepieterdc.hive.helpers.Message;

/**
 * An error message; shutting down the application.
 * <p>
 * Created at 17/03/16 14:29
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class ErrorMessage extends Message {
	/**
	 * ErrorMessage constructor.
	 * @param message the message to display
	 */
	public ErrorMessage(String message) {
		super(message, AlertType.ERROR, true);
	}
}
