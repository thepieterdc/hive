package hive;

import hive.helpers.messages.ErrorMessage;
import hive.modes.PlayMode;
import hive.modes.ViewerMode;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Stream;

/**
 * Hive application.
 * <p>
 * Created at 16/03/16 19:16
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class Hive extends Application {

	public static final ResourceBundle BUNDLE = ResourceBundle.getBundle("i18n");

	@Override
	public void start(Stage stage) {
		try {
			final MediaPlayer backgroundPlayer = new MediaPlayer(new Media(this.getClass().getResource("/fantasie.mp3").toString()));
			backgroundPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			backgroundPlayer.setVolume(0.8);
			backgroundPlayer.play();
		} catch (MediaException ignored) {
			new ErrorMessage(BUNDLE.getString("main_musicerror"), false).render();
		}

		stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/logo.png")));

		final Application.Parameters args = this.getParameters();
		try {
			if (args == null || args.getRaw().size() > 2) {
				throw new IllegalArgumentException(BUNDLE.getString("main_syntax"));
			}

			Stream.of(new PlayMode(), new ViewerMode()).filter(m -> m.valid(args.getRaw().size())).findFirst().ifPresent(m -> m.start(stage, args.getRaw()));
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
