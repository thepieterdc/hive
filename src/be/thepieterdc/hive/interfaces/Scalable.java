package be.thepieterdc.hive.interfaces;

/**
 * A scalable node.
 * <p>
 * Created at 25/03/16 9:52
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public interface Scalable {

	double height();

	void scale(double factor);

	double width();
}
