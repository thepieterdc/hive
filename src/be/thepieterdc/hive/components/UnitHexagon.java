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
	 */
	public UnitHexagon(UnitType unit, Color color) {
		this.hexagon = new Hexagon();
		this.hexagon.setFill(color.invert());
		this.hexagon.setStroke(color);
		this.hexagon.setScaleX(15);
		this.hexagon.setScaleY(15);

		this.unit = unit.path();
		this.unit.setFill(color);
		this.unit.scaleXProperty().bind(this.hexagon.scaleXProperty().multiply(25/15));
		this.unit.scaleYProperty().bind(this.hexagon.scaleYProperty().multiply(25/15));

		this.setMinSize(hexagon.width(), hexagon.height());
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
	 * @return the width of this hexagon
	 */
	public double width() {
		return this.hexagon.width();
	}
}
