package hive.helpers;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.Collection;
import java.util.HashSet;

/**
 * Abstract model class.
 * <p>
 * Created at 16/03/16 22:26
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public abstract class Model implements Observable {
	protected final Collection<InvalidationListener> listeners = new HashSet<>(100);

	@Override
	public void addListener(InvalidationListener l) {
		if (l == null) {
			throw new IllegalArgumentException("Parameter \"l\" is null.");
		}
		this.listeners.add(l);
	}

	/**
	 * Notifies all registered listeners that the model has been updated.
	 */
	protected void notifyListeners() {
		this.listeners.forEach(l -> l.invalidated(this));
	}

	@Override
	public void removeListener(InvalidationListener l) {
		if (l == null) {
			throw new IllegalArgumentException("Parameter \"l\" is null.");
		}
		this.listeners.remove(l);
	}

	public void removeListeners() {
		this.listeners.clear();
	}
}
