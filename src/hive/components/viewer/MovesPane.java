package hive.components.viewer;

import hive.helpers.Move;
import hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.scene.Cursor;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * MovesPane component - contains a list of moves and a MovesButtonBar to navigate through those moves.
 * <p>
 * Created at 18/03/16 9:40
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class MovesPane extends VBox implements InvalidationListener {
	private final ViewerModel model;

	private final ListView<Move> movesList;

	/**
	 * MovesPane constructor.
	 *
	 * @param m the model
	 */
	public MovesPane(ViewerModel m) {
		if (m == null) {
			throw new IllegalArgumentException("Parameter \"m\" is null.");
		}
		this.model = m;
		this.model.addListener(this);

		this.movesList = new ListView<>();
		this.movesList.getSelectionModel().selectedItemProperty().addListener((o, od, nw) -> {
			this.model.move(nw);
		});
		this.movesList.setCellFactory(p -> new ListCell<Move>() {
			@Override
			protected void updateItem(Move t, boolean b) {
				super.updateItem(t, b);
				if (t != null) {
					this.setText(t.representation());
				}
			}
		});

		this.movesList.setCursor(Cursor.HAND);
		this.movesList.setItems(FXCollections.observableList(this.model.moves()));
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
		return "MovesPane[moves=" + this.movesList.getItems().size() + ']';
	}
}
