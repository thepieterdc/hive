package hive.helpers;

import javafx.application.Platform;
import javafx.scene.control.Alert;

/**
 * Message generator; shows alert boxes.
 * <p>
 * Created at 17/03/16 14:20
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public abstract class Message extends Alert {
	private final boolean shutDown;

	/**
	 * Message constructor.
	 *
	 * @param message the message text
	 * @param type    the message type
	 * @param s       true to shutdown the application after the message has been shown
	 */
	protected Message(String message, Alert.AlertType type, boolean s) {
		super(type, message);
		this.getDialogPane().setMinWidth(500);
		this.shutDown = s;
	}

	/**
	 * Renders the message to the screen.
	 */
	public void render() {
		this.showAndWait();
		if (this.shutDown) {
			Platform.exit();
		}
	}
}
