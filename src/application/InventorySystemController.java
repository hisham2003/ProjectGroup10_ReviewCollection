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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
// used this video for this tablevie stuff https://www.youtube.com/watch?v=vAmyTJyFXe4
public class InventorySystemController implements Initializable{
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
	private TableColumn<Item,Integer> costColumn;

	@FXML
	private TableColumn<Item,String> nameColumn;

	@FXML
	private TableColumn<Item,Integer> totalCostColumn;

	@FXML
	private TableColumn<Item,Integer> amountColumn;

	@FXML
	private TableColumn<Item,Integer> totalSalePriceColumn;

	@FXML
	private TableColumn<Item,Integer> saleColumn;

	@FXML
	private TableColumn<Item,Integer> idColumn;
	
	
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
		idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
		costColumn.setCellValueFactory(new PropertyValueFactory<>("Cost"));
		saleColumn.setCellValueFactory(new PropertyValueFactory<>("SalePrice"));
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("Amount"));
		totalCostColumn.setCellValueFactory(new PropertyValueFactory<>("TotalCost"));
		totalSalePriceColumn.setCellValueFactory(new PropertyValueFactory<>("TotalSalePrice"));
		
		table.setItems(list);
	}
	ObservableList<Item> list=FXCollections.observableArrayList(
			new Item(1,"his",3,4,5,6,2)
			);
		
	
	

}
