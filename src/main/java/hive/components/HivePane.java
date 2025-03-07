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
		ScrollPane mainPane = new ScrollPane(new hive.components.play.PlayPane(model));
		mainPane.setFitToHeight(true);
		mainPane.setFitToWidth(true);
		VBox.setVgrow(mainPane, Priority.ALWAYS);

		hive.components.play.UnitPane bottomPane = new hive.components.play.UnitPane(model);

		this.getChildren().addAll(mainPane, bottomPane);
		this.getStyleClass().add("vBox");
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

		ScrollPane playPaneScroll = new ScrollPane(new hive.components.viewer.PlayPane(model));
		playPaneScroll.setFitToHeight(true);
		playPaneScroll.setFitToWidth(true);
		VBox.setVgrow(playPaneScroll, Priority.ALWAYS);

		SplitPane mainPane = new SplitPane(movesPane, playPaneScroll);

		VBox.setVgrow(mainPane, Priority.ALWAYS);

		hive.components.viewer.UnitPane bottomPane = new hive.components.viewer.UnitPane(model);

		this.getChildren().addAll(mainPane, bottomPane);
		this.getStyleClass().add("vBox");
		this.setMinSize(800.0, 600.0);

		model.move(0);
	}

	@Override
	public String toString() {
		return "HivePane[]";
	}
}
