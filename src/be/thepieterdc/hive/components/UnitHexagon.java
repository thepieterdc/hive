package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.Unit;
import javafx.scene.Group;
import javafx.scene.shape.SVGPath;

/**
 * UnitHexagon component.
 * <p>
 * Created at 18/03/16 20:10
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnitHexagon extends Group {
	private final Hexagon hexagon;
	private final Unit unit;
	private final SVGPath unitSvg;

	public UnitHexagon(Unit u, double beginScale) {
		this(u);
		this.scale(beginScale);
	}

	public UnitHexagon(Unit u) {
		this.unit = u;

		this.hexagon = new Hexagon();
		this.hexagon.setFill(u.player().invert());
		this.hexagon.setStroke(u.player());
		this.hexagon.setStrokeWidth(0.2);

		this.unitSvg = u.type().path();
		this.unitSvg.setFill(u.player());
		this.unitSvg.scaleXProperty().bind(this.hexagon.scaleXProperty().multiply(1.8));
		this.unitSvg.scaleYProperty().bind(this.hexagon.scaleYProperty().multiply(1.8));

		this.getChildren().addAll(this.hexagon, this.unitSvg);
	}

	public Hexagon hexagon() {
		return this.hexagon;
	}

	public double height() {
		return this.hexagon.height();
	}

	public void scale(double factor) {
		this.hexagon.setScaleX(factor);
		this.hexagon.setScaleY(factor);
	}

	public Unit unit() {
		return this.unit;
	}

	public double width() {
		return this.hexagon.width();
	}
}
