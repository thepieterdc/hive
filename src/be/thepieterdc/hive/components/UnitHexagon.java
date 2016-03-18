package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.UnitType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
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
		Hexagon hexagon = new Hexagon();
		hexagon.setFill(Color.WHITE);
		hexagon.setStroke(Color.BLACK);
		hexagon.setScaleX(15);
		hexagon.setScaleY(15);

		Text text = new Text("A");
		text.setStrokeType(StrokeType.OUTSIDE);
		text.setStrokeWidth(0);
		text.setFont(new Font(200));

		this.setMaxHeight(Integer.MAX_VALUE);
		this.setMaxWidth(Integer.MAX_VALUE);

		this.getChildren().addAll(hexagon, text);
	}
}
