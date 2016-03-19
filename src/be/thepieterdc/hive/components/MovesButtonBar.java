package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.Svg;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.HBox;

/**
 * A bar that contains the MoveButtons.
 * <p>
 * Created at 17/03/16 17:05
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class MovesButtonBar extends HBox implements InvalidationListener {
	private final ViewerModel model;

	private final MovesButton btnBegin = new MovesButton(Svg.MOVEBUTTON_BEGIN);
	private final MovesButton btnPrevious = new MovesButton(Svg.MOVEBUTTON_PREVIOUS);
	private final MovesButton btnPlay = new MovesButton(Svg.MOVEBUTTON_PLAY);
	private final MovesButton btnNext = new MovesButton(Svg.MOVEBUTTON_NEXT);
	private final MovesButton btnEnd = new MovesButton(Svg.MOVEBUTTON_END);

	/**
	 * MovesButtonBar constructor.
	 * @param m the model
	 */
	public MovesButtonBar(ViewerModel m) {
		this.model = m;
		this.model.addListener(this);

		this.btnBegin.setOnAction(event -> model.move(0));
		this.btnPrevious.setOnAction(event -> model.move(model.moveIndex()-1));
		this.btnNext.setOnAction(event -> model.move(model.moveIndex()+1));
		this.btnEnd.setOnAction(event -> model.move(model.totalMoves()-1));

		this.getChildren().addAll(this.btnBegin, this.btnPrevious, this.btnPlay, this.btnNext, this.btnEnd);
	}

	@Override
	public void invalidated(Observable observable) {
		this.btnBegin.setDisable(this.model.moveIndex()-1 < 0);
		this.btnPrevious.setDisable(this.model.moveIndex()-1 < 0);
		this.btnNext.setDisable(this.model.moveIndex()+1 > this.model.totalMoves()-1);
		this.btnEnd.setDisable(this.model.moveIndex()+1 > this.model.totalMoves()-1);
	}
}
