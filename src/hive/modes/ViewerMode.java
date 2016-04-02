package hive.modes;

import hive.components.HivePane;
import hive.exceptions.UnmarshalException;
import hive.helpers.BoardState;
import hive.helpers.Mode;
import hive.helpers.Move;
import hive.helpers.messages.ErrorMessage;
import hive.models.ViewerModel;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static hive.Hive.BUNDLE;

/**
 * Opens the application in Viewer-mode.
 * <p>
 * Created at 2/04/16 15:14
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class ViewerMode extends Mode {
	@Override
	public void start(Stage s, List<String> p) {
		try {
			List<Move> moves = Files.readAllLines(Paths.get(p.get(0))).stream().map(Move::fromRepresentation).collect(Collectors.toList());

			ViewerModel model = new ViewerModel(moves, BoardState.unmarshal(moves));

			Scene scene = new Scene(new HivePane(model));

			s.setScene(scene);
			s.setTitle("Hive Viewer");
			s.show();

			model.move(0);
		} catch (IOException e) {
			Platform.runLater(() -> new ErrorMessage(e.getMessage() + ' ' + BUNDLE.getString("main_filenotfound")).render());
		} catch (UnmarshalException | RuntimeException e) {
			Platform.runLater(() -> new ErrorMessage(e.getMessage()).render());
		}
	}

	@Override
	public boolean valid(Integer args) {
		return args == 1;
	}
}