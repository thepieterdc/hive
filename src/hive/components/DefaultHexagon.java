package hive.components;

import javafx.scene.paint.Color;

/**
 * DefaultHexagon component. An empty square on the playfield.
 * <p>
 * Created at 19/03/16 22:04
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class DefaultHexagon extends Hexagon {
	/**
	 * DefaultHexagon constructor.
	 */
	public DefaultHexagon() {
		this.setFill(Color.LIGHTGRAY);
		this.setStroke(Color.DARKGRAY);
	}

	@Override
	public String toString() {
		return "DefaultHexagon[x=" + this.getTranslateX() + ", y=" + this.getTranslateY() + ']';
	}
}
