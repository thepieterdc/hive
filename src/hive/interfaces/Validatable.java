package hive.interfaces;

/**
 * Anything that can be validated.
 * <p>
 * Created at 2/04/16 15:26
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
@FunctionalInterface
public interface Validatable<P> {
	/**
	 * Validates anything.
	 *
	 * @param param a required parameter to validate
	 * @return true if valid
	 */
	boolean valid(P param);
}
