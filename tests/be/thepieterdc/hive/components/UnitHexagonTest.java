package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.UnitType;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

/**
 * Test for the UnitHexagon component.
 * <p>
 * Created at 18/03/16 20:13
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnitHexagonTest extends ComponentTest {
	@Override
	protected Parent component() {
		return new UnitHexagon(UnitType.ANT, Color.BLACK);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
