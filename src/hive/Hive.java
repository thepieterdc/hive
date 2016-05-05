package hive;

import hive.helpers.messages.ErrorMessage;
import hive.modes.PlayMode;
import hive.modes.ViewerMode;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Hive application.
 * <p>
 * Created at 16/03/16 19:16
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class Hive extends Application {

	public static final ResourceBundle BUNDLE = ResourceBundle.getBundle("hive/i18n");

	@Override
	public void start(Stage stage) {
		try {
			MediaPlayer backgroundPlayer = new MediaPlayer(new Media(this.getClass().getResource("/fantasie.mp3").toString()));
			backgroundPlayer.setOnEndOfMedia(() -> backgroundPlayer.seek(Duration.ZERO));
			backgroundPlayer.setVolume(0.8);
			backgroundPlayer.play();
		} catch(MediaException ignored) {
			new ErrorMessage(BUNDLE.getString("main_musicerror"), false).render();
		}

		Application.Parameters args = this.getParameters();
		try {
			if (args == null || args.getRaw().size() > 2) {
				throw new IllegalArgumentException(BUNDLE.getString("main_syntax"));
			}

			Arrays.asList(new PlayMode(), new ViewerMode()).stream().filter(m -> m.valid(args.getRaw().size())).findFirst().ifPresent(m -> m.start(stage, args.getRaw()));
		} catch (Exception e) {
			e.printStackTrace();
			Platform.runLater(() -> new ErrorMessage(e.getMessage()).render());
		}
	}

	/**
	 * Starts the application.
	 *
	 * @param args command line arguments
	 */
	public static void main(String... args) {
		launch(args);
	}
}
