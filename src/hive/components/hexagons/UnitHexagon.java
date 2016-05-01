package hive.components.hexagons;

import hive.helpers.Unit;
import javafx.scene.Cursor;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;

import java.util.stream.IntStream;

/**
 * UnitHexagon component.
 * <p>
 * Created at 18/03/16 20:10
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class UnitHexagon extends Hexagon {
	private final Circle[] ranks;
	private final Unit unit;
	private final SVGPath unitSvg;

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

		this.unitSvg = this.unit.type().path();
		this.unitSvg.setFill(this.unit.player().color());

		this.ranks = new Circle[this.unit.rank()];
		IntStream.range(0, this.ranks.length).forEach(i -> this.ranks[i] = new Circle(1, this.unit.player().color()));

		this.colour(this.unit.player().color().invert(), this.unit.player().color());
		this.setCursor(Cursor.HAND);

		this.getChildren().addAll(this.unitSvg);
		this.getChildren().addAll(this.ranks);
	}
	
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

	@Override
	public void scale(double factor) {
		if (factor <= 0) {
			throw new IllegalArgumentException("Parameter \"factor\" is negative or equal to zero.");
		}
		super.scale(factor);
		this.unitSvg.setScaleX(factor * 1.5);
		this.unitSvg.setScaleY(factor * 1.5);
		this.unitSvg.setTranslateX(this.width() / 2 - factor * 2.4 * this.unitSvg.getLayoutBounds().getWidth());
		IntStream.range(0, this.ranks.length).forEach(i -> {
			this.ranks[i].setScaleX(factor * 0.8);
			this.ranks[i].setScaleY(factor * 0.8);
			this.ranks[i].setTranslateX(0.60 * this.width() / 2);
			this.ranks[i].setTranslateY(-this.height() / (2 * factor) + i * 3 * factor);
		});
	}

	@Override
	public void select(boolean b) {
		this.setEffect(b ? new DropShadow(20, Color.BLUE) : null);
	}

	@Override
	public boolean selectable() {
		return true;
	}

	@Override
	public String toString() {
		return "UnitHexagon[unit=" + this.unit.representation() + ", x=" + this.getTranslateX() + ", y=" + this.getTranslateY() + ']';
	}

	public Unit unit() {
		return this.unit;
	}
}
