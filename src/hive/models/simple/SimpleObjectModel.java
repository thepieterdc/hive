package hive.models.simple;

import hive.helpers.Model;
import javafx.beans.InvalidationListener;

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

	public T get() {
		return this.o;
	}

	public void set(T t) {
		this.o = t;
		System.out.println("New value: "+t);
		System.out.println(this.listeners.size());
		this.notifyListeners();
	}

	@Override
	public void addListener(InvalidationListener l) {
		super.addListener(l);
		System.out.println("added listener");
	}
}
