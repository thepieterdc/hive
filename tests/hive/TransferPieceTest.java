package hive;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for hive.TransferPiece.
 * <p>
 * <i>For the sake of Coverage.</i>
 * Created at 27/03/16 13:45
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class TransferPieceTest {
	private TransferPiece tp1;
	private TransferPiece tp2;

	/**
	 * Set-up the test environment.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.tp1 = new TransferPiece('A', 'b', 2, 50, 100);
		this.tp2 = new TransferPiece('Q', 'w', 100, 50);
	}

	/**
	 * Tear-down the test environment.
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.tp1 = null;
		this.tp2 = null;
	}

	/**
	 * Tests TransferPiece#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testTtoString() throws Exception {
		assertEquals("50 100 bA2", this.tp1.toString());
		assertEquals("100 50 wQ1", this.tp2.toString());
	}

	/**
	 * Tests TransferPiece#compareTo().
	 *
	 * @throws Exception
	 */
	@Test
	public void testCompareTo() throws Exception {
		assertEquals(-1, this.tp1.compareTo(this.tp2));
		assertEquals(0, this.tp1.compareTo(new TransferPiece('B', 'w', 1, 50, 100)));
		assertEquals(1, this.tp1.compareTo(new TransferPiece('Q', 'b', 50, 80)));
	}

}