package be.thepieterdc.hive.components;

import be.thepieterdc.hive.models.ViewerModel;
import javafx.scene.control.SplitPane;
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

		PlayPane playPane = new PlayPane(model);

		SplitPane mainPane = new SplitPane(movesPane, playPane);
		mainPane.setDividerPositions(0.0);

		UnitPane bottomPane = new UnitPane(model);

		this.setPrefSize(800, 500);

		this.getChildren().addAll(mainPane, bottomPane);
	}
}
