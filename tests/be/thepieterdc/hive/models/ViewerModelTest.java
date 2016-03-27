package be.thepieterdc.hive.models;

import be.thepieterdc.hive.helpers.BoardState;
import be.thepieterdc.hive.helpers.Move;
import be.thepieterdc.hive.helpers.Unit;
import be.thepieterdc.hive.helpers.moves.StartMove;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Tests for be.thepieterdc.hive.models.ViewerModel.
 * <p>
 * Created at 27/03/16 23:28
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class ViewerModelTest {
	private ViewerModelTest.TestListener listener;
	private ViewerModel model;
	private List<Move> moves;
	private HashMap<Integer, BoardState> states;

	/**
	 * TestListener class.
	 */
	private static class TestListener implements InvalidationListener {
		private int called;

		/**
		 * TestListener constructor.
		 *
		 * @param m the model
		 */
		public TestListener(Observable m) {
			m.addListener(this);
		}

		/**
		 * @return the amount of times that the invalidated() was called.
		 */
		public int called() {
			return this.called;
		}

		@Override
		public void invalidated(Observable observable) {
			this.called++;
		}
	}

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
		this.listener = new ViewerModelTest.TestListener(this.model);
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

	/**
	 * Tests Model#removeListener().
	 *
	 * @throws Exception
	 */
	@Test
	public void testRemoveListener() throws Exception {
		int count = this.listener.called();
		this.model.removeListener(this.listener);
		this.model.move(this.model.moveIndex()+1);
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

	@Test
	public void testToString() throws Exception {

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

}