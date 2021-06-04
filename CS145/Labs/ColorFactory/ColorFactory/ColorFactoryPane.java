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
	private FlowPane centerPane;
	private CheckBox boldCheckBox, italicCheckBox, fontCheckBox;
	private Font font;
	
	public ColorFactoryPane(){
		setupCenterPane();
		setupTopPane();
		setupBottomPane();
		setupRightPane();	
		setupLeftPane();
			
	}
	private void setupCenterPane(){
		//Task #2 item 2.
	}
	private void setupTopPane(){
		//Task #2 item 3.
	}
	private void setupBottomPane(){
		//Task #4
	}
	
	private void setupRightPane(){
		//Task #5
	}
	
	private void setupLeftPane(){
		//Task #6
	}
	
	private void processAction(ActionEvent event){
		//Task #3
		//Task #4 item 2.
		//Task #5 item 2.
		//Task #6 item 2.

	}
}
