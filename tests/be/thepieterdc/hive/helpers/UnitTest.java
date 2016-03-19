package be.thepieterdc.hive.helpers;

import be.thepieterdc.hive.data.UnitType;
import javafx.scene.paint.Color;
import junit.framework.TestCase;

/**
 * Tests be.thepieterdc.hive.helpers.Unit.
 * <p>
 * Created at 19/03/16 12:30
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnitTest extends TestCase {
	private Unit unit = null;
	private Unit queen = null;

	/**
	 * Set-up the test environment.
	 */
	public void setUp() {
		this.queen = new Unit(Color.WHITE, UnitType.QUEEN);
		this.unit = new Unit(Color.BLACK, UnitType.MOSQUITO, 3);
	}

	/**
	 * Tear-down the test environment.
	 */
	public void tearDown() {
		this.queen = null;
		this.unit = null;
	}

	/**
	 * Tests Unit#player().
	 */
	public void testPlayer() throws Exception {
		assertEquals(Color.WHITE, this.queen.player());
		assertEquals(Color.BLACK, this.unit.player());
	}

	/**
	 * Tests Unit#rank().
	 */
	public void testRank() throws Exception {
		assertEquals(0, this.queen.rank());
		assertEquals(3, this.unit.rank());
	}

	/**
	 * Tests Unit#type().
	 */
	public void testType() throws Exception {
		assertEquals(UnitType.QUEEN, this.queen.type());
		assertEquals(UnitType.MOSQUITO, this.queen.type());
	}
}