package hive.components.viewer;

import hive.data.Svg;
import javafx.scene.control.Button;

/**
 * MovesButton component. Can be used to navigate through the list of moves.
 * <p>
 * Created at 17/03/16 14:54
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class MovesButton extends Button {
	/**
	 * MovesButton constructor.
	 *
	 * @param lbl the svg path to show as button label
	 */
	public MovesButton(Svg lbl) {
		if (lbl == null) {
			throw new IllegalArgumentException("Parameter \"lbl\" is null.");
		}
		this.setGraphic(lbl.path());
	}

	@Override
	public String toString() {
		return "MovesButton[text=" + this.getText() + ']';
	}
}
