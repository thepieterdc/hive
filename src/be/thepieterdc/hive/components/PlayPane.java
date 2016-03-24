package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.Orientation;
import be.thepieterdc.hive.helpers.HexCoordinate;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;

/**
 * Description here
 * <p>
 * Created at 19/03/16 22:17
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class PlayPane extends StackPane implements InvalidationListener {
	private final ViewerModel model;

	public PlayPane(ViewerModel m) {
		this.model = m;
		this.model.addListener(this);
	}

	@Override
	public void invalidated(Observable observable) {
		this.getChildren().clear();
		Group g = new Group();
		/*
		HashMap<HexCoordinate, Node> state = this.model.boardState().coordinates();
		for (Map.Entry<HexCoordinate, Node> gridCoordinateNodeEntry : state.entrySet()) {
			HexCoordinate c = gridCoordinateNodeEntry.getKey();
			Node h = gridCoordinateNodeEntry.getValue();
			h.setTranslateX(c.x()*5);
			h.setTranslateY(c.y()*5);
			h.setOnMouseClicked(event -> System.out.println(c));
			if(h instanceof UnitHexagon) {
				((UnitHexagon) h).scale(5);
				System.out.println(HexCoordinate.fromOrientation(c, Orientation.RIGHTUPPER));
				System.out.println("Unit hex:");
				System.out.println(((UnitHexagon) h).width());
				System.out.println(((UnitHexagon) h).height());
			} else if(h instanceof DefaultHexagon) {
				System.out.println("Regular hex:");
				h.setScaleX(5);
				h.setScaleY(5);
				System.out.println(((DefaultHexagon) h).width());
				System.out.println(((DefaultHexagon) h).height());
			}
			g.getChildren().add(h);
		}
		*/
		HexCoordinate test = new HexCoordinate(0, 0);
		for(int i = 0; i < 5; i++) {
			DefaultHexagon h = new DefaultHexagon();
			h.setTranslateX(test.x()*5);
			h.setTranslateY(test.y()*5);
			h.setScaleX(5);
			h.setScaleY(5);
			g.getChildren().add(h);
			test = HexCoordinate.fromOrientation(test, Orientation.LEFTUPPER);
		}
		this.getChildren().add(g);
	}
}