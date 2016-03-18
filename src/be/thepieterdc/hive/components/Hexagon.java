package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.Coordinate;
import javafx.scene.shape.Polygon;

/**
 * Hexagon component.
 * <p>
 * Created at 18/03/16 19:06
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Hexagon extends Polygon {
	private final Coordinate bottom;
	private final Coordinate bottomLeft;
	private final Coordinate top;
	private final Coordinate topRight;
	/**
	 * Hexagon constructor.
	 */
	public Hexagon() {
		this.bottom = bottom();
		this.bottomLeft = bottomLeft();
		this.top = top();
		this.topRight = topRight();

		this.getPoints().addAll(this.top.asList());
		this.getPoints().addAll(this.topRight.asList());
		this.getPoints().addAll(bottomRight().asList());
		this.getPoints().addAll(this.bottom.asList());
		this.getPoints().addAll(this.bottomLeft.asList());
		this.getPoints().addAll(topLeft().asList());
	}

	/**
	 * Calculates the coordinate of the bottom point.
	 * @return the coordinate of the bottom point
	 */
	public static Coordinate bottom() {
		return new Coordinate(0, -10);
	}

	/**
	 * Calculates the coordinate of the bottom-left point.
	 * @return the coordinate of the bottom-left point
	 */
	public static Coordinate bottomLeft() {
		return new Coordinate(-Math.sqrt(75), -5);
	}

	/**
	 * Calculates the coordinate of the bottom-right point.
	 * @return the coordinate of the bottom-right point
	 */
	public static Coordinate bottomRight() {
		return new Coordinate(Math.sqrt(75), -5);
	}

	/**
	 * Calculates the height of this hexagon.
	 * @return the height of the hexagon
	 */
	public double height() {
		return this.getScaleX() * (this.top.y() - this.bottom.y() + this.getStrokeWidth());
	}

	/**
	 * Calculates the coordinate of the top point
	 * @return the coordinate of the top point
	 */
	public static Coordinate top() {
		return new Coordinate(0, 10);
	}

	/**
	 * Calculates the coordinate of the top-left point
	 * @return the coordinate of the top-left point
	 */
	public static Coordinate topLeft() {
		return new Coordinate(-Math.sqrt(75), 5);
	}

	/**
	 * Calculates the coordinate of the top-right point
	 * @return the coordinate of the top-right point
	 */
	public static Coordinate topRight() {
		return new Coordinate(Math.sqrt(75), 5);
	}

	/**
	 * Calculates the width of this hexagon.
	 * @return the width of the hexagon
	 */
	public double width() {
		return this.getScaleX() * (this.topRight.x() - this.bottomLeft.x() + this.getStrokeWidth());
	}
}
