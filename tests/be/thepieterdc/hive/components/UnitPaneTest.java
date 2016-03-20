package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

/**
 * Test for the UnitPane component.
 * <p>
 * Created at 19/03/16 09:50
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnitPaneTest extends ComponentTest {
	@Override
	protected Parent component() {
		List<Move> moves = Arrays.asList(Move.fromRepresentation("start"), Move.fromRepresentation("wQ"), Move.fromRepresentation("bQ -wQ"));
		ViewerModel m = new ViewerModel(moves, null, Color.BLACK, Color.WHITE);
		UnitPane pane = new UnitPane(m);

		m.move(0);

		return pane;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
