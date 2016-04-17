package hive.components;

import hive.components.viewer.MovesPane;
import hive.models.HiveModel;
import hive.models.PlayModel;
import hive.models.ViewerModel;
import javafx.scene.Parent;
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
	public HivePane(PlayModel model) {
		if (model == null) {
			throw new IllegalArgumentException("Parameter \"model\" is null.");
		}
		this.hivePaneCommon(model, new hive.components.play.PlayPane(model));
	}

	public HivePane(ViewerModel model) {
		MovesPane movesPane = new MovesPane(model);
		SplitPane.setResizableWithParent(movesPane, Boolean.FALSE);

		this.hivePaneCommon(model, new SplitPane(movesPane, new hive.components.viewer.PlayPane(model)));
	}

	private void hivePaneCommon(HiveModel model, Parent mainPane) {
		if (model == null) {
			throw new IllegalArgumentException("Parameter \"model\" is null.");
		} else if (mainPane == null) {
			throw new IllegalArgumentException("Parameter \"mainPane\" is null.");
		}
		VBox.setVgrow(mainPane, Priority.ALWAYS);

		UnitPane bottomPane = new UnitPane(model);

		this.getChildren().addAll(mainPane, bottomPane);
		this.setMinSize(800.0, 600.0);

		model.move(0);
	}

	@Override
	public String toString() {
		return "HivePane[]";
	}
}
