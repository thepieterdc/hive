package hive.components;

import hive.JavaFXThreadingRule;
import hive.helpers.BoardState;
import hive.helpers.Move;
import hive.helpers.moves.StartMove;
import hive.models.ViewerModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Tests for hive.components.PlayPane.
 * <p>
 * Created at 28/03/16 13:44.
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class PlayPaneTest {
	@Rule
	public final JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

	private ViewerModel model;
	private List<Move> moves;
	private Map<Integer, BoardState> states;
	private PlayPane pP;

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

		this.pP = new PlayPane(this.model);
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
		this.pP = null;
	}

	/**
	 * Tests PlayPane#toString().
	 */
	@Test
	public void testToString() {
		assertEquals("PlayPane[]", this.pP.toString());
	}

	/**
	 * Tests PlayPane constructor with invalid parameter: model (null).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorModelNull() throws Exception {
		new PlayPane(null);
	}
}