package be.thepieterdc.hive.models;

import be.thepieterdc.hive.helpers.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for the Viewer part.
 * <p>
 * Created at 17/03/16 14:08
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class ViewerModel extends Model {
	private final List<String> moves;

	/**
	 * ViewerModel constructor.
	 */
	public ViewerModel() {
		this.moves = new ArrayList<>();
	}

	/**
	 * moves-setter.
	 * @param moves the moves to set
	 */
	public void moves(List<String> moves) {
		this.moves.addAll(moves);
	}

	/**
	 * moves-getter.
	 * @return the moves
	 */
	public List<String> moves() {
		return this.moves;
	}
}
