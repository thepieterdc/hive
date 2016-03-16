package be.thepieterdc.hive.helpers;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;

/**
 * Abstract class that represents a model.
 * <p>
 * Created at 16/03/16 22:26
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Model implements Observable {
	private final ArrayList<InvalidationListener> listeners = new ArrayList<>();

	@Override
	public void addListener(InvalidationListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		this.listeners.remove(listener);
	}
}
