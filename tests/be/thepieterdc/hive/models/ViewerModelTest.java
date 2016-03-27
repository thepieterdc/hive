package be.thepieterdc.hive.models;

import be.thepieterdc.hive.helpers.BoardState;
import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.helpers.moves.StartMove;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Tests for be.thepieterdc.hive.models.ViewerModel.
 * <p>
 * Created at 27/03/16 23:28
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class ViewerModelTest {
	private ViewerModel model;
	private List<Move> moves;
	private HashMap<Integer, BoardState> states;

	/**
	 * Set-up the test environment.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.moves = Arrays.asList(new StartMove(), Move.fromRepresentation("wQ"), Move.fromRepresentation("bA1 wQ-"));
		this.states = BoardState.unmarshal(this.moves);
		this.model = new ViewerModel(this.moves, this.states);
	}

	/**
	 * Tear-down the test environment.
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.model = null;
		this.moves = null;
		this.states = null;
	}

	@Test
	public void testBoardState() throws Exception {

	}

	@Test
	public void testMove() throws Exception {

	}

	@Test
	public void testMoveIndex() throws Exception {

	}

	@Test
	public void testMoves() throws Exception {

	}

	@Test
	public void testToString() throws Exception {

	}

	@Test
	public void testTotalMoves() throws Exception {

	}

	@Test
	public void testUnits() throws Exception {

	}

}