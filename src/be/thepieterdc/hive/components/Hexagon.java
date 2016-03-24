package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.Coordinate;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;

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

	public Hexagon() {
		this.bottom = bottom();
		this.bottomLeft = bottomLeft();
		this.top = top();
		this.topRight = topRight();

		this.setStrokeType(StrokeType.INSIDE);
		this.setStrokeWidth(1);

		this.getPoints().addAll(this.top.asList());
		this.getPoints().addAll(this.topRight.asList());
		this.getPoints().addAll(bottomRight().asList());
		this.getPoints().addAll(this.bottom.asList());
		this.getPoints().addAll(this.bottomLeft.asList());
		this.getPoints().addAll(topLeft().asList());
	}

	public static Coordinate bottom() {
		return new Coordinate(0, -10);
	}

	public static Coordinate bottomLeft() {
		return new Coordinate(-Math.sqrt(75), -5);
	}

	public static Coordinate bottomRight() {
		return new Coordinate(Math.sqrt(75), -5);
	}

	public double height() {
		return this.getScaleX() * (this.top.y() - this.bottom.y() + this.getStrokeWidth());
	}

	public static Coordinate top() {
		return new Coordinate(0, 10);
	}

	public static Coordinate topLeft() {
		return new Coordinate(-Math.sqrt(75), 5);
	}

	public static Coordinate topRight() {
		return new Coordinate(Math.sqrt(75), 5);
	}

	public double width() {
		return this.getScaleX() * (this.topRight.x() - this.bottomLeft.x() + this.getStrokeWidth());
	}
}
