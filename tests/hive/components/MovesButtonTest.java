package hive.components;

import hive.JavaFXThreadingRule;
import hive.data.Svg;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for hive.components.MovesButton.
 * <p>
 * Created at 28/03/16 13:11
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class MovesButtonTest {
	@Rule
	public final JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	
	private MovesButton b;

	/**
	 * Set-up the test environment
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.b = new MovesButton(Svg.MOVEBUTTON_PLAY);
	}

	/**
	 * Tear-down the test environment
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.b = null;
	}

	/**
	 * Tests MovesButton#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("MovesButton[text=]", this.b.toString());
	}

	/**
	 * Tests MovesButton constructor with invalid parameter: lbl (null).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorLblNull() throws Exception {
		new MovesButton(null);
	}

}