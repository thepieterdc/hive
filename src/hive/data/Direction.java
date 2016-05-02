package hive.data;

import hive.helpers.StringUtils;
import hive.interfaces.Representable;

/**
 * Direction enum.
 * <p>
 * Created at 19/03/16 14:25
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public enum Direction implements Representable {
	LEFT,
	RIGHT;

	@Override
	public String representation() {
		return StringUtils.ucfirst(this.name());
	}

	@Override
	public String toString() {
		return "Direction[" + this.representation() + ']';
	}
}