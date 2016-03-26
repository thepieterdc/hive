package be.thepieterdc.hive.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for be.thepieterdc.data.Orientation.
 * <p>
 * Created at 26/03/16 22:47
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class OrientationTest {
	/**
	 * Tests Orientation#columnDelta().
	 *
	 * @throws Exception
	 */
	@Test
	public void testColumnDelta() throws Exception {
		assertEquals(-1, Orientation.LEFTMIDDLE.columnDelta());
		assertEquals(0, Orientation.LEFTUPPER.columnDelta());
		assertEquals(-1, Orientation.LEFTUNDER.columnDelta());
		assertEquals(1, Orientation.RIGHTMIDDLE.columnDelta());
		assertEquals(1, Orientation.RIGHTUPPER.columnDelta());
		assertEquals(0, Orientation.RIGHTUNDER.columnDelta());
	}

	/**
	 * Tests Orientation#direction().
	 *
	 * @throws Exception
	 */
	@Test
	public void testDirection() throws Exception {
		assertEquals(Direction.LEFT, Orientation.LEFTMIDDLE.direction());
		assertEquals(Direction.LEFT, Orientation.LEFTUPPER.direction());
		assertEquals(Direction.LEFT, Orientation.LEFTUNDER.direction());
		assertEquals(Direction.RIGHT, Orientation.RIGHTMIDDLE.direction());
		assertEquals(Direction.RIGHT, Orientation.RIGHTUPPER.direction());
		assertEquals(Direction.RIGHT, Orientation.RIGHTUNDER.direction());
	}

	/**
	 * Tests Orientation#fromRepresentation().
	 *
	 * @throws Exception
	 */
	@Test
	public void testFromRepresentation() throws Exception {
		assertEquals(Orientation.LEFTMIDDLE, Orientation.fromRepresentation("-", Direction.LEFT));
		assertEquals(Orientation.LEFTUPPER, Orientation.fromRepresentation("\\", Direction.LEFT));
		assertEquals(Orientation.LEFTUNDER, Orientation.fromRepresentation("/", Direction.LEFT));
		assertEquals(Orientation.RIGHTMIDDLE, Orientation.fromRepresentation("-", Direction.RIGHT));
		assertEquals(Orientation.RIGHTUPPER, Orientation.fromRepresentation("/", Direction.RIGHT));
		assertEquals(Orientation.RIGHTUNDER, Orientation.fromRepresentation("\\", Direction.RIGHT));
	}

	/**
	 * Tests Orientation#representation().
	 *
	 * @throws Exception
	 */
	@Test
	public void testRepresentation() throws Exception {
		assertEquals("-", Orientation.LEFTMIDDLE.representation());
		assertEquals("\\", Orientation.LEFTUPPER.representation());
		assertEquals("/", Orientation.LEFTUNDER.representation());
		assertEquals("-", Orientation.RIGHTMIDDLE.representation());
		assertEquals("/", Orientation.RIGHTUPPER.representation());
		assertEquals("\\", Orientation.RIGHTUNDER.representation());
	}

	/**
	 * Tests Orientation#rowDelta().
	 *
	 * @throws Exception
	 */
	@Test
	public void testRowDelta() throws Exception {
		assertEquals(0, Orientation.LEFTMIDDLE.rowDelta());
		assertEquals(-1, Orientation.LEFTUPPER.rowDelta());
		assertEquals(1, Orientation.LEFTUNDER.rowDelta());
		assertEquals(0, Orientation.RIGHTMIDDLE.rowDelta());
		assertEquals(-1, Orientation.RIGHTUPPER.rowDelta());
		assertEquals(1, Orientation.RIGHTUNDER.rowDelta());
	}

	/**
	 * Tests Orientation#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("Orientation[columnDelta=-1, direction=Left, representation=-, rowDelta=0]", Orientation.LEFTMIDDLE.toString());
		assertEquals("Orientation[columnDelta=0, direction=Left, representation=\\, rowDelta=-1]", Orientation.LEFTUPPER.toString());
		assertEquals("Orientation[columnDelta=-1, direction=Left, representation=/, rowDelta=1]", Orientation.LEFTUNDER.toString());
		assertEquals("Orientation[columnDelta=1, direction=Right, representation=-, rowDelta=0]", Orientation.RIGHTMIDDLE.toString());
		assertEquals("Orientation[columnDelta=1, direction=Right, representation=/, rowDelta=-1]", Orientation.RIGHTUPPER.toString());
		assertEquals("Orientation[columnDelta=0, direction=Right, representation=\\, rowDelta=1]", Orientation.RIGHTUNDER.toString());
	}

}