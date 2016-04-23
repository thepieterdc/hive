package hive.helpers;

import hive.data.Orientation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumSet;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Tests for hive.helpers.HexCoordinate.
 * <p>
 * Created at 23/04/16 17:40
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class HexCoordinateTest {
	private HexCoordinate center;
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
		this.center = new HexCoordinate(0, 0);
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
		this.center = null;
		this.leftMiddle = null;
		this.leftUpper = null;
		this.leftUnder = null;
		this.rightMiddle = null;
		this.rightUpper = null;
		this.rightUnder = null;
	}

	/**
	 * Tests HexCoordinate#colinear().
	 *
	 * @throws Exception
	 */
	@Test
	public void testColinear() throws Exception {
		assertTrue(HexCoordinate.colinear(this.leftUpper, this.rightUpper));
		assertTrue(HexCoordinate.colinear(this.leftMiddle, this.rightMiddle));
		assertTrue(HexCoordinate.colinear(this.leftUnder, this.rightUnder));
		assertTrue(HexCoordinate.colinear(this.leftMiddle, this.leftUnder));
		assertTrue(HexCoordinate.colinear(this.leftUpper, this.center));
	}

	/**
	 * Tests HexCoordinate#column().
	 *
	 * @throws Exception
	 */
	@Test
	public void testColumn() throws Exception {
		assertEquals(0, this.center.column());
		assertEquals(-1, this.leftMiddle.column());
		assertEquals(0, this.leftUpper.column());
		assertEquals(-1, this.leftUnder.column());
		assertEquals(1, this.rightMiddle.column());
		assertEquals(1, this.rightUpper.column());
		assertEquals(0, this.rightUnder.column());
	}

	/**
	 * Tests HexCoordinate#distance().
	 *
	 * @throws Exception
	 */
	@Test
	public void testDistance() throws Exception {
		EnumSet.allOf(Orientation.class).forEach(o -> assertEquals(1,HexCoordinate.distance(this.center, HexCoordinate.fromOrientation(this.center, o)), "Distance should be 1 for base="+this.center+", target="+HexCoordinate.fromOrientation(this.center, o)+ '.'));
	}

	/**
	 * Tests HexCoordinate#row().
	 *
	 * @throws Exception
	 */
	@Test
	public void testRow() throws Exception {
		assertEquals(0, this.center.row());
		assertEquals(0, this.leftMiddle.row());
		assertEquals(-1, this.leftUpper.row());
		assertEquals(1, this.leftUnder.row());
		assertEquals(0, this.rightMiddle.row());
		assertEquals(-1, this.rightUpper.row());
		assertEquals(1, this.rightUnder.row());
	}
}