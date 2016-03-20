package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

/**
 * Test for the MovesPane component.
 * <p>
 * Created at 18/03/16 09:47
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class MovesPaneTest extends ComponentTest {
	@Override
	protected Parent component() {
		List<Move> moves = Arrays.asList(Move.fromRepresentation("start"), Move.fromRepresentation("wQ"), Move.fromRepresentation("bQ -wQ"));
		ViewerModel m = new ViewerModel(moves, null, Color.BLACK, Color.WHITE);
		MovesPane movesPane = new MovesPane(m);

		m.move(0);

		return movesPane;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
