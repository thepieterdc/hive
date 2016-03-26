package be.thepieterdc.hive.components;

import be.thepieterdc.hive.models.ViewerModel;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * Component that holds the entire UI.
 * <p>
 * Created at 25/03/16 9:03
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class HivePane extends VBox {
	public HivePane(ViewerModel model) {
		MovesPane movesPane = new MovesPane(model);
		SplitPane.setResizableWithParent(movesPane, Boolean.FALSE);

		PlayPane playPane = new PlayPane(model);

		SplitPane mainPane = new SplitPane(movesPane, playPane);
		mainPane.setDividerPositions(0.0);
		VBox.setVgrow(mainPane, Priority.ALWAYS);

		UnitPane bottomPane = new UnitPane(model);

		this.getChildren().addAll(mainPane, bottomPane);
		this.setMinSize(800.0, 600.0);
	}

	@Override
	public String toString() {
		return "HivePane[]";
	}
}
