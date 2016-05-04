package hive.helpers.messages;

import hive.Hive;
import hive.helpers.Message;
import javafx.scene.control.Alert;

/**
 * Message that shuts down the application.
 * <p>
 * Created at 17/03/16 14:29
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class ErrorMessage extends Message {
	/**
	 * ErrorMessage constructor.
	 *
	 * @param message the error message
	 */
	public ErrorMessage(String message) {
		this(message, true);
	}

	/**
	 * ErrorMessage constructor.
	 *
	 * @param message the error message
	 * @param b       true to shutdown the application
	 */
	public ErrorMessage(String message, boolean b) {
		super(message, Alert.AlertType.ERROR, b);
		this.setHeaderText(Hive.BUNDLE.getString("helpers_msg_error_header"));
	}
}
