package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.UnitType;
import be.thepieterdc.hive.helpers.Unit;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.GridPane;

/**
 * Grid that holds all playable units.
 * <p>
 * Created at 19/03/16 9:28
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class UnitPane extends GridPane implements InvalidationListener {
	private final ViewerModel model;

	private final UnitHexagon p1A1;
	private final UnitHexagon p1A2;
	private final UnitHexagon p1A3;
	private final UnitHexagon p1B1;
	private final UnitHexagon p1B2;
	private final UnitHexagon p1G1;
	private final UnitHexagon p1G2;
	private final UnitHexagon p1G3;
	private final UnitHexagon p1Q;
	private final UnitHexagon p1S1;
	private final UnitHexagon p1S2;

	private final UnitHexagon p2A1;
	private final UnitHexagon p2A2;
	private final UnitHexagon p2A3;
	private final UnitHexagon p2B1;
	private final UnitHexagon p2B2;
	private final UnitHexagon p2G1;
	private final UnitHexagon p2G2;
	private final UnitHexagon p2G3;
	private final UnitHexagon p2Q;
	private final UnitHexagon p2S1;
	private final UnitHexagon p2S2;

	public UnitPane(ViewerModel m) {
		this.model = m;
		this.model.addListener(this);

		this.p1A1 = new UnitHexagon(new Unit(this.model.player1(), UnitType.ANT, 1), 5);
		this.p1A2 = new UnitHexagon(new Unit(this.model.player1(), UnitType.ANT, 2), 5);
		this.p1A3 = new UnitHexagon(new Unit(this.model.player1(), UnitType.ANT, 3), 5);
		this.p1B1 = new UnitHexagon(new Unit(this.model.player1(), UnitType.BEATLE, 1), 5);
		this.p1B2 = new UnitHexagon(new Unit(this.model.player1(), UnitType.BEATLE, 2), 5);
		this.p1G1 = new UnitHexagon(new Unit(this.model.player1(), UnitType.GRASSHOPPER, 1), 5);
		this.p1G2 = new UnitHexagon(new Unit(this.model.player1(), UnitType.GRASSHOPPER, 2), 5);
		this.p1G3 = new UnitHexagon(new Unit(this.model.player1(), UnitType.GRASSHOPPER, 3), 5);
		this.p1Q = new UnitHexagon(new Unit(this.model.player1(), UnitType.QUEEN), 5);
		this.p1S1 = new UnitHexagon(new Unit(this.model.player1(), UnitType.SPIDER, 1), 5);
		this.p1S2 = new UnitHexagon(new Unit(this.model.player1(), UnitType.SPIDER, 2), 5);

		this.p2A1 = new UnitHexagon(new Unit(this.model.player2(), UnitType.ANT, 1), 5);
		this.p2A2 = new UnitHexagon(new Unit(this.model.player2(), UnitType.ANT, 2), 5);
		this.p2A3 = new UnitHexagon(new Unit(this.model.player2(), UnitType.ANT, 3), 5);
		this.p2B1 = new UnitHexagon(new Unit(this.model.player2(), UnitType.BEATLE, 1), 5);
		this.p2B2 = new UnitHexagon(new Unit(this.model.player2(), UnitType.BEATLE, 2), 5);
		this.p2G1 = new UnitHexagon(new Unit(this.model.player2(), UnitType.GRASSHOPPER, 1), 5);
		this.p2G2 = new UnitHexagon(new Unit(this.model.player2(), UnitType.GRASSHOPPER, 2), 5);
		this.p2G3 = new UnitHexagon(new Unit(this.model.player2(), UnitType.GRASSHOPPER, 3), 5);
		this.p2Q = new UnitHexagon(new Unit(this.model.player2(), UnitType.QUEEN), 5);
		this.p2S1 = new UnitHexagon(new Unit(this.model.player2(), UnitType.SPIDER, 1), 5);
		this.p2S2 = new UnitHexagon(new Unit(this.model.player2(), UnitType.SPIDER, 2), 5);

		this.addRow(0, p1A1, p1A2, p1A3, p1B1, p1B2, p1G1, p1G2, p1G3, p1Q, p1S1, p1S2);
		this.addRow(1, p2A1, p2A2, p2A3, p2B1, p2B2, p2G1, p2G2, p2G3, p2Q, p2S1, p2S2);
	}

	@Override
	public void invalidated(Observable observable) {
		System.out.println("TODO: Remove from grid");
	}
}
