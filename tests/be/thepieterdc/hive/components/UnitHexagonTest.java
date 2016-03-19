package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.UnitType;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
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
		UnitHexagon antHexagon = new UnitHexagon(UnitType.ANT, Color.BLACK);
		UnitHexagon beatleHexagon = new UnitHexagon(UnitType.BEATLE, Color.TURQUOISE);
		UnitHexagon grasshopperHexagon = new UnitHexagon(UnitType.GRASSHOPPER, Color.YELLOW);
		UnitHexagon ladybugHexagon = new UnitHexagon(UnitType.LADYBUG, Color.GREEN);
		UnitHexagon mosquitoHexagon = new UnitHexagon(UnitType.MOSQUITO, Color.BLANCHEDALMOND);
		UnitHexagon pillbugHexagon = new UnitHexagon(UnitType.PILLBUG, Color.MEDIUMAQUAMARINE);
		UnitHexagon queenHexagon = new UnitHexagon(UnitType.QUEEN, Color.RED);
		UnitHexagon spiderHexagon = new UnitHexagon(UnitType.SPIDER, Color.PURPLE);

		antHexagon.scale(15);
		beatleHexagon.scale(15);
		grasshopperHexagon.scale(15);
		ladybugHexagon.scale(15);
		mosquitoHexagon.scale(15);
		pillbugHexagon.scale(15);
		queenHexagon.scale(15);
		spiderHexagon.scale(15);

		HBox hbox = new HBox(antHexagon, beatleHexagon, grasshopperHexagon, ladybugHexagon, mosquitoHexagon, pillbugHexagon, queenHexagon, spiderHexagon);
		hbox.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		return hbox;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
