package be.thepieterdc.hive.viewer;

import be.thepieterdc.hive.components.MovesPane;
import be.thepieterdc.hive.components.UnitHexagon;
import be.thepieterdc.hive.components.UnitPane;
import be.thepieterdc.hive.data.UnitType;
import be.thepieterdc.hive.exceptions.MalformedMoveException;
import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.helpers.messages.ErrorMessage;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
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
					movesMove.add(Move.fromRepresentation(s));
				}
				this.model = new ViewerModel(movesMove, Color.BLACK, Color.WHITE);
			} catch(IOException e) {
				throw new Exception("Inputdata was not found or is unreadable.");
			} catch(MalformedMoveException e) {
				throw new Exception("Invalid move: "+e.move());
			}

			MovesPane movesPane = new MovesPane(this.model);

			UnitHexagon hexOne = new UnitHexagon(UnitType.BEATLE, Color.TURQUOISE);
			hexOne.scale(10);
			hexOne.setTranslateX(-200);
			UnitHexagon hexTwo = new UnitHexagon(UnitType.LADYBUG, Color.MEDIUMAQUAMARINE);
			hexTwo.scale(10);
			UnitHexagon hexThree = new UnitHexagon(UnitType.QUEEN, Color.BLANCHEDALMOND);
			hexThree.scale(10);
			hexThree.setTranslateX(200);

			Group hexagons = new Group();
			hexagons.getChildren().addAll(hexOne, hexTwo, hexThree);

			StackPane playPane = new StackPane(hexagons);

			SplitPane mainPane = new SplitPane(movesPane, playPane);
			mainPane.setDividerPositions(0.0);

			//TILEPANE//
			UnitPane bottomPane = new UnitPane(this.model);

			SplitPane root = new SplitPane(mainPane, bottomPane);
			root.setDividerPositions(100.0);
			root.setOrientation(Orientation.VERTICAL);
			root.setPrefSize(800, 500);

			this.model.move(0);

			Scene scene = new Scene(root);
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
