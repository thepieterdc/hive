package hive.interfaces;

/**
 * A class that can be validated.
 * <p>
 * Created at 2/04/16 15:26
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public interface Validatable<P> {
	/**
	 * Validates the class.
	 *
	 * @param param a required parameter to validate the class
	 * @return true if the class is valid
	 */
	boolean valid(P param);
}
