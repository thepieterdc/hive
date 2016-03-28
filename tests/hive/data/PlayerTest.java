package hive.data;

import javafx.scene.paint.Color;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for hive.data.Player.
 * <p>
 * Created at 26/03/16 23:05
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class PlayerTest {
	/**
	 * Tests Player#color().
	 *
	 * @throws Exception
	 */
	@Test
	public void testColor() throws Exception {
		assertEquals(Color.BLANCHEDALMOND, Player.ONE.color());
		assertEquals(Color.BLANCHEDALMOND.invert(), Player.TWO.color());
	}

	/**
	 * Tests Player#fromId().
	 *
	 * @throws Exception
	 */
	@Test
	public void testFromId() throws Exception {
		assertEquals(Player.ONE, Player.fromId('b'));
		assertEquals(Player.TWO, Player.fromId('w'));
	}

	/**
	 * Tests Player#fromId() with invalid parameter: i (0).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFromIdIZero() throws Exception {
		Player.fromId('\0');
	}

	/**
	 * Tests Player#fromId() with invalid parameter: i (fake).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFromIdIFake() throws Exception {
		Player.fromId('@');
	}

	/**
	 * Tests Player#id().
	 *
	 * @throws Exception
	 */
	@Test
	public void testId() throws Exception {
		assertEquals('b', Player.ONE.id());
		assertEquals('w', Player.TWO.id());
	}

	/**
	 * Tests Player#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("Player[color=0xffebcdff, id=b]", Player.ONE.toString());
		assertEquals("Player[color=0x001432ff, id=w]", Player.TWO.toString());
	}
}