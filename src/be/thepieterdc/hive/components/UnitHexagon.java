package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.UnitType;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * UnitHexagon component.
 * <p>
 * Created at 18/03/16 20:10
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnitHexagon extends StackPane {

	/**
	 * UnitHexagon constructor.
	 */
	public UnitHexagon(UnitType unit, Color color) {
		Circle c = new Circle(20);
		c.setFill(Color.WHITE);
		c.setStroke(Color.BLACK);
		c.setStrokeWidth(1);
		Text t = new Text("A");

		Group g = new Group(c, t);
		g.setAutoSizeChildren(true);

		this.getChildren().add(g);
		this.setOnScroll(event -> {
			event.consume();

			if(event.getDeltaY() == 0) {
				return;
			}

			double scaleFactor = (event.getDeltaY() > 0) ? 1.1 : 1/1.1;

			g.setScaleX(g.getScaleX() * scaleFactor);
			g.setScaleY(g.getScaleY() * scaleFactor);
		});
	}
}
