package hive.models.simple;

import hive.helpers.Model;

/**
 * A model that only has one Observable value.
 * Reason for not using a <i>SimpleObjectProperty</i>: Lacking a removeAllListeners method.
 * <p>
 * Created at 3/05/16 19:30
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class SimpleObjectModel<T> extends Model {
	private T o;

	/**
	 * @return the value of the object
	 */
	public T get() {
		return this.o;
	}

	/**
	 * Sets the value of the object.
	 *
	 * @param t the value
	 */
	public void set(T t) {
		this.o = t;
		this.notifyListeners();
	}
}
