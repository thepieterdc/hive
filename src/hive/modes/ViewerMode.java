package hive.modes;

import hive.Hive;
import hive.components.HivePane;
import hive.helpers.Move;
import hive.helpers.messages.ErrorMessage;
import hive.interfaces.Mode;
import hive.models.ViewerModel;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Opens the application in Viewer(and test)-mode.
 * <p>
 * Created at 2/04/16 15:14
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
@SuppressWarnings("UseOfSystemOutOrSystemErr")
public final class ViewerMode implements Mode {
	@Override
	public void start(Stage s, List<String> p) {
		try {
			List<Move> moves = Files.readAllLines(Paths.get(p.get(0))).stream().filter(b -> !b.toLowerCase().contains("congrat")).map(Move::fromRepresentation).collect(Collectors.toList());

			ViewerModel model = new ViewerModel(moves);

			Scene scene = new Scene(new HivePane(model));

			s.setScene(scene);
			s.setTitle("Hive Viewer" + (p.size() == 2 ? " [" + Hive.BUNDLE.getString("modes_viewer_testmode") + ']' : ""));
			s.show();

			model.move(p.size() == 2 ? model.totalMoves() - 1 : 0);

			if (p.size() == 2) {
				ImageIO.write(SwingFXUtils.fromFXImage(scene.snapshot(null), null), "png", Paths.get(p.get(1), "screenshot.png").toFile());
				System.out.println("[Hive " + Hive.BUNDLE.getString("modes_viewer_testmode") + ']');
				model.boardState().transferPieces().forEach(System.out::println);
				s.close();
			}
		} catch (IOException e) {
			Platform.runLater(() -> new ErrorMessage(e.getMessage() + ' ' + Hive.BUNDLE.getString("modes_viewer_filenotfound")).render());
		} catch (RuntimeException e) {
			Platform.runLater(() -> new ErrorMessage(e.getMessage()).render());
		}
	}

	@Override
	public boolean valid(Integer args) {
		return args != 0;
	}
}