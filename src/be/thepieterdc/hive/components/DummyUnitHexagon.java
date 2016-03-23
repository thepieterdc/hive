package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.UnitType;
import be.thepieterdc.hive.helpers.Unit;
import javafx.scene.paint.Color;

/**
 * Description here
 * <p>
 * Created at 23/03/16 21:47
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class DummyUnitHexagon extends UnitHexagon {
	public DummyUnitHexagon() {
		super(new Unit(Color.AQUAMARINE, UnitType.BEATLE));
	}
}
