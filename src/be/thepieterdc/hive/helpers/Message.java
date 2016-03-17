package be.thepieterdc.hive.helpers;

import javafx.application.Platform;
import javafx.scene.control.Alert;

/**
 * Class that displays a message alert.
 * <p>
 * Created at 17/03/16 14:20
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public abstract class Message extends Alert {
	private final boolean shutDown;

	/**
	 * Message constructor.
	 * @param message the message
	 * @param type the type
	 */
	public Message(String message, AlertType type) {
		this(message, type, false);
	}

	/**
	 * Message constructor.
	 * @param message the message
	 * @param type the type
	 * @param shutDown true to shutdown the program after the message was shown
	 */
	public Message(String message, AlertType type, boolean shutDown) {
		super(type, message);
		this.shutDown = shutDown;
	}

	/**
	 * Renders the message to the screen.
	 */
	public void render() {
		this.showAndWait();
		if(this.shutDown) {
			Platform.exit();
		}
	}
}
