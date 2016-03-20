package be.thepieterdc.hive.viewer;

import be.thepieterdc.hive.components.MovesPane;
import be.thepieterdc.hive.components.PlayPane;
import be.thepieterdc.hive.components.UnitPane;
import be.thepieterdc.hive.exceptions.MalformedMoveException;
import be.thepieterdc.hive.helpers.BoardState;
import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.helpers.messages.ErrorMessage;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
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
	private ViewerModel model;

	@Override
	public void start(Stage stage) {
		Parameters args = this.getParameters();
		try {
			if(args == null || args.getRaw().size() != 1) {
				throw new IllegalArgumentException("Syntax: viewer.jar inputdata.ext");
			}
			List<String> parameters = args.getRaw();
			List<Move> moves;
			HashMap<Integer, BoardState> states;
			try {
				List<String> movesString = Files.readAllLines(Paths.get(parameters.get(0)));
				moves = movesString.stream().map(Move::fromRepresentation).collect(Collectors.toList());
				states = BoardState.unmarshall(moves);
			} catch(IOException e) {
				throw new Exception("Inputdata was not found or is unreadable.");
			} catch(MalformedMoveException e) {
				throw new Exception("Invalid move: "+e.move());
			}

			this.model = new ViewerModel(moves, states, Color.BLANCHEDALMOND, Color.DARKGRAY);

			MovesPane movesPane = new MovesPane(this.model);

			PlayPane playPane = new PlayPane(this.model);

			SplitPane mainPane = new SplitPane(movesPane, playPane);
			mainPane.setDividerPositions(0.0);

			//TILEPANE//
			UnitPane bottomPane = new UnitPane(this.model);

			VBox root = new VBox(mainPane, bottomPane);
			root.setPrefSize(800, 500);

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Hive Viewer");
			stage.show();
			this.model.move(0);
		} catch (Exception e) {
			e.printStackTrace();
			Platform.runLater(() -> new ErrorMessage(e.getMessage()).render());
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
