package hive;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 * Test listener for testing models.
 * <p>
 * Created at 28/03/16 13:11
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class TestListener implements InvalidationListener {
	private int called;

	/**
	 * TestListener constructor.
	 *
	 * @param m the model
	 */
	public TestListener(Observable m) {
		m.addListener(this);
	}

	/**
	 * @return the amount of times that the invalidated() was called.
	 */
	public int called() {
		return this.called;
	}

	@Override
	public void invalidated(Observable observable) {
		this.called++;
	}
}