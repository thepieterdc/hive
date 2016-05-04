package hive.components.hexagons;

import javafx.scene.paint.Color;

/**
 * FreeHexagon component. An empty square on the playfield where a unit can move to.
 * <p>
 * Created at 19/03/16 22:04
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class FreeHexagon extends Hexagon {
	public FreeHexagon(double beginScale) {
		this();
		this.scale(beginScale);
	}

	public FreeHexagon() {
		this.colour(Color.LIGHTGRAY, Color.DARKGRAY);
	}

	@Override
	public void enable(boolean b) {
		this.colour(b ? Color.LIGHTGRAY : Color.RED, b ? Color.DARKGRAY : Color.DARKRED);
	}

	@Override
	public void select(boolean b) {
		//A FreeHexagon cannot be selected//
	}

	@Override
	public String toString() {
		return "FreeHexagon[x=" + this.getTranslateX() + ", y=" + this.getTranslateY() + ']';
	}

}
