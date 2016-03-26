package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.Svg;
import javafx.scene.control.Button;

/**
 * Button to navigate through the list of moves.
 * <p>
 * Created at 17/03/16 14:54
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class MovesButton extends Button {
	public MovesButton(String lbl) {
		this.setText(lbl);
	}

	public MovesButton(Svg lbl) {
		this.setGraphic(lbl.path());
	}

	@Override
	public String toString() {
		return "MovesButton[text="+this.getText()+"]";
	}
}
