package hive.modes;

import hive.helpers.Mode;
import javafx.stage.Stage;

import java.util.List;

/**
 * Opens the application in Viewer-mode.
 * <p>
 * Created at 2/04/16 15:14
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class ViewerMode extends Mode {
	@Override
	public void start(Stage s, List<String> p) throws Exception {
		System.out.println("Viewermode");
	}

	@Override
	public boolean valid(Integer args) {
		return args == 1;
	}
}