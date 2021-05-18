package hive.helpers;

import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for hive.helpers.PlayerTest.
 * <p>
 * Created at 5/05/16 12:21
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class PlayerTest {
	private Player playerOne;
	private Player playerTwo;

	/**
	 * Set-up the test environment.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.playerOne = new Player('b', Color.BLANCHEDALMOND, "myname");
		this.playerTwo = new Player('w', Color.AQUAMARINE, "jeej");
	}

	/**
	 * Tear-down the test environment.
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.playerOne = null;
		this.playerTwo = null;
	}

	/**
	 * Tests Player#color().
	 *
	 * @throws Exception
	 */
	@Test
	public void testColor() throws Exception {
		assertEquals(Color.BLANCHEDALMOND, this.playerOne.color());
		assertEquals(Color.AQUAMARINE, this.playerTwo.color());
	}

	/**
	 * Tests Player#equals().
	 *
	 * @throws Exception
	 */
	@Test
	public void testEquals() throws Exception {
		assertTrue(this.playerOne.equals(new Player('b', Color.BLANCHEDALMOND, "myname")));
		assertTrue(this.playerTwo.equals(new Player('w', Color.AQUAMARINE, "jeej")));
	}

	/**
	 * Tests Player#hashCode().
	 *
	 * @throws Exception
	 */
	@Test
	public void testHashCode() throws Exception {
		assertEquals(this.playerOne.id() + this.playerOne.color().hashCode() + this.playerOne.name().hashCode(), this.playerOne.hashCode());
		assertEquals(this.playerTwo.id() + this.playerTwo.color().hashCode() + this.playerTwo.name().hashCode(), this.playerTwo.hashCode());
	}
}