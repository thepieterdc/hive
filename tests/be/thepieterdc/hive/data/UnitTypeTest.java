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
	 * Tests UnitType#abbreviation().
	 */
	public void testAbbrevation() throws Exception {
		assertEquals("A", UnitType.ANT.abbreviation());
		assertEquals("B", UnitType.BEATLE.abbreviation());
		assertEquals("G", UnitType.GRASSHOPPER.abbreviation());
		assertEquals("L", UnitType.LADYBUG.abbreviation());
		assertEquals("M", UnitType.MOSQUITO.abbreviation());
		assertEquals("P", UnitType.PILLBUG.abbreviation());
		assertEquals("Q", UnitType.QUEEN.abbreviation());
		assertEquals("S", UnitType.SPIDER.abbreviation());
	}

	/**
	 * Tests UnitType#path() and Svg#path().
	 */
	public void testPath() throws Exception {
		assertTrue(UnitType.ANT.path() != null);
		assertTrue(UnitType.BEATLE.path() != null);
		assertTrue(UnitType.GRASSHOPPER.path() != null);
		assertTrue(UnitType.LADYBUG.path() != null);
		assertTrue(UnitType.MOSQUITO.path() != null);
		assertTrue(UnitType.PILLBUG.path() != null);
		assertTrue(UnitType.QUEEN.path() != null);
		assertTrue(UnitType.SPIDER.path() != null);
	}

	/**
	 * Tests UnitType#abbreviation().
	 */
	public void testPrettyName() throws Exception {
		assertEquals("Ant", UnitType.ANT.prettyName());
		assertEquals("Beatle", UnitType.BEATLE.prettyName());
		assertEquals("Grasshopper", UnitType.GRASSHOPPER.prettyName());
		assertEquals("Ladybug", UnitType.LADYBUG.prettyName());
		assertEquals("Mosquito", UnitType.MOSQUITO.prettyName());
		assertEquals("Pillbug", UnitType.PILLBUG.prettyName());
		assertEquals("Queen", UnitType.QUEEN.prettyName());
		assertEquals("Spider", UnitType.SPIDER.prettyName());
	}

	/**
	 * Tests UnitType#toString().
	 */
	public void testToString() throws Exception {
		assertEquals("UnitType[abbreviation=A, prettyName=Ant]", UnitType.ANT.toString());
		assertEquals("UnitType[abbreviation=B, prettyName=Beatle]", UnitType.BEATLE.toString());
		assertEquals("UnitType[abbreviation=G, prettyName=Grasshopper]", UnitType.GRASSHOPPER.toString());
		assertEquals("UnitType[abbreviation=L, prettyName=Ladybug]", UnitType.LADYBUG.toString());
		assertEquals("UnitType[abbreviation=M, prettyName=Mosquito]", UnitType.MOSQUITO.toString());
		assertEquals("UnitType[abbreviation=P, prettyName=Pillbug]", UnitType.PILLBUG.toString());
		assertEquals("UnitType[abbreviation=Q, prettyName=Queen]", UnitType.QUEEN.toString());
		assertEquals("UnitType[abbreviation=S, prettyName=Spider]", UnitType.SPIDER.toString());
	}
}