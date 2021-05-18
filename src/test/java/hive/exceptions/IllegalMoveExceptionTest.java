package hive.exceptions;

import hive.helpers.HexCoordinate;
import hive.helpers.Unit;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for hive.exceptions.IllegalMoveException.
 * <p>
 * Created at 28/03/16 12:00
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class IllegalMoveExceptionTest {
	/**
	 * Tests constructor.
	 *
	 * @throws Exception
	 */
	@Test
	public void testConstructor() throws Exception {
		IllegalMoveException e = new IllegalMoveException(Unit.fromRepresentation("wQ"), new HexCoordinate(0, 0));
		assertTrue(e.getMessage().contains("wQ") && e.getMessage().contains("[0, 0]"));
	}

}