package hive.helpers;

/**
 * Math utilities.
 * <p>
 * Created at 23/04/16 21:19
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class MyMath {

	//Returns 0 no matter what denominator is if numerator is 0.
	public static int divide(int num, int denom) {
		return num == 0 ? num : num / denom;
	}
}
