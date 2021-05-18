package hive.modes;

import hive.Hive;
import hive.components.HivePane;
import hive.helpers.Move;
import hive.helpers.Player;
import hive.helpers.StringUtils;
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
import java.text.MessageFormat;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
		while (this.player1 == null || this.player1.length() < 1) {
			TextInputDialog player1Dialog = new TextInputDialog(StringUtils.ucfirst(System.getProperty("user.name")) + ' ' + Player.randomAdjective());
			player1Dialog.setContentText(Hive.BUNDLE.getString("modes_play_name") + ':');
			player1Dialog.setHeaderText(Hive.BUNDLE.getString("modes_play_player") + " 1");
			player1Dialog.showAndWait().ifPresent(n -> this.player1 = n != null && n.length() > 1 && !n.equalsIgnoreCase(this.player2) ? n : null);
		}

		while (this.player2 == null || this.player2.length() < 1) {
			TextInputDialog player2Dialog = new TextInputDialog(Player.randomFirstName() + ' ' + Player.randomAdjective());
			player2Dialog.setContentText(Hive.BUNDLE.getString("modes_play_name") + ':');
			player2Dialog.setHeaderText(Hive.BUNDLE.getString("modes_play_player") + " 2");
			player2Dialog.showAndWait().ifPresent(n -> this.player2 = n != null && n.length() > 1 && !n.equalsIgnoreCase(this.player1) ? n : null);
		}

		PlayModel model = new PlayModel(this.player1, this.player2);

		Scene scene = new Scene(new HivePane(model));
		scene.getStylesheets().add(Hive.class.getResource("/stylesheet.min.css").toString());

		s.setScene(scene);
		s.show();

		model.winnerProperty().addListener((o, od, nw) -> {
			if (nw != null) {
				s.close();
				new InfoMessage(Hive.BUNDLE.getString("modes_play_gameover"), MessageFormat.format(Hive.BUNDLE.getString("modes_play_gameover_msg"), nw.name(), model.totalMoves() - 1)).render();
				writeLog(model.moves());
			}
		});
	}

	@Override
	public boolean valid(Integer args) {
		return args == 0;
	}

	/**
	 * Writes the list of moves to a file.
	 *
	 * @param moves the list of moves
	 */
	private static void writeLog(Collection<Move> moves) {
		Path p = Paths.get(System.getProperty("user.home"), "hive-" + System.currentTimeMillis() / 1000 + ".txt");

		try {
			Files.write(p, moves.stream().map(Move::representation).collect(Collectors.toList()), StandardOpenOption.CREATE);
			new InfoMessage(Hive.BUNDLE.getString("modes_play_report"), MessageFormat.format(Hive.BUNDLE.getString("modes_play_report_msg"), p)).render();
		} catch (IOException ignored) {
			//
		}
	}
}
