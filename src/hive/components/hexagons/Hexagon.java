package hive.components.hexagons;

import hive.helpers.Coordinate;
import hive.interfaces.Enableable;
import hive.interfaces.Scalable;
import hive.interfaces.Selectable;
import hive.interfaces.Translatable;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;

import java.util.Arrays;

/**
 * A hexagon. It extends Group because this allows putting FreeHexagons and UnitHexagons in the
 * same collection.
 * <p>
 * Created at 22/04/16 9:03
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public abstract class Hexagon extends Group implements Enableable, Scalable, Selectable, Translatable {
	private static final double RADIUS = 10.0;
	private static final double SQRT75 = 8.660254037844387;

	private final Polygon hexagon;

	protected Hexagon() {
		this.hexagon = new Polygon();
		Arrays.asList(top(), topRight(), bottomRight(), bottom(), bottomLeft(), topLeft()).forEach(coordinate -> this.hexagon.getPoints().addAll(coordinate.asList()));
		this.hexagon.setStrokeType(StrokeType.INSIDE);
		this.hexagon.setStrokeWidth(1.0);
		this.getChildren().add(this.hexagon);
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

	public void colour(Color fill, Color stroke) {
		this.hexagon.setFill(fill);
		this.hexagon.setStroke(stroke);
	}

	@Override
	public void enable(boolean b) {
		this.setCursor(b ? Cursor.HAND : Cursor.DEFAULT);
		this.setOpacity(b ? 1 : 0.2);
	}

	@Override
	public final double height() {
		return this.hexagon.getScaleY() * (top().y() - bottom().y());
	}

	@Override
	public void scale(double factor) {
		if (factor <= 0.0) {
			throw new IllegalArgumentException("Parameter \"factor\" is negative or equal to zero.");
		}
		this.hexagon.setScaleX(factor);
		this.hexagon.setScaleY(factor);
	}

	@Override
	public void translate(double x, double y) {
		this.setTranslateX(x);
		this.setTranslateY(y);
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
	public final double width() {
		return this.hexagon.getScaleX() * (topRight().x() - bottomLeft().x());
	}
}