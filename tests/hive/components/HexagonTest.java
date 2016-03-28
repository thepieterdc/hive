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
	 * Tests Hexagon#scale() with invalid parameter: scale(<=0)
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testScaleFactorNegativeZero() throws Exception {
		this.hex.scale(0);
		this.hex.scale(-5.0);
	}

	/**
	 * Tests DefaultHexagon#translate().
	 *
	 * @throws Exception
	 */
	@Test
	public void testTranslate() throws Exception {
		this.hex.translate(5.0, 8.0);
		assertEquals(5.0, this.hex.getTranslateX(), 0);
		assertEquals(8.0, this.hex.getTranslateY(), 0);
	}

	/**
	 * Tests DefaultHexagon#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		this.hex.translate(0.0, 0.0);
		assertEquals("Hexagon[x=0.0, y=0.0]", this.hex.toString());
	}

	/**
	 * Tests Hexagon#width().
	 *
	 * @throws Exception
	 */
	@Test
	public void testWidth() throws Exception {
		this.hex.scale(1);
		assertEquals(2 * Math.sqrt(75), this.hex.width(), 0);
	}
}