package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.UnitType;
import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

/**
 * Tests the entire UI
 * <p>
 * Created at 15/03/16 12:05
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UITest extends ComponentTest {
	@Override
	protected Parent component() {
		List<Move> moves = Arrays.asList(Move.fromRepresentation("start"), Move.fromRepresentation("test"), Move.fromRepresentation("test2"), Move.fromRepresentation("test3"));
		ViewerModel m = new ViewerModel(moves, Color.BLACK, Color.WHITE);

		MovesPane movesPane = new MovesPane(m);

		m.move(0);

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
		root.setDividerPositions(100.0);
		root.setOrientation(Orientation.VERTICAL);
		root.setPrefSize(800, 500);

		return root;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
