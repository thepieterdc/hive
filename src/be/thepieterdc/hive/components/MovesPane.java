package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

/**
 * Panel that contains the list of moves and the button bar to navigate through them.
 * <p>
 * Created at 18/03/16 9:40
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class MovesPane extends VBox implements InvalidationListener {
	private final ViewerModel model;

	private final ListView<Move> movesList;

	/**
	 * MovesPane constructor.
	 * @param m the model
	 */
	public MovesPane(ViewerModel m) {
		this.model = m;
		this.model.addListener(this);

		this.movesList = new ListView<>();
		this.movesList.setItems(FXCollections.observableList(this.model.moves()));

		MovesButtonBar movesButtonBar = new MovesButtonBar(this.model);

		this.getChildren().addAll(this.movesList, movesButtonBar);
	}

	@Override
	public void invalidated(Observable observable) {
		this.movesList.getSelectionModel().select(this.model.move());
	}
}
