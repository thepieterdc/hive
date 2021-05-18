package hive.helpers;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * String manipulation utilities.
 * <p>
 * Created at 2/05/16 13:39
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class StringUtils {
	/**
	 * Finds the length of the longest line in a multiline-string.
	 *
	 * @param multilineString the multiline-string to analyse
	 * @return the length of the longest line
	 */
	public static int longestLine(String multilineString) {
		return Arrays
			.stream(multilineString.split(System.lineSeparator()))
			.mapToInt(String::length)
			.max()
			.orElse(0);
	}

	/**
	 * Uppercases the first letter and lowercases the rest of the string.
	 *
	 * @param raw the raw string
	 * @return the ucfirst'ed string
	 */
	public static String ucfirst(String raw) {
		if (raw.length() < 2) {
			return raw.toUpperCase();
		}
		return raw.substring(0, 1).toUpperCase() + raw.substring(1).toLowerCase();
	}
}
