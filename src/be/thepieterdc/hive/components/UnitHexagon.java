package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.UnitType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

/**
 * UnitHexagon component.
 * <p>
 * Created at 18/03/16 20:10
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnitHexagon extends StackPane {
	private final Hexagon hexagon;
	private final SVGPath unit;

	/**
	 * UnitHexagon constructor.
	 * @param unit the unit type
	 * @param color the unit color
	 * @param beginScale the default scale
	 */
	public UnitHexagon(UnitType unit, Color color, double beginScale) {
		this(unit, color);
		this.scale(beginScale);
	}

	/**
	 * UnitHexagon constructor.
	 * @param unit the unit type
	 * @param color the unit color
	 */
	public UnitHexagon(UnitType unit, Color color) {
		this.hexagon = new Hexagon();
		this.hexagon.setFill(color.invert());
		this.hexagon.setStroke(color);

		this.unit = unit.path();
		this.unit.setFill(color);
		this.unit.scaleXProperty().bind(this.hexagon.scaleXProperty().multiply(1.8));
		this.unit.scaleYProperty().bind(this.hexagon.scaleYProperty().multiply(1.8));

		this.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		this.getChildren().addAll(this.hexagon, this.unit);
	}

	/**
	 * @return the height of this hexagon
	 */
	public double height() {
		return this.hexagon.height();
	}

	/**
	 * Scales this hexagon with a given factor.
	 * @param factor the factor to scale
	 */
	public void scale(double factor) {
		this.hexagon.setScaleX(factor);
		this.hexagon.setScaleY(factor);
		this.setMinSize(this.width(), this.height());
	}

	/**
	 * @return the width of this hexagon
	 */
	public double width() {
		return this.hexagon.width();
	}
}
