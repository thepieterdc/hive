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
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	// Coordinates.
	private static final Coordinate BOTTOM = new Coordinate(0.0, -RADIUS);
	private static final Coordinate BOTTOM_LEFT = new Coordinate(-SQRT75, -RADIUS / 2.0);
	private static final Coordinate BOTTOM_RIGHT = new Coordinate(SQRT75, -RADIUS / 2.0);
	private static final Coordinate TOP = new Coordinate(0.0, RADIUS);
	private static final Coordinate TOP_LEFT = new Coordinate(-SQRT75, RADIUS / 2.0);
	private static final Coordinate TOP_RIGHT = new Coordinate(SQRT75, RADIUS / 2.0);
	
	private final Polygon hexagon;
	
	/**
	 * Hexagon constructor.
	 */
	protected Hexagon() {
		this.hexagon = new Polygon(
			TOP.x(), TOP.y(),
			TOP_RIGHT.x(), TOP_RIGHT.y(),
			BOTTOM_RIGHT.x(), BOTTOM_RIGHT.y(),
			BOTTOM.x(), BOTTOM.y(),
			BOTTOM_LEFT.x(), BOTTOM_RIGHT.y(),
			TOP_LEFT.x(), TOP_RIGHT.y()
		);
		this.hexagon.setStrokeType(StrokeType.INSIDE);
		this.hexagon.setStrokeWidth(1.0);
		this.getChildren().add(this.hexagon);
	}
	
	/**
	 * Sets the colours of the hexagon.
	 */
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
		return this.hexagon.getScaleY() * (TOP.y() - BOTTOM.y());
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
	
	@Override
	public final double width() {
		return this.hexagon.getScaleX() * (TOP_RIGHT.x() - BOTTOM_LEFT.x());
	}
}