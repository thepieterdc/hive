package hive.data;

import hive.helpers.pathfinding.pathfinders.AntPathFinder;
import hive.helpers.pathfinding.pathfinders.GrasshopperPathFinder;
import hive.helpers.pathfinding.pathfinders.QueenBeetlePathFinder;
import hive.helpers.pathfinding.pathfinders.SpiderPathFinder;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for hive.data.UnitType.
 * <p>
 * Created at 27/03/16 10:09
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnitTypeTest {
	/**
	 * Tests UnitType#abbreviation().
	 *
	 * @throws Exception
	 */
	@Test
	public void testAbbreviation() throws Exception {
		assertEquals('A', UnitType.ANT.abbreviation());
		assertEquals('B', UnitType.BEETLE.abbreviation());
		assertEquals('G', UnitType.GRASSHOPPER.abbreviation());
		assertEquals('L', UnitType.LADYBUG.abbreviation());
		assertEquals('M', UnitType.MOSQUITO.abbreviation());
		assertEquals('P', UnitType.PILLBUG.abbreviation());
		assertEquals('Q', UnitType.QUEEN.abbreviation());
		assertEquals('S', UnitType.SPIDER.abbreviation());
	}

	/**
	 * Tests UnitType#capacity().
	 *
	 * @throws Exception
	 */
	@Test
	public void testCapacity() throws Exception {
		assertEquals(3, UnitType.ANT.capacity());
		assertEquals(2, UnitType.BEETLE.capacity());
		assertEquals(3, UnitType.GRASSHOPPER.capacity());
		assertEquals(0, UnitType.LADYBUG.capacity());
		assertEquals(0, UnitType.MOSQUITO.capacity());
		assertEquals(0, UnitType.PILLBUG.capacity());
		assertEquals(1, UnitType.QUEEN.capacity());
		assertEquals(2, UnitType.SPIDER.capacity());
	}

	/**
	 * Tests UnitType#fromAbbreviation().
	 *
	 * @throws Exception
	 */
	@Test
	public void testFromAbbreviation() throws Exception {
		assertEquals(UnitType.ANT, UnitType.fromAbbreviation('A'));
		assertEquals(UnitType.BEETLE, UnitType.fromAbbreviation('B'));
		assertEquals(UnitType.GRASSHOPPER, UnitType.fromAbbreviation('G'));
		assertEquals(UnitType.MOSQUITO, UnitType.fromAbbreviation('M'));
		assertEquals(UnitType.LADYBUG, UnitType.fromAbbreviation('L'));
		assertEquals(UnitType.PILLBUG, UnitType.fromAbbreviation('P'));
		assertEquals(UnitType.QUEEN, UnitType.fromAbbreviation('Q'));
		assertEquals(UnitType.SPIDER, UnitType.fromAbbreviation('S'));
	}

	/**
	 * Tests UnitType#fromAbbreviation() with invalid parameter: a (0).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFromAbbreviationAZero() throws Exception {
		UnitType.fromAbbreviation('\0');
	}

	/**
	 * Tests UnitType#fromAbbreviation() with invalid parameter: a (fake).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFromAbbreviationAFake() throws Exception {
		UnitType.fromAbbreviation('@');
	}

	/**
	 * Tests UnitType#path().
	 *
	 * @throws Exception
	 */
	@Test
	public void testPath() throws Exception {
		assertEquals(Svg.UNIT_ANT.path().getContent(), UnitType.ANT.path().getContent());
		assertEquals(Svg.UNIT_BEETLE.path().getContent(), UnitType.BEETLE.path().getContent());
		assertEquals(Svg.UNIT_GRASSHOPPER.path().getContent(), UnitType.GRASSHOPPER.path().getContent());
		assertEquals(Svg.UNIT_LADYBUG.path().getContent(), UnitType.LADYBUG.path().getContent());
		assertEquals(Svg.UNIT_MOSQUITO.path().getContent(), UnitType.MOSQUITO.path().getContent());
		assertEquals(Svg.UNIT_PILLBUG.path().getContent(), UnitType.PILLBUG.path().getContent());
		assertEquals(Svg.UNIT_QUEEN.path().getContent(), UnitType.QUEEN.path().getContent());
		assertEquals(Svg.UNIT_SPIDER.path().getContent(), UnitType.SPIDER.path().getContent());
	}


	/**
	 * Tests UnitType#pathFinder().
	 *
	 * @throws Exception
	 */
	@Test
	public void testPathFinder() throws Exception {
		assertTrue(UnitType.ANT.pathFinder().get() instanceof AntPathFinder);
		assertTrue(UnitType.BEETLE.pathFinder().get() instanceof QueenBeetlePathFinder);
		assertTrue(UnitType.GRASSHOPPER.pathFinder().get() instanceof GrasshopperPathFinder);
		assertNull(UnitType.LADYBUG.pathFinder());
		assertNull(UnitType.MOSQUITO.pathFinder());
		assertNull(UnitType.PILLBUG.pathFinder());
		assertTrue(UnitType.QUEEN.pathFinder().get() instanceof QueenBeetlePathFinder);
		assertTrue(UnitType.SPIDER.pathFinder().get() instanceof SpiderPathFinder);

	}

	/**
	 * Tests UnitType#representation().
	 *
	 * @throws Exception
	 */
	@Test
	public void testRepresentation() throws Exception {
		assertEquals("Ant", UnitType.ANT.representation());
		assertEquals("Beetle", UnitType.BEETLE.representation());
		assertEquals("Grasshopper", UnitType.GRASSHOPPER.representation());
		assertEquals("Ladybug", UnitType.LADYBUG.representation());
		assertEquals("Mosquito", UnitType.MOSQUITO.representation());
		assertEquals("Pillbug", UnitType.PILLBUG.representation());
		assertEquals("Queen", UnitType.QUEEN.representation());
		assertEquals("Spider", UnitType.SPIDER.representation());
	}

	/**
	 * Tests UnitType#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("UnitType[abbreviation=A, capacity=3, repr=Ant]", UnitType.ANT.toString());
		assertEquals("UnitType[abbreviation=B, capacity=2, repr=Beetle]", UnitType.BEETLE.toString());
		assertEquals("UnitType[abbreviation=G, capacity=3, repr=Grasshopper]", UnitType.GRASSHOPPER.toString());
		assertEquals("UnitType[abbreviation=L, capacity=0, repr=Ladybug]", UnitType.LADYBUG.toString());
		assertEquals("UnitType[abbreviation=M, capacity=0, repr=Mosquito]", UnitType.MOSQUITO.toString());
		assertEquals("UnitType[abbreviation=P, capacity=0, repr=Pillbug]", UnitType.PILLBUG.toString());
		assertEquals("UnitType[abbreviation=Q, capacity=1, repr=Queen]", UnitType.QUEEN.toString());
		assertEquals("UnitType[abbreviation=S, capacity=2, repr=Spider]", UnitType.SPIDER.toString());
	}
}