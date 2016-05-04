package hive.interfaces;

/**
 * A representable class.
 * <p>
 * Created at 21/04/16 21:36
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
@FunctionalInterface
public interface Representable {
	/**
	 * @return the string representation of the object
	 */
	String representation();
}
