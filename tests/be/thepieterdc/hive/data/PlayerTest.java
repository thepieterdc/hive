package be.thepieterdc.hive.data;

import javafx.scene.paint.Color;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for be.thepieterdc.data.Player.
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

	@Test
	public void testFromId() throws Exception {

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

	@Test
	public void testToString() throws Exception {

	}
}