package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.Unit;
import be.thepieterdc.hive.interfaces.Scalable;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
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
	private final Circle[] ranks;
	private final Unit unit;
	private final SVGPath unitSvg;

	public UnitHexagon(Unit u, double beginScale) {
		this(u);
		this.scale(beginScale);
	}

	public UnitHexagon(Unit u) {
		this.unit = u;

		this.hexagon = new Hexagon();
		this.hexagon.setFill(this.unit.player().invert());
		this.hexagon.setStroke(this.unit.player());

		this.unitSvg = this.unit.type().path();
		this.unitSvg.setFill(this.unit.player());

		this.ranks = new Circle[this.unit.rank()];
		for(int i = 0; i < this.ranks.length; i++) {
			this.ranks[i] = new Circle(1, this.unit.player());
		}

		this.getChildren().addAll(this.hexagon, this.unitSvg);
		this.getChildren().addAll(this.ranks);
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
		for(int i = 0; i < this.ranks.length; i++) {
			this.ranks[i].setScaleX(factor*0.8);
			this.ranks[i].setScaleY(factor*0.8);
			this.ranks[i].setTranslateX(0.60*this.width()/2);
			this.ranks[i].setTranslateY(-this.height()/(2*factor)+i*3*factor);
		}
	}

	public Unit unit() {
		return this.unit;
	}

	@Override
	public double width() {
		return this.hexagon.width();
	}
}
