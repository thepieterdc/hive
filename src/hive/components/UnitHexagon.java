package hive.components;

import hive.helpers.Unit;
import hive.interfaces.Scalable;
import hive.interfaces.Translatable;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;

/**
 * UnitHexagon component.
 * <p>
 * Created at 18/03/16 20:10
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class UnitHexagon extends Group implements Scalable, Translatable {
	private final Hexagon hexagon;
	private final Circle[] ranks;
	private final Unit unit;
	private final SVGPath unitSvg;

	/**
	 * UnitHexagon constructor.
	 *
	 * @param u          the unit
	 * @param beginScale the initial scale
	 */
	public UnitHexagon(Unit u, double beginScale) {
		this(u);
		this.scale(beginScale);
	}

	/**
	 * UnitHexagon constructor.
	 *
	 * @param u the unit
	 */
	public UnitHexagon(Unit u) {
		if (u == null) {
			throw new IllegalArgumentException("Parameter \"u\" is null.");
		}
		this.unit = u;

		this.hexagon = new Hexagon();
		this.hexagon.setFill(this.unit.player().color().invert());
		this.hexagon.setStroke(this.unit.player().color());

		this.unitSvg = this.unit.type().path();
		this.unitSvg.setFill(this.unit.player().color());

		this.ranks = new Circle[this.unit.rank()];
		for (int i = 0; i < this.ranks.length; i++) {
			this.ranks[i] = new Circle(1, this.unit.player().color());
		}

		this.getChildren().addAll(this.hexagon, this.unitSvg);
		this.getChildren().addAll(this.ranks);
	}

	public void disable() {
		this.setOpacity(0.2);
	}

	public void enable() {
		this.setOpacity(1);
	}

	@Override
	public double height() {
		return this.hexagon.height();
	}

	@Override
	public void scale(double factor) {
		if (factor <= 0) {
			throw new IllegalArgumentException("Parameter \"factor\" is negative or equal to zero.");
		}
		this.hexagon.scale(factor);
		this.unitSvg.setScaleX(factor * 1.5);
		this.unitSvg.setScaleY(factor * 1.5);
		this.unitSvg.setTranslateX(this.width() / 2 - factor * 2.4 * this.unitSvg.getLayoutBounds().getWidth());
		for (int i = 0; i < this.ranks.length; i++) {
			this.ranks[i].setScaleX(factor * 0.8);
			this.ranks[i].setScaleY(factor * 0.8);
			this.ranks[i].setTranslateX(0.60 * this.width() / 2);
			this.ranks[i].setTranslateY(-this.height() / (2 * factor) + i * 3 * factor);
		}
	}

	public void select(boolean b) {
		this.setEffect(b ? new DropShadow(20, Color.BLUE) : null);
	}

	@Override
	public String toString() {
		return "UnitHexagon[unit=" + this.unit.representation() + ", x=" + this.getTranslateX() + ", y=" + this.getTranslateY() + ']';
	}

	@Override
	public void translate(double x, double y) {
		this.setTranslateX(x);
		this.setTranslateY(y);
	}

	public Unit unit() {
		return this.unit;
	}

	@Override
	public double width() {
		return this.hexagon.width();
	}
}
