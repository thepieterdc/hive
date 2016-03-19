package be.thepieterdc.hive.viewer;

import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.helpers.messages.ErrorMessage;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Main application
 * <p>
 * Created at 16/03/16 19:16
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Main extends Application {
	private ViewerModel model;

	@Override
	public void start(Stage stage) {
		Parameters args = this.getParameters();
		try {
			if(args == null || args.getRaw().size() != 1) {
				throw new IllegalArgumentException("Syntax: viewer.jar inputdata.ext");
			}
			List<String> parameters = args.getRaw();
			try {
				List<String> movesString = Files.readAllLines(Paths.get(parameters.get(0)));
				List<Move> movesMove = new ArrayList<>();
				for(String s : movesString) {
					System.out.println(s);
					movesMove.add(Move.fromRepresentation(s));
				}
				this.model = new ViewerModel(movesMove, Color.BLACK, Color.WHITE);
			} catch(Exception e) {
				throw new Exception("Inputdata onleesbaar of onbestaand.");
			}

			//Placeholder//
			Pane rootPane = new Pane();

			Scene scene = new Scene(rootPane);
			stage.setScene(scene);
			stage.setTitle("Hive Viewer");
			stage.show();
		} catch (Exception e) {
			Platform.runLater(() -> new ErrorMessage(e.getMessage()).render());
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
