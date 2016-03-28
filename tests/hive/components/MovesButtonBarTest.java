package hive.components;

import hive.JavaFXThreadingRule;
import hive.helpers.BoardState;
import hive.helpers.Move;
import hive.helpers.moves.StartMove;
import hive.models.ViewerModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBase;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Tests for hive.components.MovesButtonBar.
 * <p>
 * Created at 28/03/16 15:19.
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class MovesButtonBarTest {
	@Rule
	public final JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

	private ViewerModel model;
	private List<Move> moves;
	private Map<Integer, BoardState> states;
	private MovesButtonBar mBB;

	/**
	 * Set-up the test environment
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.moves = Arrays.asList(new StartMove(), Move.fromRepresentation("bQ"), Move.fromRepresentation("bA1 -bQ"));
		this.states = BoardState.unmarshal(this.moves);
		this.model = new ViewerModel(this.moves, this.states);

		this.mBB = new MovesButtonBar(this.model);

		Application a = new Application() {
			@Override
			public void start(Stage s) throws Exception {
				Scene sc = new Scene(mBB);
				s.setScene(sc);
				s.show();
			}
		};
		a.start(new Stage());
	}

	/**
	 * Tear-down the test environment
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.model = null;
		this.moves = null;
		this.states = null;
		this.mBB = null;
	}

	/**
	 * Tests the play button.
	 *
	 * @throws Exception
	 */
	@Test
	public void testPlayButton() throws Exception {
		this.model.move(1);
		((ButtonBase) this.mBB.getChildren().get(2)).fire();
		assertTrue(this.mBB.playing());
	}

	/**
	 * Tests MovesButtonBar#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("MovesButtonBar[playing=false]", this.mBB.toString());
	}

	/**
	 * Tests MovesButtonBar constructor with invalid parameter: model (null).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorModelNull() throws Exception {
		new MovesButtonBar(null);
	}
}