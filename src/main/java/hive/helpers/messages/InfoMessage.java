package hive.helpers.messages;

import hive.helpers.Message;
import javafx.scene.control.Alert;

/**
 * Message that shows an informational text.
 * <p>
 * Created at 20/04/16 14:29
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class InfoMessage extends Message {
	/**
	 * InfoMessage constructor.
	 *
	 * @param message the info message
	 */
	public InfoMessage(String message) {
		super(message, Alert.AlertType.INFORMATION, false);
	}

	/**
	 * InfoMessage constructor.
	 *
	 * @param header  the header text
	 * @param message the info message
	 */
	public InfoMessage(String header, String message) {
		this(message);
		this.setHeaderText(header);
	}
}
