package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddSystemController extends InventorySystemController implements Initializable  {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private Text testOutput;

	@FXML
	private Button AddButton;

	@FXML
	private TextField testField;

	@FXML
	private ChoiceBox<String> typeChoiceBox;

	@FXML
	void addItem(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("InventorySystemView1.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		Clothes cloth = new Clothes(1,"his",2,3,4,5,6,"h","g");
		
		
		
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
