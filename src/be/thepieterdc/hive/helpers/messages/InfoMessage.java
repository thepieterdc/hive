package be.thepieterdc.hive.helpers.messages;

import be.thepieterdc.hive.helpers.Message;

/**
 * An informative message.
 * <p>
 * Created at 17/03/16 14:29
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class InfoMessage extends Message {
	/**
	 * InfoMessage constructor.
	 * @param message the message to display
	 */
	public InfoMessage(String message) {
		super(message, AlertType.INFORMATION);
	}
}
