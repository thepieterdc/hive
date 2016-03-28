package hive.components;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for hive.components.Hexagon.
 * <p>
 * Created at 28/03/16 12:29
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class HexagonTest {
	private Hexagon hex;

	/**
	 * Set-up the test environment
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.hex = new Hexagon();
	}

	/**
	 * Tear-down the test environment
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.hex = null;
	}

	/**
	 * Tests Hexagon#height().
	 *
	 * @throws Exception
	 */
	@Test
	public void testHeight() throws Exception {
		this.hex.scale(1);
		assertEquals(20, this.hex.height(), 0);
	}

	/**
	 * Tests DefaultHexagon#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		this.hex.setTranslateX(0);
		this.hex.setTranslateY(0);
		assertEquals("Hexagon[x=0.0, y=-0.0]", this.hex.toString());
	}

}