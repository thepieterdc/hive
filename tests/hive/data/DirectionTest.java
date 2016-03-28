package hive.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for hive.data.Direction.
 * <p>
 * Created at 26/03/16 22:34
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class DirectionTest {
	/**
	 * Tests Direction#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("Left", Direction.LEFT.toString());
		assertEquals("Right", Direction.RIGHT.toString());
	}
}