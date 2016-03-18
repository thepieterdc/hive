package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.UnitType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
	 * @param unit the unit type
	 * @param color the unit color
	 */
	public UnitHexagon(UnitType unit, Color color) {
		this.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

		Hexagon hexagon = new Hexagon();
		hexagon.setFill(color.invert());
		hexagon.setStroke(color);
		hexagon.setScaleX(15);
		hexagon.setScaleY(15);

		Text text = new Text(unit.abbreviation());
		text.setFont(new Font(200));
		text.setFill(color);

		this.getChildren().addAll(hexagon, text);
		this.setOnMouseClicked(event -> hexagon.setStrokeWidth(hexagon.getStrokeWidth()+1));
	}
}
