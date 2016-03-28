package hive.components;

import hive.JavaFXThreadingRule;
import hive.TestListener;
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

import static org.junit.Assert.*;

/**
 * Tests for hive.components.HivePane.
 * <p>
 * Created at 28/03/16 13:17.
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class HivePaneTest {
	@Rule
	public final JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

	private HivePane hP;
	private ViewerModel model;
	private List<Move> moves;
	private Map<Integer, BoardState> states;

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
		this.hP = new HivePane(this.model);
	}

	/**
	 * Tear-down the test environment
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.hP = null;
		this.model = null;
		this.moves = null;
		this.states = null;
	}

	/**
	 * Calls the invalidated() listener on all components.
	 * @throws Exception
	 */
	@Test
	public void testListeners() throws Exception {
		TestListener l = new TestListener(this.model);
		this.model.move(2);
		assertEquals(1, l.called());
	}

	/**
	 * Tests HivePane#toString().
	 */
	@Test
	public void testToString() {
		assertEquals("HivePane[]", this.hP.toString());
	}

	/**
	 * Tests HivePane constructor with invalid parameter: model (null).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorModelNull() throws Exception {
		new HivePane(null);
	}
}