package be.thepieterdc.hive.components;

import be.thepieterdc.hive.data.Svg;
import be.thepieterdc.hive.models.ViewerModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * A bar that contains the MoveButtons.
 * <p>
 * Created at 17/03/16 17:05
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class MovesButtonBar extends HBox implements InvalidationListener {
	private final ViewerModel model;

	private final MovesButton btnBackward = new MovesButton(Svg.MOVEBUTTON_BACKWARD);
	private final MovesButton btnBegin = new MovesButton(Svg.MOVEBUTTON_BEGIN);
	private final MovesButton btnEnd = new MovesButton(Svg.MOVEBUTTON_END);
	private final MovesButton btnForward = new MovesButton(Svg.MOVEBUTTON_FORWARD);
	private final MovesButton btnPlay = new MovesButton(Svg.MOVEBUTTON_PLAY);

	private final Timeline timeline;

	public MovesButtonBar(ViewerModel m) {
		this.model = m;
		this.model.addListener(this);

		this.btnBegin.setOnAction(e -> this.model.move(0));
		this.btnEnd.setOnAction(e -> this.model.move(this.model.totalMoves()-1));
		this.btnNext.setOnAction(e -> this.model.move(this.model.moveIndex()+1));
		this.btnPrevious.setOnAction(e -> this.model.move(this.model.moveIndex()-1));
		this.btnPlay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				btnPlay.setGraphic(Svg.MOVEBUTTON_STOP.path());
				timeline.setCycleCount(model.totalMoves()-model.moveIndex()-1);
			}
		});

		this.timeline = new Timeline(new KeyFrame(Duration.seconds(1)));

		this.getChildren().addAll(this.btnBegin, this.btnPrevious, this.btnPlay, this.btnNext, this.btnEnd);
	}

	@Override
	public void invalidated(Observable observable) {
		this.btnBegin.setDisable(this.model.moveIndex()-1 < 0);
		this.btnEnd.setDisable(this.model.moveIndex()+1 > this.model.totalMoves()-1);
		this.btnNext.setDisable(this.model.moveIndex()+1 > this.model.totalMoves()-1);
		this.btnPrevious.setDisable(this.model.moveIndex()-1 < 0);
	}
}
