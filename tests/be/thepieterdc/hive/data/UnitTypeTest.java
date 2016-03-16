package be.thepieterdc.hive.data;

import junit.framework.TestCase;

/**
 * Tests UnitType
 * <p>
 * Created at 16/03/16 19:11
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnitTypeTest extends TestCase {
	/**
	 * Tests UnitType#abbreviation()
	 */
	public void testAbbrevation() {
		assertEquals("A", UnitType.ANT.abbreviation());
		assertEquals("B", UnitType.BEATLE.abbreviation());
		assertEquals("G", UnitType.GRASSHOPPER.abbreviation());
		assertEquals("Q", UnitType.QUEEN.abbreviation());
		assertEquals("S", UnitType.SPIDER.abbreviation());
	}

	/**
	 * Tests UnitType#path() and Svg#path()
	 */
	public void testPath() {
		assertTrue(UnitType.ANT.path() != null);
		assertTrue(UnitType.BEATLE.path() != null);
		assertTrue(UnitType.GRASSHOPPER.path() != null);
		assertTrue(UnitType.QUEEN.path() != null);
		assertTrue(UnitType.SPIDER.path() != null);
	}

	/**
	 * Tests UnitType#abbreviation()
	 */
	public void testPrettyName() {
		assertEquals("Ant", UnitType.ANT.prettyName());
		assertEquals("Beatle", UnitType.BEATLE.prettyName());
		assertEquals("Grasshopper", UnitType.GRASSHOPPER.prettyName());
		assertEquals("Queen", UnitType.QUEEN.prettyName());
		assertEquals("Spider", UnitType.SPIDER.prettyName());
	}
}