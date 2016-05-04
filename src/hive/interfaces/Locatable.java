package hive.interfaces;

/**
 * Anything that can be located
 * <p>
 * Created at 28/04/16 20:50
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public interface Locatable {
	/**
	 * @return the x-coordinate
	 */
	double x();

	/**
	 * @return the y-coordinate
	 */
	double y();
}
