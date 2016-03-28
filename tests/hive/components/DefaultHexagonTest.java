package hive.components;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for hive.components.DefaultHexagon.
 * <p>
 * Created at 28/03/16 12:29
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class DefaultHexagonTest {
	private DefaultHexagon hex1;
	private DefaultHexagon hex2;

	/**
	 * Set-up the test environment
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.hex1 = new DefaultHexagon();
		this.hex1.setTranslateX(20);
		this.hex1.setTranslateY(-50);
		this.hex2 = new DefaultHexagon();
		this.hex2.setTranslateX(-20);
		this.hex2.setTranslateY(50);
	}

	/**
	 * Tear-down the test environment
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.hex1 = null;
		this.hex2 = null;
	}

	/**
	 * Tests DefaultHexagon#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("DefaultHexagon[x=20.0, y=-50.0]", this.hex1.toString());
		assertEquals("DefaultHexagon[x=-20.0, y=50.0]", this.hex2.toString());
	}

}