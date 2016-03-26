package be.thepieterdc.hive.helpers.messages;

import be.thepieterdc.hive.helpers.Message;
import javafx.scene.control.Alert;

/**
 * An error message; shutting down the application.
 * <p>
 * Created at 17/03/16 14:29
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class ErrorMessage extends Message {
	public ErrorMessage(String message) {
		super(message, Alert.AlertType.ERROR, true);
	}
}
