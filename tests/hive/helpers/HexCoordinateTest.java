package hive.helpers;

import hive.data.Orientation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Tests for hive.helpers.HexCoordinate.
 * <p>
 * Created at 27/03/16 11:16
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class HexCoordinateTest {
	private HexCoordinate origin;
	private HexCoordinate leftMiddle;
	private HexCoordinate leftUpper;
	private HexCoordinate leftUnder;
	private HexCoordinate rightMiddle;
	private HexCoordinate rightUpper;
	private HexCoordinate rightUnder;

	/**
	 * Set-up the test environment.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.origin = new HexCoordinate(0, 0);
		this.leftMiddle = new HexCoordinate(0, -1);
		this.leftUpper = new HexCoordinate(-1, 0);
		this.leftUnder = new HexCoordinate(1, -1);
		this.rightMiddle = new HexCoordinate(0, 1);
		this.rightUpper = new HexCoordinate(-1, 1);
		this.rightUnder = new HexCoordinate(1, 0);
	}

	/**
	 * Tear-down the test environment.
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.origin = null;
		this.leftMiddle = null;
		this.leftUpper = null;
		this.leftUnder = null;
		this.rightMiddle = null;
		this.rightUpper = null;
		this.rightUnder = null;
	}

	/**
	 * Tests HexCoordinate#column().
	 *
	 * @throws Exception
	 */
	@Test
	public void testColumn() throws Exception {
		assertEquals(0, this.origin.column());
		assertEquals(-1, this.leftMiddle.column());
		assertEquals(0, this.leftUpper.column());
		assertEquals(-1, this.leftUnder.column());
		assertEquals(1, this.rightMiddle.column());
		assertEquals(1, this.rightUpper.column());
		assertEquals(0, this.rightUnder.column());
	}

	/**
	 * Tests HexCoordinate.distance() and HexCoordinate#distanceTo().
	 *
	 * @throws Exception
	 */
	@Test
	public void testDistanceAndDistanceTo() throws Exception {
		EnumSet.allOf(Orientation.class).forEach(o -> assertEquals(1, this.origin.distanceTo(HexCoordinate.fromOrientation(this.origin, o))));
	}

	/**
	 * Tests HexCoordinate#fromOrientation().
	 *
	 * @throws Exception
	 */
	@Test
	public void testFromOrientation() throws Exception {
		assertEquals(this.leftMiddle, HexCoordinate.fromOrientation(this.origin, Orientation.LEFTMIDDLE));
		assertEquals(this.leftUpper, HexCoordinate.fromOrientation(this.origin, Orientation.LEFTUPPER));
		assertEquals(this.leftUnder, HexCoordinate.fromOrientation(this.origin, Orientation.LEFTUNDER));
		assertEquals(this.rightMiddle, HexCoordinate.fromOrientation(this.origin, Orientation.RIGHTMIDDLE));
		assertEquals(this.rightUpper, HexCoordinate.fromOrientation(this.origin, Orientation.RIGHTUPPER));
		assertEquals(this.rightUnder, HexCoordinate.fromOrientation(this.origin, Orientation.RIGHTUNDER));
	}

	/**
	 * Tests HexCoordinate#fromOrientation() with invalid parameter: base (null).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFromOrientationBaseNull() throws Exception {
		HexCoordinate.fromOrientation(null, Orientation.LEFTMIDDLE);
	}

	/**
	 * Tests HexCoordinate#fromOrientation() with invalid parameter: o (null).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFromOrientationONull() throws Exception {
		HexCoordinate.fromOrientation(this.origin, null);
	}

	/**
	 * Tests HexCoordinate#equals().
	 *
	 * @throws Exception
	 */
	@Test
	public void testEquals() throws Exception {
		assertEquals(this.origin, new HexCoordinate(0, 0));
		assertEquals(this.leftMiddle, new HexCoordinate(0, -1));
		assertEquals(this.leftUpper, new HexCoordinate(-1, 0));
		assertEquals(this.leftUnder, new HexCoordinate(1, -1));
		assertEquals(this.rightMiddle, new HexCoordinate(0, 1));
		assertEquals(this.rightUpper, new HexCoordinate(-1, 1));
		assertEquals(this.rightUnder, new HexCoordinate(1, 0));
	}

	/**
	 * Tests HexCoordinate#hashCode().
	 *
	 * @throws Exception
	 */
	@Test
	public void testHashCode() throws Exception {
		assertEquals(0, this.origin.hashCode());
		assertEquals(-1, this.leftMiddle.hashCode());
		assertEquals(-100, this.leftUpper.hashCode());
		assertEquals(99, this.leftUnder.hashCode());
		assertEquals(1, this.rightMiddle.hashCode());
		assertEquals(-99, this.rightUpper.hashCode());
		assertEquals(100, this.rightUnder.hashCode());
	}


	/**
	 * Tests HexCoordinate#representation().
	 *
	 * @throws Exception
	 */
	@Test
	public void testRepresentation() throws Exception {
		assertEquals("[0, 0]", this.origin.representation());
	}

	/**
	 * Tests HexCoordinate#row().
	 *
	 * @throws Exception
	 */
	@Test
	public void testRow() throws Exception {
		assertEquals(0, this.origin.row());
		assertEquals(0, this.leftMiddle.row());
		assertEquals(-1, this.leftUpper.row());
		assertEquals(1, this.leftUnder.row());
		assertEquals(0, this.rightMiddle.row());
		assertEquals(-1, this.rightUpper.row());
		assertEquals(1, this.rightUnder.row());
	}

	/**
	 * Tests HexCoordinate#surroundings() and HexCoordinate.surroundings().
	 *
	 * @throws Exception
	 */
	@Test
	public void testSurroundings() throws Exception {
		Set<HexCoordinate> surrounds = this.origin.surroundings();
		assertTrue(surrounds.contains(this.leftUpper));
		assertTrue(surrounds.contains(this.leftUnder));
		assertTrue(surrounds.contains(this.leftMiddle));
		assertTrue(surrounds.contains(this.rightUnder));
		assertTrue(surrounds.contains(this.rightUpper));
		assertTrue(surrounds.contains(this.rightMiddle));
		assertFalse(surrounds.contains(this.origin));
	}

	/**
	 * Tests HexCoordinate#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("HexCoordinate[column=0, row=0]", this.origin.toString());
		assertEquals("HexCoordinate[column=-1, row=0]", this.leftMiddle.toString());
		assertEquals("HexCoordinate[column=0, row=-1]", this.leftUpper.toString());
		assertEquals("HexCoordinate[column=-1, row=1]", this.leftUnder.toString());
		assertEquals("HexCoordinate[column=1, row=0]", this.rightMiddle.toString());
		assertEquals("HexCoordinate[column=1, row=-1]", this.rightUpper.toString());
		assertEquals("HexCoordinate[column=0, row=1]", this.rightUnder.toString());
	}

	/**
	 * Tests HexCoordinate#x().
	 *
	 * @throws Exception
	 */
	@Test
	public void testX() throws Exception {
		assertEquals(0, this.origin.x(), 0);
		assertEquals(-19.0, this.leftMiddle.x(), 1);
		assertEquals(-9.5, this.leftUpper.x(), 1);
		assertEquals(-9.5, this.leftUnder.x(), 1);
		assertEquals(19.0, this.rightMiddle.x(), 1);
		assertEquals(9.5, this.rightUpper.x(), 1);
		assertEquals(9.5, this.rightUnder.x(), 1);
	}

	/**
	 * HexCoordinate#y().
	 *
	 * @throws Exception
	 */
	@Test
	public void testY() throws Exception {
		assertEquals(0.0, this.origin.y(), 0);
		assertEquals(0.0, this.leftMiddle.y(), 0);
		assertEquals(-16.5, this.leftUpper.y(), 1);
		assertEquals(16.5, this.leftUnder.y(), 1);
		assertEquals(0.0, this.rightMiddle.y(), 0);
		assertEquals(-16.5, this.rightUpper.y(), 1);
		assertEquals(16.5, this.rightUnder.y(), 1);
	}
}