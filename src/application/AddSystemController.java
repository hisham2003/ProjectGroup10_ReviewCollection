package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class AddSystemController {

    @FXML
    private Text testOutput;

    @FXML
    private Button AddButton;

    @FXML
    private TextField testField;

    @FXML
    void addItem(ActionEvent event) {
    	String id=testField.getText();
    	testOutput.setText(id);
    }

   

}