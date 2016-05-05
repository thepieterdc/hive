package hive.components;

import hive.components.viewer.MovesPane;
import hive.models.PlayModel;
import hive.models.ViewerModel;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * HivePane component. Holds the entire UI.
 * <p>
 * Created at 25/03/16 9:03
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class HivePane extends VBox {
	/**
	 * HivePane constructor.
	 *
	 * @param model the PlayModel
	 */
	public HivePane(PlayModel model) {
		if (model == null) {
			throw new IllegalArgumentException("Parameter \"model\" is null.");
		}
		hive.components.play.PlayPane playPane = new hive.components.play.PlayPane(model);
		playPane.setStyle("-fx-background-color: #21252b");

		ScrollPane mainPane = new ScrollPane(playPane);
		mainPane.setFitToHeight(true);
		mainPane.setFitToWidth(true);
		mainPane.setStyle("-fx-padding: 0; -fx-background-insets: 0; -fx-background-color: #21252b");
		VBox.setVgrow(mainPane, Priority.ALWAYS);

		hive.components.play.UnitPane bottomPane = new hive.components.play.UnitPane(model);
		bottomPane.setStyle("-fx-background-color: #21252b");

		this.getChildren().addAll(mainPane, bottomPane);
		this.setMinSize(800.0, 600.0);

		model.move(0);
	}

	/**
	 * HivePane constructor.
	 *
	 * @param model the ViewerModel
	 */
	public HivePane(ViewerModel model) {
		if (model == null) {
			throw new IllegalArgumentException("Parameter \"model\" is null.");
		}
		MovesPane movesPane = new MovesPane(model);
		movesPane.setMaxWidth(1);
		SplitPane.setResizableWithParent(movesPane, Boolean.FALSE);

		ScrollPane playPane = new ScrollPane(new hive.components.viewer.PlayPane(model));
		playPane.setFitToHeight(true);
		playPane.setFitToWidth(true);
		playPane.setStyle("-fx-padding: 0; -fx-background-insets: 0;");
		VBox.setVgrow(playPane, Priority.ALWAYS);

		SplitPane mainPane = new SplitPane(movesPane, playPane);
		VBox.setVgrow(mainPane, Priority.ALWAYS);

		hive.components.viewer.UnitPane bottomPane = new hive.components.viewer.UnitPane(model);

		this.getChildren().addAll(mainPane, bottomPane);
		this.setMinSize(800.0, 600.0);

		model.move(0);
	}

	@Override
	public String toString() {
		return "HivePane[]";
	}
}
