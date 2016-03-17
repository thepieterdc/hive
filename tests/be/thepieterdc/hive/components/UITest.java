package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.Svg;
import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * Tests the entire UI
 * <p>
 * Created at 15/03/16 12:05
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UITest extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		ViewerModel model = new ViewerModel(Arrays.asList(new Move(0, "Start"), new Move(1, "Test"), new Move(2, "Lele")));

		ListView<Move> movesViewPane = new ListView<>();
		movesViewPane.getItems().addAll(model.moves());

		MovesButton begin = new MovesButton(model, Svg.MOVEBUTTON_BEGIN) {
			@Override
			public void handle(Event event) {
				movesViewPane.getSelectionModel().selectFirst();
			}
		};

		HBox buttonBarPane = new HBox(begin);

		VBox movesPane = new VBox(movesViewPane, buttonBarPane);

		Polygon hexOne = new Polygon();
		hexOne.getPoints().addAll(0.0, 0.0, 0.0, 20.0, 20.0, 20.0, 20.0, 0.0);
		Polygon hexTwo = new Polygon();
		hexTwo.getPoints().addAll(20.0, 20.0, 20.0, 40.0, 40.0, 40.0, 40.0, 20.0);
		Polygon hexThree = new Polygon();
		hexThree.getPoints().addAll(-20.0, -20.0, -20.0, -40.0, -40.0, -40.0, -40.0, -20.0);

		Group hexagons = new Group();
		hexagons.getChildren().addAll(hexOne, hexTwo, hexThree);

		StackPane playPane = new StackPane(hexagons);


		SplitPane mainPane = new SplitPane(movesPane, playPane);
		mainPane.setDividerPositions(0.30);

		Label[] topLabels = new Label[] {new Label("wQ"), new Label("wA1"), new Label("wA2"), new Label("wA3"), new Label("wS1"), new Label("wS2"), new Label("wB1"), new Label("wB1"), new Label("wG1"), new Label("wG2"), new Label("wG3")};
		Label[] bottomLabels = new Label[] {new Label("bQ"), new Label("bA1"), new Label("bA2"), new Label("bA3"), new Label("bS1"), new Label("bS2"), new Label("bB1"), new Label("bB1"), new Label("bG1"), new Label("bG2"), new Label("bG3")};

		//TILEPANE//
		GridPane bottomPane = new GridPane();
		bottomPane.setGridLinesVisible(true);
		bottomPane.addRow(0, topLabels);
		bottomPane.addRow(1, bottomLabels);
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

		SplitPane root = new SplitPane(mainPane, bottomPane);
		root.setDividerPositions(0.70);
		root.setOrientation(Orientation.VERTICAL);
		root.setPrefSize(800, 500);

		Scene s = new Scene(root);
		stage.setScene(s);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
