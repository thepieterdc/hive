package hive.helpers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for hive.helpers.StringUtils.
 * <p>
 * Created at 5/05/16 11:21
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class StringUtilsTest extends StringUtils {
	/**
	 * Tests StringUtils.longestLine().
	 *
	 * @throws Exception
	 */
	@Test
	public void testLongestLine() throws Exception {
		assertEquals(7, StringUtils.longestLine("lineOne" + System.lineSeparator() + "word" + System.lineSeparator() + "line3"));
	}

	/**
	 * Tests StringUtils.ucfirst().
	 *
	 * @throws Exception
	 */
	@Test
	public void testUcfirst() throws Exception {
		assertEquals("Test sentence", StringUtils.ucfirst("tEST sEnTenCe"));
		assertEquals("T", StringUtils.ucfirst("t"));
	}

}