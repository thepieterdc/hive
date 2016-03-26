package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.Coordinate;
import be.thepieterdc.hive.interfaces.Scalable;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;

/**
 * Hexagon component.
 * <p>
 * Created at 18/03/16 19:06
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
class Hexagon extends Polygon implements Scalable {
	private static final double RADIUS = 10.0;
	private static final double SQRT75 = 8.660254037844387;

	Hexagon() {
		this.getPoints().addAll(top().asList());
		this.getPoints().addAll(topRight().asList());
		this.getPoints().addAll(bottomRight().asList());
		this.getPoints().addAll(bottom().asList());
		this.getPoints().addAll(bottomLeft().asList());
		this.getPoints().addAll(topLeft().asList());
		this.setStrokeType(StrokeType.INSIDE);
		this.setStrokeWidth(1.0);
	}

	private static Coordinate bottom() {
		return new Coordinate(0.0, -RADIUS);
	}

	private static Coordinate bottomLeft() {
		return new Coordinate(-SQRT75, -RADIUS / 2.0);
	}

	private static Coordinate bottomRight() {
		return new Coordinate(SQRT75, -RADIUS / 2.0);
	}

	@Override
	public double height() {
		return this.getScaleX() * (top().y() - bottom().y() + this.getStrokeWidth());
	}

	@Override
	public void scale(double factor) {
		if(factor <= 0) {
			throw new IllegalArgumentException("Parameter \"factor\" is negative or equal to zero.");
		}
		this.setScaleX(factor);
		this.setScaleY(factor);
	}

	private static Coordinate top() {
		return new Coordinate(0.0, RADIUS);
	}

	private static Coordinate topLeft() {
		return new Coordinate(-SQRT75, RADIUS / 2.0);
	}

	private static Coordinate topRight() {
		return new Coordinate(SQRT75, RADIUS / 2.0);
	}

	@Override
	public String toString() {
		return "Hexagon[x=" + this.getTranslateX() + ", y=" + this.getTranslateY() + ']';
	}

	@Override
	public double width() {
		return this.getScaleX() * (topRight().x() - bottomLeft().x() + this.getStrokeWidth());
	}
}
