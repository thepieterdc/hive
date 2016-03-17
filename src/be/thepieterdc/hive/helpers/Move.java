package be.thepieterdc.hive.helpers;

/**
 * Describes a move.
 * <p>
 * Created at 17/03/16 15:18
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Move {
	private final int index;
	private final String repr;

	/**
	 * Move constructor. NIET GEBRUIKEN IN FINAL
	 * @param index
	 * @param r
	 */
	@Deprecated
	public Move(int index, String r) {
		this.index = index;
		this.repr = r;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Move && ((Move) obj).index == this.index;
	}

	@Override
	public int hashCode() {
		return this.index;
	}

	public int index() {
		return this.index;
	}

	public String label() {
		return this.repr;
	}

	public String toString() {
		return "Move[index="+this.index+", label="+this.repr+"]";
	}
}
