package be.thepieterdc.hive.helpers;

import junit.framework.TestCase;

/**
 * Description here
 * <p>
 * Created at 16/03/16 19:39
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class CoordinateTest extends TestCase {

	private Coordinate coordinate = null;

	/**
	 * Set-up the test environment.
	 */
	public void setUp() {
		this.coordinate = new Coordinate(5000, 8000);
	}

	/**
	 * Tear-down the test environment.
	 */
	public void tearDown() {
		this.coordinate = null;
	}

	/**
	 * Tests Coordinate#toString().
	 * @throws Exception
	 */
	public void testToString() throws Exception {
		assertEquals("Coordinate[x=5000.0, y=8000.0]", this.coordinate.toString());
	}

	/**
	 * Tests Coordinate#x().
	 * @throws Exception
	 */
	public void testX() throws Exception {
		assertEquals(5000.0, this.coordinate.x());
	}

	/**
	 * Tests Coordinate#y().
	 * @throws Exception
	 */
	public void testY() throws Exception {
		assertEquals(8000.0, this.coordinate.y());
	}
}