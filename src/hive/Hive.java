package hive;

import hive.components.HivePane;
import hive.helpers.BoardState;
import hive.helpers.Move;
import hive.helpers.messages.ErrorMessage;
import hive.models.ViewerModel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Viewer application.
 * <p>
 * Created at 16/03/16 19:16
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class Hive extends Application {

	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("hive/i18n");

	@Override
	public void start(Stage stage) {
		Application.Parameters args = this.getParameters();
		try {
			if (args == null || args.getRaw().isEmpty() || args.getRaw().size() > 2) {
				throw new IllegalArgumentException(BUNDLE.getString("main_syntax"));
			}

			List<Move> moves = Files.readAllLines(Paths.get(args.getRaw().get(0))).stream().map(Move::fromRepresentation).collect(Collectors.toList());

			ViewerModel model = new ViewerModel(moves, BoardState.unmarshal(moves));

			Scene scene = new Scene(new HivePane(model));

			stage.setScene(scene);
			stage.setTitle("Hive Viewer" + (args.getRaw().size() == 2 ? " [" + BUNDLE.getString("main_testmode") + ']' : ""));
			stage.show();

			model.move(args.getRaw().size() == 2 ? model.totalMoves() - 1 : 0);

			if (args.getRaw().size() == 2) {
				ImageIO.write(SwingFXUtils.fromFXImage(scene.snapshot(null), null), "png", Paths.get(args.getRaw().get(1), "screenshot.png").toFile());
				System.out.println("[Hive " + BUNDLE.getString("main_testmode") + "] " + BUNDLE.getString("main_pieces"));
				model.boardState().transferPieces().forEach(System.out::println);
			}
		} catch (IOException e) {
			Platform.runLater(() -> new ErrorMessage(e.getMessage() + ' ' + BUNDLE.getString("main_filenotfound")).render());
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
