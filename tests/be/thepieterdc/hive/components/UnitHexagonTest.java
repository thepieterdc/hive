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

		/*
		antHexagon.setScaleX(15);
		antHexagon.setScaleY(15);
		beatleHexagon.setScaleX(15);
		beatleHexagon.setScaleY(15);
		grasshopperHexagon.setScaleX(15);
		grasshopperHexagon.setScaleY(15);
		ladybugHexagon.setScaleX(15);
		ladybugHexagon.setScaleY(15);
		mosquitoHexagon.setScaleX(15);
		mosquitoHexagon.setScaleY(15);
		pillbugHexagon.setScaleX(15);
		pillbugHexagon.setScaleY(15);
		queenHexagon.setScaleX(15);
		queenHexagon.setScaleY(15);
		spiderHexagon.setScaleX(15);
		spiderHexagon.setScaleY(15);
		*/

		HBox hbox = new HBox(antHexagon, beatleHexagon, grasshopperHexagon, ladybugHexagon, mosquitoHexagon, pillbugHexagon, queenHexagon, spiderHexagon);
		hbox.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		return hbox;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
