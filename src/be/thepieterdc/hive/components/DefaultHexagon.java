package be.thepieterdc.hive.components;


import javafx.scene.paint.Color;

/**
 * A default Hexagon on the play field; an empty "square".
 * <p>
 * Created at 19/03/16 22:04
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class DefaultHexagon extends Hexagon {
	public DefaultHexagon() {
		super();
		this.setFill(Color.LIGHTGRAY);
		this.setStroke(Color.DARKGRAY);
		this.setStrokeWidth(1);
	}

	public void scale(double factor) {
		this.setScaleX(factor);
		this.setScaleY(factor);
	}
}
