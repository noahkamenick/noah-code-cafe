package application;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ColorFactoryPane extends BorderPane {
	private Button redButton, orangeButton, yellowButton;
	private RadioButton greenButton, blueButton, cyanButton;
	private ToggleGroup rbGroup;
	private TextField input;
	private Label instructions;
	private Text output;
	private FlowPane centerPane, topPane;
	private CheckBox boldCheckBox, italicCheckBox, fontCheckBox;
	private Font font;

	public ColorFactoryPane() {
		setupCenterPane();
		setupTopPane();
		setupBottomPane();
		setupRightPane();
		setupLeftPane();

	}

	private void setupCenterPane() {
		font = new Font("Helvetica", 15);
		output = new Text(
				"Button change panel color, \nradio buttons change text color, \ncheck boxes formats text output");
		output.setFont(font);
		output.setFill(Color.PURPLE);

		centerPane = new FlowPane(output);

		centerPane.setAlignment(Pos.CENTER);

		this.setCenter(centerPane);

	}

	private void setupTopPane() {
		instructions = new Label("Type something in and hit enter");
		input = new TextField();
		input.setOnAction(this::processAction);

		topPane = new FlowPane(instructions, input);

		topPane.setAlignment(Pos.CENTER);

		topPane.setHgap(10);

		this.setTop(topPane);

	}

	private void setupBottomPane() {
		boldCheckBox = new CheckBox("Bold");
		italicCheckBox = new CheckBox("Italic");
		fontCheckBox = new CheckBox("Change Font Size");

		boldCheckBox.setOnAction(this::processAction);
		italicCheckBox.setOnAction(this::processAction);
		fontCheckBox.setOnAction(this::processAction);

		FlowPane bttm = new FlowPane(boldCheckBox, italicCheckBox, fontCheckBox);
		bttm.setAlignment(Pos.CENTER);
		bttm.setHgap(10);

		this.setBottom(bttm);

	}

	private void setupRightPane() {
		greenButton = new RadioButton("Green");
		blueButton = new RadioButton("Blue");
		cyanButton = new RadioButton("Cyan");

		greenButton.setStyle("-fx-text-fill: green");
		blueButton.setStyle("-fx-text-fill: blue");
		cyanButton.setStyle("-fx-text-fill: cyan");

		greenButton.setOnAction(this::processAction);
		blueButton.setOnAction(this::processAction);
		cyanButton.setOnAction(this::processAction);

		rbGroup = new ToggleGroup();

		greenButton.setToggleGroup(rbGroup);
		blueButton.setToggleGroup(rbGroup);
		cyanButton.setToggleGroup(rbGroup);

		VBox radios = new VBox(greenButton, blueButton, cyanButton);

		radios.setSpacing(20);

		radios.setPadding(new Insets(20, 20, 10, 10));

		this.setRight(radios);

	}

	private void setupLeftPane() {
		redButton = new Button("Red");
		orangeButton = new Button("Orange");
		yellowButton = new Button("Yellow");

		redButton.setStyle("-fx-background-color: red");
		orangeButton.setStyle("-fx-background-color: orange");
		yellowButton.setStyle("-fx-background-color: yellow");

		redButton.setOnAction(this::processAction);
		orangeButton.setOnAction(this::processAction);
		yellowButton.setOnAction(this::processAction);

		VBox buttons = new VBox(redButton, orangeButton, yellowButton);

		buttons.setSpacing(20);

		buttons.setPadding(new Insets(20, 20, 10, 10));

		this.setLeft(buttons);

	}

	private void processAction(ActionEvent event) {

		FontWeight fontWeight = FontWeight.NORMAL;

		FontPosture fontPosture = FontPosture.REGULAR;

		String fontFamily = "Helvetica";

		int fontSize = 25;

		// Task #4 item 2.
		if (boldCheckBox.isSelected()) {
			fontWeight = FontWeight.BOLD;
		}

		if (italicCheckBox.isSelected()) {
			fontPosture = FontPosture.ITALIC;
		}

		if (fontCheckBox.isSelected()) {
			fontSize = 30;
		}

		// Task #5 item 2.

		if (greenButton.isSelected()) {

			output.setFill(Color.GREEN);

		}

		else if (blueButton.isSelected()) {

			output.setFill(Color.BLUE);
		}

		else if (cyanButton.isSelected()) {

			output.setFill(Color.CYAN);

		}

		// Task #6 item 2.

		if (redButton.isFocused()) {

			centerPane.setStyle("-fx-background-color: red");

		}

		else if (orangeButton.isFocused()) {

			centerPane.setStyle("-fx-background-color: orange");
		}

		else if (yellowButton.isFocused()) {

			centerPane.setStyle("-fx-background-color: yellow");

		}

		font = Font.font(fontFamily, fontWeight, fontPosture, fontSize);

		output.setFont(font);

		output.setText(input.getText());

	}

}
