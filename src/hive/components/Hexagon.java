package hive.components;

import hive.helpers.Coordinate;
import hive.interfaces.Scalable;
import hive.interfaces.Translatable;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;

/**
 * Hexagon component.
 * <p>
 * Created at 18/03/16 19:06
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Hexagon extends Polygon implements Scalable, Translatable {
	private static final double RADIUS = 10.0;
	private static final double SQRT75 = 8.660254037844387;

	/**
	 * Hexagon constructor.
	 */
	public Hexagon() {
		this.getPoints().addAll(top().asList());
		this.getPoints().addAll(topRight().asList());
		this.getPoints().addAll(bottomRight().asList());
		this.getPoints().addAll(bottom().asList());
		this.getPoints().addAll(bottomLeft().asList());
		this.getPoints().addAll(topLeft().asList());
		this.setStrokeType(StrokeType.INSIDE);
		this.setStrokeWidth(1.0);
	}

	/**
	 * Calculates the coordinate of the bottom point.
	 *
	 * @return the coordinate of the bottom point
	 */
	private static Coordinate bottom() {
		return new Coordinate(0.0, -RADIUS);
	}

	/**
	 * Calculates the coordinate of the bottom-left point.
	 *
	 * @return the coordinate of the bottom-left point
	 */
	private static Coordinate bottomLeft() {
		return new Coordinate(-SQRT75, -RADIUS / 2.0);
	}

	/**
	 * Calculates the coordinate of the bottom-right point.
	 *
	 * @return the coordinate of the bottom-right point
	 */
	private static Coordinate bottomRight() {
		return new Coordinate(SQRT75, -RADIUS / 2.0);
	}

	@Override
	public final double height() {
		return this.getScaleX() * (top().y() - bottom().y());
	}

	@Override
	public void scale(double factor) {
		if (factor <= 0.0) {
			throw new IllegalArgumentException("Parameter \"factor\" is negative or equal to zero.");
		}
		this.setScaleX(factor);
		this.setScaleY(factor);
	}

	/**
	 * Calculates the coordinate of the top point.
	 *
	 * @return the coordinate of the top point
	 */
	private static Coordinate top() {
		return new Coordinate(0.0, RADIUS);
	}

	/**
	 * Calculates the coordinate of the top-left point.
	 *
	 * @return the coordinate of the top-left point
	 */
	private static Coordinate topLeft() {
		return new Coordinate(-SQRT75, RADIUS / 2.0);
	}

	/**
	 * Calculates the coordinate of the top-right point.
	 *
	 * @return the coordinate of the top-right point
	 */
	private static Coordinate topRight() {
		return new Coordinate(SQRT75, RADIUS / 2.0);
	}

	@Override
	public String toString() {
		return "Hexagon[x=" + this.getTranslateX() + ", y=" + this.getTranslateY() + ']';
	}

	@Override
	public void translate(double x, double y) {
		this.setTranslateX(x);
		this.setTranslateY(y);
	}

	@Override
	public final double width() {
		return this.getScaleX() * (topRight().x() - bottomLeft().x());
	}
}
