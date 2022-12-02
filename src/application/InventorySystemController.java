package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class InventorySystemController implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private Button removeInventory;

	@FXML
	private Button addInventory;

	@FXML
	private TableView<Item> table;

	@FXML
	private TableColumn<Item, Integer> costColumn;

	@FXML
	private TableColumn<Item, String> nameColumn;

	@FXML
	private TableColumn<Item, Integer> totalCostColumn;

	@FXML
	private TableColumn<Item, Integer> amountColumn;

	@FXML
	private TableColumn<Item, Integer> totalSalePriceColumn;

	@FXML
	private TableColumn<Item, Integer> saleColumn;

	@FXML
	private TableColumn<Item, Integer> idColumn;
	@FXML
	private TableColumn<Clothes, String> materialColumn;
	@FXML
	private TableColumn<Clothes, String> sizeColumn;
	

	@FXML
	void swicthToAdd(ActionEvent event) throws IOException {
		// from youtube video https://www.youtube.com/watch?v=hcM-R-YOKkQ
		
		Parent root = FXMLLoader.load(getClass().getResource("InventorySystemView2.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

	@FXML
	void swicthToRemove(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//stackoverflow.com/questions/72437983/why-should-i-avoid-using-propertyvaluefactory-in-javafx
		//remember to javadoc everything
		
		idColumn.setCellValueFactory(data -> data.getValue().idProperty().asObject());
		nameColumn.setCellValueFactory(data -> data.getValue().nameProperty());
		costColumn.setCellValueFactory(data -> data.getValue().costProperty().asObject());
		saleColumn.setCellValueFactory(data -> data.getValue().salePriceProperty().asObject());
		amountColumn.setCellValueFactory(data -> data.getValue().amountProperty().asObject());
		totalCostColumn.setCellValueFactory(data -> data.getValue().totalCostProperty().asObject());
		totalSalePriceColumn.setCellValueFactory(data -> data.getValue().totalSalePriceProperty().asObject());
		materialColumn.setCellValueFactory(data -> data.getValue().materialProperty());
		sizeColumn.setCellValueFactory(data -> data.getValue().sizeProperty());
		
		table.setItems(list);
	}

	ObservableList<Item> list = FXCollections.observableArrayList(
		
			new Clothes(1, "his", 3, 4, 5, 6, 2, "h", "2")
			

	);
	
	

}
