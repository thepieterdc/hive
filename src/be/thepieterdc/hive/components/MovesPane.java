package be.thepieterdc.hive.components;

import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * Panel that contains the list of moves and the button bar to navigate through them.
 * <p>
 * Created at 18/03/16 9:40
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
final class MovesPane extends VBox implements InvalidationListener {
	private final ViewerModel model;

	private final ListView<Move> movesList;

	MovesPane(ViewerModel m) {
		if(m == null) {
			throw new IllegalArgumentException("Parameter \"m\" is null.");
		}
		this.model = m;
		this.model.addListener(this);

		this.movesList = new ListView<>();
		this.movesList.setItems(FXCollections.observableList(this.model.moves()));
		this.movesList.setCellFactory(param -> new ListCell<Move>() {
			@Override
			protected void updateItem(Move t, boolean b) {
				super.updateItem(t, b);
				if (t != null) {
					this.setText(t.representation());
				}
			}
		});
		this.movesList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			model.move(newValue);
		});
		VBox.setVgrow(this.movesList, Priority.ALWAYS);

		MovesButtonBar movesButtonBar = new MovesButtonBar(this.model);

		this.getChildren().addAll(this.movesList, movesButtonBar);
	}

	@Override
	public void invalidated(Observable observable) {
		this.movesList.getSelectionModel().select(this.model.move());
	}

	@Override
	public String toString() {
		return "MovesPane[]";
	}
}
