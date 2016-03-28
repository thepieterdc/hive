package hive.interfaces;

/**
 * A translatable node.
 * <p>
 * Created at 28/03/16 14:35
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public interface Translatable {
	/**
	 * Translates the node.
	 * @param x the translation's x-delta
	 * @param y the translation's y-delta
	 */
	void translate(double x, double y);
}
