package be.thepieterdc.hive.viewer;

import be.thepieterdc.hive.components.HivePane;
import be.thepieterdc.hive.helpers.BoardState;
import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.helpers.messages.ErrorMessage;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Main application
 * <p>
 * Created at 16/03/16 19:16
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Main extends Application {

	@Override
	public void start(Stage stage) {
		Parameters args = this.getParameters();
		try {
			if(args == null || args.getRaw().size() == 0 || args.getRaw().size() > 2) {
				throw new IllegalArgumentException("Syntax: viewer.jar inputdata.ext [test]");
			}
			List<String> parameters = args.getRaw();

			List<Move> moves = Files.readAllLines(Paths.get(parameters.get(0))).stream().map(Move::fromRepresentation).collect(Collectors.toList());
			HashMap<Integer, BoardState> states = BoardState.unmarshal(moves);

			ViewerModel model = new ViewerModel(moves, states);

			Scene scene = new Scene(new HivePane(model));
			stage.setScene(scene);
			stage.setTitle("Hive Viewer"+(args.getRaw().size() == 2 ? " [Testmodus]":""));
			stage.show();

			if(args.getRaw().size() == 2) {
				model.move(model.totalMoves()-1);
				WritableImage screenshot = scene.snapshot(null);

				File outFile = Paths.get(args.getRaw().get(1), "screenshot.png").toFile();
				ImageIO.write(SwingFXUtils.fromFXImage(screenshot, null), "png", outFile);
			} else {
				model.move(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Platform.runLater(() -> new ErrorMessage(e.getMessage()).render());
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
