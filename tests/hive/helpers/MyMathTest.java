package hive.helpers;

import org.junit.Test;

import static org.testng.Assert.assertEquals;

/**
 * Tests for hive.helpers.MyMath.
 * <p>
 * Created at 27/04/16 15:39
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class MyMathTest {
	/**
	 * Tests MyMath.divide().
	 *
	 * @throws Exception
	 */
	@Test
	public void testDivide() throws Exception {
		assertEquals(0, MyMath.divide(0, 5));
		assertEquals(5, MyMath.divide(20, 4));
		assertEquals(0, MyMath.divide(0, 0));
	}

	/**
	 * Tests MyMath.divide() with invalid parameter: the denominator is zero but the numerator is not.
	 *
	 * @throws Exception
	 */
	@Test(expected = ArithmeticException.class)
	public void testDivideNumeratorNotZero() throws Exception {
		MyMath.divide(5, 0);
	}

}