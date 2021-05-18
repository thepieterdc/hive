package hive.helpers;

import hive.data.Orientation;
import hive.data.Players;
import hive.data.UnitType;
import hive.helpers.pathfinding.pathfinders.GrasshopperPathFinder;
import hive.helpers.pathfinding.pathfinders.QueenBeetlePathFinder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for hive.helpers.Unit.
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
		this.bQ = new Unit(Players.BLACK.player(), UnitType.QUEEN, 1);
		this.wG2 = new Unit(Players.WHITE.player(), UnitType.GRASSHOPPER, 2);
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
		assertEquals(this.bQ, new Unit(Players.BLACK.player(), UnitType.QUEEN, 1));
		assertEquals(this.wG2, new Unit(Players.WHITE.player(), UnitType.GRASSHOPPER, 2));
	}

	/**
	 * Tests Unit#fromRepresentation().
	 *
	 * @throws Exception
	 */
	@Test
	public void testFromRepresentation() throws Exception {
		assertEquals(this.bQ, Unit.fromRepresentation("bQ"));
		assertEquals(this.wG2, Unit.fromRepresentation("wG2"));
	}

	/**
	 * Tests Unit#fromRepresentation() with invalid parameter: r (null).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFromRepresentationRNull() throws Exception {
		Unit.fromRepresentation(null);
	}

	/**
	 * Tests Unit#hashCode().
	 *
	 * @throws Exception
	 */
	@Test
	public void testHashCode() throws Exception {
		assertEquals(this.bQ.player().hashCode() + 1 + this.bQ.type().hashCode(), this.bQ.hashCode());
		assertEquals(this.wG2.player().hashCode() + 2 + this.wG2.type().hashCode(), this.wG2.hashCode());
	}

	/**
	 * Tests Unit#location().
	 *
	 * @throws Exception
	 */
	@Test
	public void testLocation() throws Exception {
		HexCoordinate origin = new HexCoordinate(0, 0);
		HexCoordinate leftUpper = HexCoordinate.fromOrientation(origin, Orientation.LEFTUPPER);
		this.bQ.location(leftUpper);
		assertEquals(leftUpper, this.bQ.location());
		this.bQ.location(origin);
	}

	/**
	 * Tests Unit#pathFinder().
	 *
	 * @throws Exception
	 */
	@Test
	public void testPathFinder() throws Exception {
		assertTrue(this.bQ.pathFinder().get() instanceof QueenBeetlePathFinder);
		assertTrue(this.wG2.pathFinder().get() instanceof GrasshopperPathFinder);
	}

	/**
	 * Tests Unit#player().
	 *
	 * @throws Exception
	 */
	@Test
	public void testPlayer() throws Exception {
		assertEquals(Players.BLACK.player(), this.bQ.player());
		assertEquals(Players.WHITE.player(), this.wG2.player());
	}

	/**
	 * Tests Unit#rank().
	 *
	 * @throws Exception
	 */
	@Test
	public void testRank() throws Exception {
		assertEquals(1, this.bQ.rank());
		assertEquals(2, this.wG2.rank());
	}

	/**
	 * Tests Unit#representation().
	 *
	 * @throws Exception
	 */
	@Test
	public void testRepresentation() throws Exception {
		assertEquals("bQ", this.bQ.representation());
		assertEquals("wG2", this.wG2.representation());
	}

	/**
	 * Tests Unit#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("Unit[player=Player[color=0x001432ff, id=b, name=b], type=Queen, rank=1, representation=bQ]", this.bQ.toString());
		assertEquals("Unit[player=Player[color=0xffebcdff, id=w, name=w], type=Grasshopper, rank=2, representation=wG2]", this.wG2.toString());
	}

	/**
	 * Tests Unit#type().
	 *
	 * @throws Exception
	 */
	@Test
	public void testType() throws Exception {
		assertEquals(UnitType.QUEEN, this.bQ.type());
		assertEquals(UnitType.GRASSHOPPER, this.wG2.type());
	}

	/**
	 * Tests Unit constructor with invalid parameter: p (null).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorPNull() throws Exception {
		new Unit(null, UnitType.ANT, 0);
	}

	/**
	 * Tests Unit constructor with invalid parameter: t (null).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorTNull() throws Exception {
		new Unit(Players.BLACK.player(), null, 0);
	}

	/**
	 * Tests Unit constructor with invalid parameter: r (<0).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorRNegative() throws Exception {
		new Unit(Players.BLACK.player(), UnitType.ANT, -5000);
	}
}