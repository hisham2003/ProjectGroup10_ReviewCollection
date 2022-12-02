package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AddSystemController implements Initializable {

	@FXML
	private Text testOutput;

	@FXML
	private Button AddButton;

	@FXML
	private TextField testField;

	@FXML
	private ChoiceBox<String> typeChoiceBox;

	@FXML
	void addItem(ActionEvent event) {

	}

	private String[] types = { "Clothes", "item" };
	
	//www.youtube.com/watch?v=hwCbXOM4_Qc for below code
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		typeChoiceBox.getItems().addAll(types);
		typeChoiceBox.setOnAction(this::changeType);
		
	}
	public void changeType(ActionEvent event) {
		String test = typeChoiceBox.getValue();
		testOutput.setText(test);
	}
}
