package be.thepieterdc.hive.components;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

/**
 * Test for the Hexagon component.
 * <p>
 * Created at 18/03/16 19:07
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class HexagonTest extends ComponentTest {
	@Override
	protected Parent component() {
		Hexagon hexagon = new Hexagon();
		hexagon.setScaleX(10);
		hexagon.setScaleY(10);

		return new VBox(new Group(hexagon));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
