package hive.interfaces;

/**
 * A selectable node.
 * <p>
 * Created at 21/04/16 21:36
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public interface Selectable {
	/**
	 * @param b true to select the node, false to deselect it
	 */
	void select(boolean b);
}
