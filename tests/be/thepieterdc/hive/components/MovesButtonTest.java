package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.Svg;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

/**
 * Test for the MovesButtonBar component.
 * <p>
 * Created at 17/03/16 17:29
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class MovesButtonTest extends ComponentTest {
	@Override
	protected Parent component() {
		MovesButton svgButton = new MovesButton(Svg.UNIT_GRASSHOPPER);
		svgButton.setOnAction(event -> System.out.println("Svg test"));
		MovesButton textButton = new MovesButton("Test");
		textButton.setOnAction(event -> System.out.println("Text test"));

		return new VBox(svgButton, textButton);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
