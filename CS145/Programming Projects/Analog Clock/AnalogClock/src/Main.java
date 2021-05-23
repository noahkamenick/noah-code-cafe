import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.time.ZonedDateTime;
import java.util.Scanner;

/**
 * Java Analog Clock. This is the main JavaFX class for our Clock program.
 * Contains all methods needed to run the clock.
 * 
 * @author Ben Wallen
 * @author Noah Kamenick
 * @version 1
 */
public class Main extends Application {
	FlowPane flowPaneObject;
	Line secondHand;
	Line minuteHand;
	Line hourHand;
	Circle clock;
	Text one;
	Text two;
	Text three;
	Text four;
	Text five;
	Text six;
	Text seven;
	Text eight;
	Text nine;
	Text ten;
	Text eleven;
	Text twelve;
	Text setColorLabel;
	Font font;
	Font colorPickFont;
	Button setTime;
	Button setCurrentTimeButton;
	CheckBox check;
	TextField userInput;
	Timeline hourTimeline;
	Timeline minuteTimeline;
	Timeline secondTimeline;
	Rotate hourHandRotate;
	ZonedDateTime time;
	ColorPicker colorPick;
	File file;
	AudioClip audioClip;

	/**
	 * clockShapeCreation() creates the clock using a variety of shapes. This
	 * includes the clock circle and the text around the clock -- however, it does
	 * not initialize the hands on the clock.
	 */
	public void clockShapeCreation() {
		clock.setTranslateX(275);
		clock.setTranslateY(80);
		clock.setFill(Color.WHITESMOKE);
		clock.setRadius(150);

		// Numbers

		font = new Font("Comic Sans MS", 25);

		one = new Text("1");
		one.setFont(font);
		one.setTranslateX(330);
		one.setTranslateY(-28);

		two = new Text("2");
		two.setFont(font);
		two.setTranslateX(380);
		two.setTranslateY(25);

		three = new Text("3");
		three.setFont(font);
		three.setTranslateX(400);
		three.setTranslateY(87);

		four = new Text("4");
		four.setFont(font);
		four.setTranslateX(385);
		four.setTranslateY(155);

		five = new Text("5");
		five.setFont(font);
		five.setTranslateX(337);
		five.setTranslateY(203);

		six = new Text("6");
		six.setFont(font);
		six.setTranslateX(263);
		six.setTranslateY(225);

		seven = new Text("7");
		seven.setFont(font);
		seven.setTranslateX(190);
		seven.setTranslateY(203);

		eight = new Text("8");
		eight.setFont(font);
		eight.setTranslateX(150);
		eight.setTranslateY(155);

		nine = new Text("9");
		nine.setFont(font);
		nine.setTranslateX(127);
		nine.setTranslateY(87);

		ten = new Text("10");
		ten.setFont(font);
		ten.setTranslateX(141);
		ten.setTranslateY(25);

		eleven = new Text("11");
		eleven.setFont(font);
		eleven.setTranslateX(193);
		eleven.setTranslateY(-28);

		twelve = new Text("12");
		twelve.setFont(font);
		twelve.setTranslateX(264);
		twelve.setTranslateY(-40);
	}

	/**
	 * buttonCreation() creates the buttons features on the clock. This includes the
	 * start/stop button, the setTime text field, the colorpicker, and the
	 * setCurrenTimeButton.
	 */
	public void buttonCreation() {
		/**
		 * this is funny, we actually broke JavaFX. 100% a bug. From what I understand,
		 * when the checkbox is created a background of null is created from the parent
		 * class, which defaults coincidentally to Color.WHITESMOKE or something similar
		 * that we used. might have a fix here, otherwise a simple colorswap works as
		 * this is a javafx problem
		 * 
		 * update - the parent region class says in the api docs: "fill - Any Paint. If
		 * null, the value Color.TRANSPARENT is used." so this is most likely the error.
		 * 
		 * update 2 - my below attempts to fix only changed the check background as
		 * expected, did some more digging and discovered it was the same issue but with
		 * flowPanel calling null. Guess it just blows up when a button is added. should
		 * work now.
		 * 
		 * SetCurrentTime button created, translated. Event handler set to the
		 * processCurrent function colorPick button created, translated. Event hander
		 * linked up to the processColor function. New font for setColorLabel,
		 * translated, font and fill set.
		 * 
		 * 
		 */
		check = new CheckBox("Start / Stop Clock");
		check.setOnAction(this::processAction);
		check.setTranslateX(450);
		setTime = new Button("Set Time");
		setTime.setOnAction(this::processAction);
		setTime.setTranslateX(450);
		setTime.setTranslateY(25);
		setCurrentTimeButton = new Button("Set to Current Time");
		setCurrentTimeButton.setOnAction(this::processCurrent);
		setCurrentTimeButton.setTranslateX(450);
		setCurrentTimeButton.setTranslateY(100);
		colorPick = new ColorPicker(Color.DARKGRAY);
		colorPick.setTranslateX(450);
		colorPick.setTranslateY(150);
		colorPick.setOnAction(this::processColor);
		colorPickFont = new Font("Comic Sans MS", 12);
		setColorLabel = new Text("Set Background Color");
		setColorLabel.setTranslateX(445);
		setColorLabel.setTranslateY(145);
		setColorLabel.setFont(colorPickFont);
		setColorLabel.setFill(Color.WHITE);
		userInput = new TextField("Enter desired time here");
		userInput.setTranslateX(450);
		userInput.setTranslateY(65);
		// check.setBackground(new Background(new BackgroundFill(Color.BLACK,
		// CornerRadii.EMPTY, Insets.EMPTY)));
		// check.setStyle("-fx-background-color: #FFFFFF;");
	}

	/**
	 * setTime() is the method used for setting the time to what the user inputs in
	 * the text field This is accomplished by exploding the user's string and
	 * scanning it for the next integer. Formats taken are HH MM SS, and the more
	 * traditional H:MM:SS.
	 */
	public void setTime() {
		// FORMAT: 8:34:33 // H:MM:SS
		// Needs testing, I think this should work though.
		String time = userInput.getText();
		String timeFixed = time.replace(":", " ");
		Scanner s = new Scanner(timeFixed);
		hourTimeline.jumpTo(Duration.hours(s.nextInt()));
		minuteTimeline.jumpTo(Duration.minutes(s.nextInt()));
		secondTimeline.jumpTo(Duration.seconds(s.nextInt()));
		s.close();
	}

	/**
	 * 
	 * This method sets the 3 hands to the current time based on time information
	 * provided by the ZonedDateTime object
	 * 
	 */

	public void setCurrentTime() {

		// Zone-Based Time Setting

		time = ZonedDateTime.now();
		hourTimeline.jumpTo(Duration.hours(time.getHour()));
		minuteTimeline.jumpTo(Duration.minutes(time.getMinute()));
		secondTimeline.jumpTo(Duration.seconds(time.getSecond()));

	}

	/**
	 * This method declares and controls the second hand on the clock. Furthermore,
	 * properties like stroke and color of the line are setup. The clock hands are
	 * controlled by an individual timeline, with keyFrames set at angleproperties
	 * zero and 360 - allowing for full range of motion. Animation set to
	 * indefinite.
	 * 
	 * (Careful messing with this - this code can be difficult.)
	 */
	public void secondHand() {
		secondHand.setStroke(Color.RED);
		secondHand.setStrokeWidth(1.75);
		Rotate secondHandRotate = new Rotate();
		// rotate around the beginning of the line, not the middle of the line
		secondHandRotate.pivotXProperty().bind(secondHand.startXProperty());
		secondHandRotate.pivotYProperty().bind(secondHand.startYProperty());
		secondHand.getTransforms().add(secondHandRotate);
		/**
		 * Fix - this new timeline takes two keyvalues (one at angleProperty zero,
		 * another at 360) and tells it to reach the second KeyValue by sixty seconds.
		 * This allows for smoother motion as well.
		 */
		secondTimeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(secondHandRotate.angleProperty(), 0)),
				new KeyFrame(Duration.seconds(60), new KeyValue(secondHandRotate.angleProperty(), 360)));
		secondTimeline.setCycleCount(Animation.INDEFINITE);
		secondTimeline.play();
	}

	/**
	 * This method declares and controls the minute hand on the clock. Furthermore,
	 * properties like stroke and color of the line are setup. The clock hands are
	 * controlled by an individual timeline, with keyFrames set at angleproperties
	 * zero and 360 - allowing for full range of motion. Animation set to
	 * indefinite.
	 * 
	 * (Careful messing with this - this code can be difficult.)
	 */
	public void minuteHand() {
		minuteHand.setStroke(Color.BLACK);
		minuteHand.setStrokeWidth(3);
		Rotate minuteHandRotate = new Rotate();
		minuteHandRotate.pivotXProperty().bind(minuteHand.startXProperty());
		minuteHandRotate.pivotYProperty().bind(minuteHand.startYProperty());
		minuteHand.getTransforms().add(minuteHandRotate);
		minuteTimeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(minuteHandRotate.angleProperty(), 0)),
				new KeyFrame(Duration.minutes(60), new KeyValue(minuteHandRotate.angleProperty(), 360)));
		minuteTimeline.setCycleCount(Animation.INDEFINITE);
		minuteTimeline.play();
	}

	/**
	 * This method declares and controls the hour hand on the clock. Furthermore,
	 * properties like stroke and color of the line are setup. The clock hands are
	 * controlled by an individual timeline, with keyFrames set at angleproperties
	 * zero and 360 - allowing for full range of motion. Animation set to
	 * indefinite.
	 * 
	 * (Careful messing with this - this code can be difficult.)
	 */
	public void hourHand() {
		hourHand.setStroke(Color.BLACK);
		hourHand.setStrokeWidth(3);
		hourHandRotate = new Rotate();
		hourHandRotate.pivotXProperty().bind(hourHand.startXProperty());
		hourHandRotate.pivotYProperty().bind(hourHand.startYProperty());
		hourHand.getTransforms().add(hourHandRotate);
		hourTimeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(hourHandRotate.angleProperty(), 0)),
				new KeyFrame(Duration.hours(12), new KeyValue(hourHandRotate.angleProperty(), 360)));
		hourTimeline.setCycleCount(Animation.INDEFINITE);
		hourTimeline.play();
	}

	/**
	 * Simple method for stopping the clock. Makes use of timelines previously
	 * implemented.
	 */
	public void stopClock() {
		hourTimeline.pause();
		minuteTimeline.pause();
		secondTimeline.pause();
	}

	/**
	 * Simple method for resuming the clock. Makes use of timelines previously
	 * implemented.
	 */
	public void resumeClock() {
		hourTimeline.play();
		minuteTimeline.play();
		secondTimeline.play();
	}

	/**
	 * Legacy DST button feature. This would allow the user to push or move back the
	 * clock, if DST was a factor. With the implementation of the setTime function
	 * this became redundant, and pretty useless on an analog clock.
	 * 
	 * public void DSTButton() { System.out.println(hourTimeline.getCurrentTime());
	 * hourTimeline.jumpTo(Duration.hours(hourTimeline.getCycleDuration() +
	 * Duration.hours(1))); }
	 * 
	 * public void noDSTButton() { hourTimeline.jumpTo(Duration.hours(0)); }
	 */

	/**
	 * Start function. This initializes the program and adds all parts of the clock
	 * to a visual window.
	 */
	@Override
	public void start(Stage primaryStage) {
		Stage window = primaryStage;
		window.setTitle("Analog Clock");
		clock = new Circle();
		clockShapeCreation();
		buttonCreation();
		// add three lines (hour, minute second), each with different strokes
		// add to group and window
		// starting point of each line should be the center of the circle
		secondHand = new Line(275, 80, 275, -65);
		minuteHand = new Line(275, 80, 275, -65);
		hourHand = new Line(275, 80, 275, 0);
		secondHand();
		minuteHand();
		hourHand();
		Group clockParts = new Group(clock, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve,
				secondHand, minuteHand, hourHand, check, setTime, setCurrentTimeButton, setColorLabel, colorPick,
				userInput);
		// clockParts.setTranslateX(50);
		flowPaneObject = new FlowPane();
		// fix for button randomness
		flowPaneObject
				.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		flowPaneObject.getChildren().add(clockParts);
		// something is overwriting the scene background
		Scene scene1 = new Scene(flowPaneObject, 600, 305, Color.WHITESMOKE);
		setCurrentTime(); // set hands to current time on load
		file = new File("pop.wav"); //Load file
		audioClip = new AudioClip(file.toURI().toString()); //Create new Audio Clip
		window.setScene(scene1);
		window.show();
	}

	/**
	 * ActionEvent handler. This calls the appropriate action, based on what
	 * triggers it (checkbox/buttonclick)
	 * 
	 * @param event is the event being processed
	 */
	private void processAction(ActionEvent event) {
		if (check.isSelected()) {
			stopClock();
		} else if (check.isSelected() == false) {
			resumeClock();
		}
		if (event.getSource() == setTime) {
			setTime();
		}
	}

	/**
	 * 
	 * This method takes in an event ActionEvent object to set the current time when
	 * the setCurrentTimeButton is pressed
	 * 
	 * @param event is the event being processed
	 */

	private void processCurrent(ActionEvent event) {

		setCurrentTime();

	}

	/**
	 * 
	 * This method takes in an event ActionEvent object to set the current time when
	 * a color is chosen from the colorPick ColorPicker. That color value is set to
	 * the flowPaneObjects' background fill. Plays sound loaded in.
	 * 
	 * @param event is the event being processed
	 */

	private void processColor(ActionEvent event) {

		Color c = colorPick.getValue();

		flowPaneObject.setBackground(new Background(new BackgroundFill(c, CornerRadii.EMPTY, Insets.EMPTY)));
		
		audioClip.stop();
		
		audioClip.play();
	}

	/**
	 * Main java function. Launches the program.
	 * 
	 * @param args launch arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
