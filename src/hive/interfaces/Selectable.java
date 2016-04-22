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
	 * Selects or deselects the Node.
	 *
	 * @param b true to select the Node, false to deselect it
	 */
	void select(boolean b);

	/**
	 * @return true if the Node can be selected.
	 */
	boolean selectable();
}
