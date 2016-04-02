package hive;

import hive.helpers.messages.ErrorMessage;
import hive.modes.PlayMode;
import hive.modes.TestMode;
import hive.modes.ViewerMode;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Viewer application.
 * <p>
 * Created at 16/03/16 19:16
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class Hive extends Application {

	public static final ResourceBundle BUNDLE = ResourceBundle.getBundle("hive/i18n");

	@Override
	public void start(Stage stage) {
		Application.Parameters args = this.getParameters();
		try {
			if (args == null || args.getRaw().size() > 2) {
				throw new IllegalArgumentException(BUNDLE.getString("main_syntax"));
			}

			Arrays.asList(new PlayMode(), new ViewerMode(), new TestMode()).stream().filter(m -> m.valid(args.getRaw().size())).findFirst().ifPresent(m -> m.start(stage, args.getRaw()));
		} catch (Exception e) {
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
