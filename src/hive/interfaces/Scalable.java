package hive.interfaces;

/**
 * A scalable node.
 * <p>
 * Created at 25/03/16 9:52
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public interface Scalable {
	/**
	 * @return the height of the node
	 */
	double height();

	double scale();

	/**
	 * @param factor the factor to scale the node with
	 */
	void scale(double factor);

	/**
	 * @return the width of the node
	 */
	double width();
}
