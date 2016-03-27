package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.Player;
import be.thepieterdc.hive.data.UnitType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for be.thepieterdc.helpers.Unit.
 * <p>
 * Created at 27/03/16 12:08
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnitTest {
	private Unit bQ;
	private Unit wG2;

	/**
	 * Set-up the test environment.
	 */
	@Before
	public void setUp() {
		this.bQ = new Unit(Player.ONE, UnitType.QUEEN, 1);
		this.wG2 = new Unit(Player.TWO, UnitType.GRASSHOPPER, 2);
	}

	/**
	 * Tear-down the test environment.
	 */
	@After
	public void tearDown() {
		this.bQ = null;
		this.wG2 = null;
	}

	/**
	 * Tests Unit#equals().
	 *
	 * @throws Exception
	 */
	@Test
	public void testEquals() throws Exception {
		assertEquals(this.bQ, new Unit(Player.ONE, UnitType.QUEEN, 1));
		assertEquals(this.wG2, new Unit(Player.TWO, UnitType.GRASSHOPPER, 2));
	}

	@Test
	public void testFromRepresentation() throws Exception {

	}

	/**
	 * Tests Unit#hashCode().
	 *
	 * @throws Exception
	 */
	@Test
	public void testHashCode() throws Exception {
		assertEquals(1412790638, this.bQ.hashCode());
		assertEquals(-1573457426, this.wG2.hashCode());
	}

	/**
	 * Tests Unit#player().
	 *
	 * @throws Exception
	 */
	@Test
	public void testPlayer() throws Exception {
		assertEquals(Player.ONE, this.bQ.player());
		assertEquals(Player.TWO, this.wG2.player());
	}

	@Test
	public void testRank() throws Exception {

	}

	@Test
	public void testRepresentation() throws Exception {

	}

	@Test
	public void testToString() throws Exception {

	}

	@Test
	public void testType() throws Exception {

	}

}