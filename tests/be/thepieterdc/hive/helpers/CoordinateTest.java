package be.thepieterdc.hive.helpers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Tests for be.thepieterdc.helpers.Coordinate.
 * <p>
 * Created at 27/03/16 10:46
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class CoordinateTest {
	private Coordinate allNeg;
	private Coordinate allPos;
	private Coordinate negXposY;
	private Coordinate origin;
	private Coordinate posXNegY;

	/**
	 * Set-up the test environment.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.origin = new Coordinate(0, 0);
		this.allNeg = new Coordinate(-5, -10);
		this.allPos = new Coordinate(5, 10);
		this.negXposY = new Coordinate(-5, 10);
		this.posXNegY = new Coordinate(5, -10);
	}

	/**
	 * Tear-down the test environment.
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.origin = null;
		this.allNeg = null;
		this.allPos = null;
		this.negXposY = null;
		this.posXNegY = null;
	}

	/**
	 * Tests Coordinate#asList().
	 *
	 * @throws Exception
	 */
	@Test
	public void testAsList() throws Exception {
		assertThat(Arrays.asList(0.0, 0.0), is(this.origin.asList()));
		assertThat(Arrays.asList(-5.0, -10.0), is(this.allNeg.asList()));
		assertThat(Arrays.asList(5.0, 10.0), is(this.allPos.asList()));
		assertThat(Arrays.asList(-5.0, 10.0), is(this.negXposY.asList()));
		assertThat(Arrays.asList(5.0, -10.0), is(this.posXNegY.asList()));
	}

	/**
	 * Tests Coordinate#equals().
	 *
	 * @throws Exception
	 */
	@Test
	public void testEquals() throws Exception {
		assertEquals(new Coordinate(0.0, 0.0), this.origin);
		assertEquals(new Coordinate(-5.0, -10.0), this.allNeg);
		assertEquals(new Coordinate(5.0, 10.0), this.allPos);
		assertEquals(new Coordinate(-5.0, 10.0), this.negXposY);
		assertEquals(new Coordinate(5.0, -10.0), this.posXNegY);
	}

	/**
	 * Tests Coordinate#hashCode().
	 *
	 * @throws Exception
	 */
	@Test
	public void testHashCode() throws Exception {
		assertEquals(0, this.origin.hashCode());
		assertEquals(-510, this.allNeg.hashCode());
		assertEquals(510, this.allPos.hashCode());
		assertEquals(-490, this.negXposY.hashCode());
		assertEquals(490, this.posXNegY.hashCode());
	}

	/**
	 * Tests Coordinate#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("Coordinate[x=0.0, y=0.0]", this.origin.toString());
		assertEquals("Coordinate[x=-5.0, y=-10.0]", this.allNeg.toString());
		assertEquals("Coordinate[x=5.0, y=10.0]", this.allPos.toString());
		assertEquals("Coordinate[x=-5.0, y=10.0]", this.negXposY.toString());
		assertEquals("Coordinate[x=5.0, y=-10.0]", this.posXNegY.toString());
	}

	/**
	 * Tests Coordinate#x().
	 *
	 * @throws Exception
	 */
	@Test
	public void testX() throws Exception {
		assertThat(0.0, equalTo(this.origin.x()));
		assertThat(-5.0, equalTo(this.allNeg.x()));
		assertThat(5.0, equalTo(this.allPos.x()));
		assertThat(-5.0, equalTo(this.negXposY.x()));
		assertThat(5.0, equalTo(this.posXNegY.x()));
	}

	/**
	 * Tests Coordinate#y().
	 *
	 * @throws Exception
	 */
	@Test
	public void testY() throws Exception {
		assertThat(0.0, equalTo(this.origin.y()));
		assertThat(-10.0, equalTo(this.allNeg.y()));
		assertThat(10.0, equalTo(this.allPos.y()));
		assertThat(10.0, equalTo(this.negXposY.y()));
		assertThat(-10.0, equalTo(this.posXNegY.y()));
	}

}