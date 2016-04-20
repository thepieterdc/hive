package hive.modes;

import hive.components.HivePane;
import hive.interfaces.Mode;
import hive.models.PlayModel;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.List;

/**
 * Opens the application in Play(game)-mode.
 * <p>
 * Created at 2/04/16 15:44
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class PlayMode implements Mode {
	private String player1;
	private String player2;

	@Override
	public void start(Stage s, List<String> p) {
		while(this.player1 == null || this.player1.length() < 1) {
			TextInputDialog player1Dialog = new TextInputDialog(System.getProperty("user.name"));
			player1Dialog.setContentText("Naam:");
			player1Dialog.setHeaderText("Speler 1");
			player1Dialog.showAndWait().ifPresent(n -> this.player1 = n != null && n.length() > 1 && !n.equalsIgnoreCase(this.player2) ? n : null);
		}

		while(this.player2 == null || this.player2.length() < 1) {
			TextInputDialog player2Dialog = new TextInputDialog(System.getProperty("user.name"));
			player2Dialog.setContentText("Naam:");
			player2Dialog.setHeaderText("Speler 2");
			player2Dialog.showAndWait().ifPresent(n -> this.player2 = n != null && n.length() > 1 && !n.equalsIgnoreCase(this.player1) ? n : null);
		}

		s.setScene(new Scene(new HivePane(new PlayModel(this.player1, this.player2))));
		s.show();
		s.setFullScreen(true);
	}

	@Override
	public boolean valid(Integer args) {
		return args == 0;
	}
}
