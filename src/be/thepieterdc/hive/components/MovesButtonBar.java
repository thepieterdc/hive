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
 * MovesButtonBar component. Contains the 5 MovesButtons.
 * <p>
 * Created at 17/03/16 17:05
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
final class MovesButtonBar extends HBox implements InvalidationListener {
	private final MovesButton btnBackward = new MovesButton(Svg.MOVEBUTTON_BACKWARD);
	private final MovesButton btnBegin = new MovesButton(Svg.MOVEBUTTON_BEGIN);
	private final MovesButton btnEnd = new MovesButton(Svg.MOVEBUTTON_END);
	private final MovesButton btnForward = new MovesButton(Svg.MOVEBUTTON_FORWARD);
	private final MovesButton btnPlay = new MovesButton(Svg.MOVEBUTTON_PLAY);

	private final ViewerModel model;

	private boolean playing;

	private final Timeline timeline;

	/**
	 * MovesButtonBar constructor.
	 * @param m the model
	 */
	MovesButtonBar(ViewerModel m) {
		if(m == null) {
			throw new IllegalArgumentException("Parameter \"m\" is null.");
		}
		this.model = m;
		this.model.addListener(this);

		this.btnBackward.setOnAction(e -> this.model.move(this.model.moveIndex() - 1));
		this.btnBegin.setOnAction(e -> this.model.move(0));
		this.btnEnd.setOnAction(e -> this.model.move(this.model.totalMoves() - 1));
		this.btnForward.setOnAction(e -> this.model.move(this.model.moveIndex() + 1));
		this.btnPlay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				btnPlay.setGraphic(Svg.MOVEBUTTON_STOP.path());
				playing = true;
				timeline.setCycleCount(model.totalMoves() - model.moveIndex() - 1);
				timeline.play();
			}
		});

		this.timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), e -> this.model.move(this.model.moveIndex() + 1)));
		this.timeline.setOnFinished(e -> {
			this.btnPlay.setGraphic(Svg.MOVEBUTTON_PLAY.path());
			this.playing = false;
		});

		this.getChildren().addAll(this.btnBegin, this.btnBackward, this.btnPlay, this.btnForward, this.btnEnd);
	}

	@Override
	public void invalidated(Observable observable) {
		this.btnBackward.setDisable(!this.playing && this.model.moveIndex() - 1 < 0);
		this.btnBegin.setDisable(!this.playing && this.model.moveIndex() - 1 < 0);
		this.btnEnd.setDisable(!this.playing && this.model.moveIndex() + 1 > this.model.totalMoves() - 1);
		this.btnForward.setDisable(!this.playing && this.model.moveIndex() + 1 > this.model.totalMoves() - 1);
	}

	@Override
	public String toString() {
		return "MovesButtonBar[playing=" + this.playing + ']';
	}
}
