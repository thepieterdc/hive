package hive.interfaces;

/**
 * Something that can be enabled and disabled.
 * <p>
 * Created at 21/04/16 21:46
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public interface Enableable {
	/**
	 * @param b true to enable, false to disable
	 */
	void enable(boolean b);
}
