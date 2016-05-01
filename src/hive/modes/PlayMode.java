package hive.modes;

import hive.components.HivePane;
import hive.helpers.Move;
import hive.helpers.Player;
import hive.helpers.messages.InfoMessage;
import hive.interfaces.Mode;
import hive.models.PlayModel;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Opens the application in Play(game)-mode.
 * <p>
 * Created at 2/04/16 15:44
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class PlayMode implements Mode {
	//TODO: Wegdoen//
	private String player1 = "Jeej";
	private String player2 = "Pieter";

	@Override
	public void start(Stage s, List<String> p) {
		while (this.player1 == null || this.player1.length() < 1) {
			TextInputDialog player1Dialog = new TextInputDialog(System.getProperty("user.name"));
			player1Dialog.setContentText("Naam:");
			player1Dialog.setHeaderText("Speler 1");
			player1Dialog.showAndWait().ifPresent(n -> this.player1 = n != null && n.length() > 1 && !n.equalsIgnoreCase(this.player2) ? n : null);
		}

		while (this.player2 == null || this.player2.length() < 1) {
			TextInputDialog player2Dialog = new TextInputDialog(System.getProperty("user.name"));
			player2Dialog.setContentText("Naam:");
			player2Dialog.setHeaderText("Speler 2");
			player2Dialog.showAndWait().ifPresent(n -> this.player2 = n != null && n.length() > 1 && !n.equalsIgnoreCase(this.player1) ? n : null);
		}

		PlayModel model = new PlayModel(this.player1, this.player2);

		s.setScene(new Scene(new HivePane(model)));
		s.show();

		model.winnerProperty().addListener((o, od, nw) -> {
			if (nw != null) {
				s.close();
				new InfoMessage("Game ended.", nw.name() + " has won the game in " + (model.totalMoves() - 1) + " moves.").render();
				writeLog(model.moves(), nw);
			}
		});
	}

	@Override
	public boolean valid(Integer args) {
		return args == 0;
	}

	private static void writeLog(Collection<Move> moves, Player winner) {
		Path p = Paths.get(System.getProperty("user.home"), "hive-" + System.currentTimeMillis() / 1000 + ".txt");

		Collection<String> lines = new ArrayList<>(moves.size() + 2);
		moves.forEach(m -> lines.add(m.representation()));
		lines.add("Congratiulations to " + winner.name() + '!');
		try {
			Files.write(p, lines, StandardOpenOption.CREATE);
			new InfoMessage("Match report was written to " + p).render();
		} catch (IOException ignored) {
			//
		}
	}
}
