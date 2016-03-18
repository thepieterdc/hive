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
	}

	/**
	 * Calculates the coordinate of the bottom point.
	 * @return the coordinate of the bottom point
	 */
	public static Coordinate bottom() {
		return new Coordinate(0, -1);
	}

	/**
	 * Calculates the coordinate of the bottom-left point.
	 * @return the coordinate of the bottom-left point
	 */
	public static Coordinate bottomLeft() {
		return new Coordinate(-Math.sqrt(0.75), -0.5);
	}

	/**
	 * Calculates the coordinate of the bottom-right point
	 * @return the coordinate of the bottom-right point
	 */
	public static Coordinate bottomRight() {
		return new Coordinate(Math.sqrt(0.75), -0.5);
	}

	/**
	 * Calculates the coordinate of the top point
	 * @return the coordinate of the top point
	 */
	public static Coordinate top() {
		return new Coordinate(0, 1);
	}

	/**
	 * Calculates the coordinate of the top-left point
	 * @return the coordinate of the top-left point
	 */
	public static Coordinate topLeft() {
		return new Coordinate(-Math.sqrt(0.75), 0.5);
	}

	/**
	 * Calculates the coordinate of the top-right point
	 * @return the coordinate of the top-right point
	 */
	public static Coordinate topRight() {
		return new Coordinate(Math.sqrt(0.75), 0.5);
	}
}
