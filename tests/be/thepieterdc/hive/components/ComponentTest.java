package be.thepieterdc.hive.components;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Test a component.
 * <p>
 * Created at 15/03/16 12:11
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
abstract class ComponentTest extends Application {
	@Override
	public void start(Stage s) throws Exception {
		Scene scene = new Scene(component());
		s.setScene(scene);
		s.show();
	}

	abstract protected Parent component();
}