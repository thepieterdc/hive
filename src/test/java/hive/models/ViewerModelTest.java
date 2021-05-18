package hive.models;

import hive.TestListener;
import hive.helpers.Move;
import hive.helpers.Unit;
import hive.helpers.moves.StartMove;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Tests for ViewerModel.
 * <p>
 * Created at 27/03/16 23:28
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class ViewerModelTest {
	private TestListener listener;
	private ViewerModel model;
	private List<Move> moves;

	/**
	 * Set-up the test environment.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.moves = Arrays.asList(new StartMove(), Move.fromRepresentation("wQ"), Move.fromRepresentation("bA1 wQ-"));
		this.model = new ViewerModel(this.moves);
		this.listener = new TestListener(this.model);
	}

	/**
	 * Tests Model#addListener() with invalid parameter: l (null).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddListenerLNull() throws Exception {
		this.model.addListener(null);
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
	}

	/**
	 * Tests ViewerModel#boardState().
	 *
	 * @throws Exception
	 */
	@Test
	public void testBoardState() throws Exception {
		this.model.move(this.moves.get(2));
		assertEquals(this.model.boardStates().get(2), this.model.boardState());
	}

	/**
	 * Tests ViewerModel#move().
	 *
	 * @throws Exception
	 */
	@Test
	public void testMove() throws Exception {
		this.model.move(1);
		assertEquals("wQ", this.model.move().representation());
	}

	/**
	 * Tests ViewerModel#move(int) with invalid parameter: i (too high).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testMoveIInvalid() throws Exception {
		this.model.move(4);
		this.model.move(-1);
	}

	/**
	 * Tests ViewerModel#move(Move) with invalid parameter: m (null).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testMoveMNull() throws Exception {
		this.model.move(null);
	}

	/**
	 * Tests ViewerModel#moveIndex().
	 *
	 * @throws Exception
	 */
	@Test
	public void testMoveIndex() throws Exception {
		this.model.move(this.moves.get(1));
		assertEquals(1, this.model.moveIndex());
	}

	/**
	 * Tests ViewerModel#moves().
	 *
	 * @throws Exception
	 */
	@Test
	public void testMoves() throws Exception {
		assertEquals("Start", this.model.moves().get(0).representation());
		assertEquals("wQ", this.model.moves().get(1).representation());
		assertEquals("bA1 wQ-", this.model.moves().get(2).representation());
	}

	/**
	 * Tests Model#removeListener().
	 *
	 * @throws Exception
	 */
	@Test
	public void testRemoveListener() throws Exception {
		int count = this.listener.called();
		this.model.removeListener(this.listener);
		this.model.move(this.model.moveIndex() + 1);
		assertEquals(count, this.listener.called());
		this.model.addListener(this.listener);
	}

	/**
	 * Tests Model#removeListener() with invalid parameter: l (null).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveListenerLNull() throws Exception {
		this.model.removeListener(null);
	}

	/**
	 * Tests ViewerModel#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		this.model.move(0);
		assertEquals("ViewerModel[boardStates=3, move=Start, moveIndex=0, totalmoves=3]", this.model.toString());
	}

	/**
	 * Tests ViewerModel#totalMoves().
	 *
	 * @throws Exception
	 */
	@Test
	public void testTotalMoves() throws Exception {
		assertEquals(3, this.model.totalMoves());
	}

	/**
	 * Tests ViewerModel#units().
	 *
	 * @throws Exception
	 */
	@Test
	public void testUnits() throws Exception {
		Unit[] units = new Unit[22];
		units[0] = Unit.fromRepresentation("bA1");
		units[1] = Unit.fromRepresentation("bA2");
		units[2] = Unit.fromRepresentation("bA3");
		units[3] = Unit.fromRepresentation("bB1");
		units[4] = Unit.fromRepresentation("bB2");
		units[5] = Unit.fromRepresentation("bG1");
		units[6] = Unit.fromRepresentation("bG2");
		units[7] = Unit.fromRepresentation("bG3");
		units[8] = Unit.fromRepresentation("bQ");
		units[9] = Unit.fromRepresentation("bS1");
		units[10] = Unit.fromRepresentation("bS2");
		units[11] = Unit.fromRepresentation("wA1");
		units[12] = Unit.fromRepresentation("wA2");
		units[13] = Unit.fromRepresentation("wA3");
		units[14] = Unit.fromRepresentation("wB1");
		units[15] = Unit.fromRepresentation("wB2");
		units[16] = Unit.fromRepresentation("wG1");
		units[17] = Unit.fromRepresentation("wG2");
		units[18] = Unit.fromRepresentation("wG3");
		units[19] = Unit.fromRepresentation("wQ");
		units[20] = Unit.fromRepresentation("wS1");
		units[21] = Unit.fromRepresentation("wS2");
		assertArrayEquals(units, this.model.units());
	}

	/**
	 * Tests ViewerModel constructor with invalid parameter: model (null).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorMovesNull() {
		new ViewerModel(null);
	}
}