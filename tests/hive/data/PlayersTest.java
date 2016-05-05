package hive.data;

import org.junit.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Tests for hive.data.Players.
 * <p>
 * Created at 5/05/16 10:34
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class PlayersTest {
	/**
	 * Tests Players.fromId().
	 *
	 * @throws Exception
	 */
	@Test
	public void testFromId() throws Exception {
		assertEquals(Players.BLACK.player(), Players.fromId('b'));
		assertEquals(Players.WHITE.player(), Players.fromId('w'));
		assertNull(Players.fromId('a'));
	}

	/**
	 * Tests Players#player().
	 *
	 * @throws Exception
	 */
	@Test
	public void testPlayer() throws Exception {
		assertEquals("b", Players.BLACK.player().name());
		assertEquals("w", Players.WHITE.player().name());
	}

	/**
	 * Tests Players#representation().
	 *
	 * @throws Exception
	 */
	@Test
	public void testRepresentation() throws Exception {
		assertEquals("b", Players.BLACK.representation());
		assertEquals("w", Players.WHITE.representation());
	}

	/**
	 * Tests Players#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("Players[id=b, color=0x001432ff]", Players.BLACK.toString());
		assertEquals("Players[id=w, color=0xffebcdff]", Players.WHITE.toString());
	}

}