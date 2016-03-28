package be.thepieterdc.hive.exceptions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Tests for be.thepieterdc.exceptions.MalformedMoveException.
 * <p>
 * Created at 28/03/16 12:00
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class MalformedMoveExceptionTest {
	private MalformedMoveException e;

	/**
	 * Set-up the test environment.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.e = new MalformedMoveException("Test", null);
	}

	/**
	 * Tear-down the test environment.
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.e = null;
	}

	/**
	 * Tests MalformedMoveException#move().
	 *
	 * @throws Exception
	 */
	@Test
	public void move() throws Exception {
		assertEquals("Test",this.e.move());
	}

}