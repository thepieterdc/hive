package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.Unit;
import be.thepieterdc.hive.interfaces.Scalable;
import javafx.scene.Group;
import javafx.scene.shape.SVGPath;

/**
 * UnitHexagon component.
 * <p>
 * Created at 18/03/16 20:10
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnitHexagon extends Group implements Scalable {
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

		this.unitSvg = u.type().path();
		this.unitSvg.setFill(u.player());

		this.getChildren().addAll(this.hexagon, this.unitSvg);
	}

	public Hexagon hexagon() {
		return this.hexagon;
	}

	@Override
	public double height() {
		return this.hexagon.height();
	}

	@Override
	public void scale(double factor) {
		this.hexagon.scale(factor);
		this.unitSvg.setScaleX(factor*1.5);
		this.unitSvg.setScaleY(factor*1.5);
		this.unitSvg.setTranslateX(this.width()/2-factor*2.4*this.unitSvg.getLayoutBounds().getWidth());
	}

	public Unit unit() {
		return this.unit;
	}

	@Override
	public double width() {
		return this.hexagon.width();
	}
}
