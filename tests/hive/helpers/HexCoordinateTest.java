package hive.helpers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests for hive.helpers.HexCoordinate.
 * <p>
 * Created at 23/04/16 17:40
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class HexCoordinateTest {
	private HexCoordinate center;

	/**
	 * Set-up the test environment.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.center = new HexCoordinate(0, 0);
	}

	/**
	 * Tear-down the test environment.
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.center = null;
	}

	/**
	 * Tests HexCoordinate#distance().
	 *
	 * @throws Exception
	 */
	@Test
	public void distance() throws Exception {
		assertEquals(HexCoordinate.distance(new HexCoordinate(0, 0), new HexCoordinate(0, 1)), 1);
		assertEquals(HexCoordinate.distance(new HexCoordinate(0, 0), new HexCoordinate(0, 1)), 1);
	}
}