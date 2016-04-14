package hive.modes;

import hive.components.HivePane;
import hive.interfaces.Mode;
import hive.models.PlayModel;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

/**
 * Opens the application in Play(game)-mode.
 * <p>
 * Created at 2/04/16 15:44
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class PlayMode implements Mode {
	@Override
	public void start(Stage s, List<String> p) {
		/*
		Button b = new Button("Lokale multiplayer");
		b.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//TODO ASK INPUT//
				s.close();
				Stage playStage = new Stage();
				playStage.setScene(new Scene(new HivePane(new PlayModel("Pieter","Tobiah"))));
			}
		});
		s.initStyle(StageStyle.UNDECORATED);
		s.setScene(new Scene(new VBox(b), 200, 200));
		s.show();
		*/
		s.setScene(new Scene(new HivePane(new PlayModel("Pieter","Tobiah"))));
		s.show();
	}

	@Override
	public boolean valid(Integer args) {
		return args == 0;
	}
}
