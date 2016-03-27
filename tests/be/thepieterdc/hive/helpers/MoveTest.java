package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.Orientation;
import be.thepieterdc.hive.data.Player;
import be.thepieterdc.hive.data.UnitType;
import be.thepieterdc.hive.exceptions.MalformedMoveException;
import be.thepieterdc.hive.helpers.moves.FirstMove;
import be.thepieterdc.hive.helpers.moves.StartMove;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for be.thepieterdc.helpers.Move.
 * <p>
 * Created at 27/03/16 21:40
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class MoveTest {
	private FirstMove first;
	private Move move;
	private StartMove start;

	/**
	 * Set-up the test environment.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.first = new FirstMove(new Unit(Player.ONE, UnitType.QUEEN, 1));
		this.move = new Move(new Unit(Player.ONE, UnitType.ANT, 1), new Unit(Player.TWO, UnitType.QUEEN, 1), Orientation.LEFTMIDDLE);
		this.start = new StartMove();
	}

	/**
	 * Tear-down the test environment.
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.first = null;
		this.move = null;
		this.start = null;
	}

	/**
	 * Tests Move#fromRepresentation().
	 *
	 * @throws Exception
	 */
	@Test
	public void testFromRepresentation() throws Exception {
		//Do not compare object references//
		assertEquals(this.first.representation(), Move.fromRepresentation("bQ").representation());
		assertEquals(this.move.representation(), Move.fromRepresentation("bA1 -wQ").representation());
		assertEquals(this.start.representation(), Move.fromRepresentation("Start").representation());
	}

	/**
	 * Tests Move#fromRepresentation() with invalid parameter: r (null).
	 *
	 * @throws Exception
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testFromRepresentationRNull() throws Exception {
		Move.fromRepresentation(null);
	}

	/**
	 * Tests Move#fromRepresentation() with invalid parameter: invalid move.
	 *
	 * @throws Exception
	 */
	@Test(expected= MalformedMoveException.class)
	public void testFromRepresentationInvalidMove() throws Exception {
		Move.fromRepresentation("aZ5 6q@");
	}

	/**
	 * Tests Move#orientation().
	 *
	 * @throws Exception
	 */
	@Test
	public void testOrientation() throws Exception {
		assertNull(this.first.orientation());
		assertEquals(Orientation.LEFTMIDDLE, this.move.orientation());
		assertNull(this.start.orientation());
	}

	/**
	 * Tests Move#otherUnit().
	 *
	 * @throws Exception
	 */
	@Test
	public void testOtherUnit() throws Exception {
		assertNull(this.first.otherUnit());
		assertEquals(new Unit(Player.TWO, UnitType.QUEEN, 1), this.move.otherUnit());
		assertNull(this.start.otherUnit());
	}

	/**
	 * Tests Move#representation().
	 *
	 * @throws Exception
	 */
	@Test
	public void testRepresentation() throws Exception {
		assertEquals("bQ", this.first.representation());
		assertEquals("bA1 -wQ", this.move.representation());
		assertEquals("Start", this.start.representation());
	}

	/**
	 * Tests Move#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("FirstMove[Unit=bQ]", this.first.toString());
		assertEquals("Move[orientation=Left-, otherUnit=wQ, representation=bA1 -wQ, unit=bA1]", this.move.toString());
		assertEquals("StartMove[]", this.start.toString());
	}

	/**
	 * Tests Move#unit().
	 *
	 * @throws Exception
	 */
	@Test
	public void testUnit() throws Exception {
		assertEquals(new Unit(Player.ONE, UnitType.QUEEN, 1), this.first.unit());
		assertEquals(new Unit(Player.ONE, UnitType.ANT, 1), this.move.unit());
		assertNull(this.start.unit());
	}

}