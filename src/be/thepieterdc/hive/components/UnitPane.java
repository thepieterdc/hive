package be.thepieterdc.hive.components;

import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.GridPane;

/**
 * Grid that holds all playable units.
 * <p>
 * Created at 19/03/16 9:28
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnitPane extends GridPane implements InvalidationListener {
	private final ViewerModel model;

	/**
	 * UnitPane constructor.
	 * @param m
	 */
	public UnitPane(ViewerModel m) {
		this.model = m;
		this.model.addListener(this);
	}

	@Override
	public void invalidated(Observable observable) {
		System.out.println("TODO: Remove from grid");
	}
}
