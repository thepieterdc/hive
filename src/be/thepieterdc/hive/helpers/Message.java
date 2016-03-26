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

	protected Message(String message, Alert.AlertType type, boolean s) {
		super(type, message);
		this.shutDown = s;
	}

	public void render() {
		this.showAndWait();
		if (this.shutDown) {
			Platform.exit();
		}
	}
}
