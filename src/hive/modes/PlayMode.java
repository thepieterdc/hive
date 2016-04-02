package hive.modes;

import hive.helpers.Mode;
import javafx.stage.Stage;

import java.util.List;

/**
 * Opens the application in Play(game)-mode.
 * <p>
 * Created at 2/04/16 15:44
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class PlayMode extends Mode {
	@Override
	public void start(Stage s, List<String> p) {
		System.out.println("Startmode");
	}

	@Override
	public boolean valid(Integer args) {
		return args == 0;
	}
}
