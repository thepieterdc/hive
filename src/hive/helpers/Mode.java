package hive.helpers;

import hive.interfaces.Validatable;
import javafx.stage.Stage;

/**
 * A mode to use the application.
 * <p>
 * Created at 2/04/16 15:15
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public abstract class Mode implements Validatable<Integer> {
	/**
	 * Start this application mode.
	 *
	 * @param s the stage
	 * @param p the passed parameters
	 */
	public abstract void start(Stage s, String... p);
}
