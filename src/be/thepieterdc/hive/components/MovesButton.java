package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.Svg;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Button to navigate through the list of moves.
 * <p>
 * Created at 17/03/16 14:54
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public abstract class MovesButton extends Button implements EventHandler, InvalidationListener {
	private final ViewerModel model;

	/**
	 * MovesButton constructor.
	 * @param m the model
	 * @param lbl the graphical label
	 */
	public MovesButton(ViewerModel m, Svg lbl) {
		this.model = m;
		this.setGraphic(lbl.path());

		this.model.addListener(this);
	}

	@Override
	public void invalidated(Observable observable) {
		System.out.println("lele");
	}
}
