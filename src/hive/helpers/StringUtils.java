package hive.helpers;

/**
 * String manipulation utilities.
 * <p>
 * Created at 2/05/16 13:39
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public final class StringUtils {
	public static String ucfirst(String raw) {
		if (raw.length() < 2) {
			return raw.toUpperCase();
		}
		return raw.substring(0, 1).toUpperCase() + raw.substring(1).toLowerCase();
	}
}
