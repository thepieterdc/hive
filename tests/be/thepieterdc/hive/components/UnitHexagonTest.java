package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.UnitType;
import be.thepieterdc.hive.helpers.Unit;
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
		UnitHexagon antHexagon = new UnitHexagon(new Unit(Color.BLACK, UnitType.ANT));
		UnitHexagon beatleHexagon = new UnitHexagon(new Unit(Color.TURQUOISE, UnitType.BEATLE));
		UnitHexagon grasshopperHexagon = new UnitHexagon(new Unit(Color.YELLOW, UnitType.GRASSHOPPER));
		UnitHexagon ladybugHexagon = new UnitHexagon(new Unit(Color.GREEN, UnitType.LADYBUG));
		UnitHexagon mosquitoHexagon = new UnitHexagon(new Unit(Color.BLANCHEDALMOND, UnitType.MOSQUITO));
		UnitHexagon pillbugHexagon = new UnitHexagon(new Unit(Color.MEDIUMAQUAMARINE, UnitType.PILLBUG));
		UnitHexagon queenHexagon = new UnitHexagon(new Unit(Color.RED, UnitType.QUEEN));
		UnitHexagon spiderHexagon = new UnitHexagon(new Unit(Color.PURPLE, UnitType.SPIDER));

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
