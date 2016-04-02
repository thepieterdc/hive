package hive.interfaces;

import javafx.stage.Stage;

/**
 * A mode to use the application.
 * <p>
 * Created at 2/04/16 15:15
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public interface Mode {
	void start(Stage s, String... parameters);

	boolean valildate(int parameters);
}
