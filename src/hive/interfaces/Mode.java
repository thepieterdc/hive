package hive.interfaces;

import javafx.stage.Stage;

import java.util.List;

/**
 * A mode to use the application.
 * <p>
 * Created at 2/04/16 15:15
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public interface Mode extends Validatable<Integer> {
	/**
	 * Start this application mode.
	 *
	 * @param s the stage
	 * @param p the passed parameters
	 */
	void start(Stage s, List<String> p);
}
