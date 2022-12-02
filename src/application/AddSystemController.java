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

public class AddSystemController implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextField idField;

	@FXML
	private ChoiceBox<String> typeChoiceBox;

	@FXML
	private TextField saleField;

	@FXML
	private Button AddButton;

	@FXML
	private TextField nameField;

	@FXML
	private TextField costField;

	@FXML
	private TextField amountField;

	@FXML
	private TextField sizeField;

	@FXML
	private TextField materialField;

	@FXML
	void addItem(ActionEvent event) throws IOException {
		int idFieldnum = Integer.parseInt(idField.getText());
		int costFieldnum = Integer.parseInt(costField.getText());
		int saleFieldnum = Integer.parseInt(saleField.getText());
		int amountFieldnum = Integer.parseInt(amountField.getText());
		int totalCostFieldnum = amountFieldnum * costFieldnum;
		int totalSaleAmountFieldnum = amountFieldnum * saleFieldnum;
		Clothes input = new Clothes(idFieldnum, nameField.getText(), costFieldnum, saleFieldnum, amountFieldnum,
				totalCostFieldnum, totalSaleAmountFieldnum, sizeField.getText(), materialField.getText());

		// https://www.youtube.com/watch?v=wxhGKR3PQpo&list=PLjghsYuMRzSE65_LwnEmou1WMUXl7GW_f&index=20
		FXMLLoader loader = new FXMLLoader(getClass().getResource("InventorySystemView1.fxml"));
		root = loader.load();

		InventorySystemController InventorySystemController = loader.getController();
		InventorySystemController.displayTest(input);

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	private String[] types = { "Clothes", "item" };

	// www.youtube.com/watch?v=hwCbXOM4_Qc for below code
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		typeChoiceBox.getItems().addAll(types);
		typeChoiceBox.setOnAction(this::changeType);

	}

	public void changeType(ActionEvent event) {
		// for choice box

	}

}
