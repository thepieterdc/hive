package hive.exceptions;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Tests for hive.exceptions.UnmarshalException.
 * <p>
 * Created at 28/03/16 12:00
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnmarshalExceptionTest {
	/**
	 * Tests constructor.
	 *
	 * @throws Exception
	 */
	@Test
	public void testConstructor() throws Exception {
		UnmarshalException e = new UnmarshalException("test");
		assertTrue(e.getMessage().contains("test"));
	}

}