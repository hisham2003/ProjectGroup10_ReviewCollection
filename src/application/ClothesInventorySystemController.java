package application;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ClothesInventorySystemController implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextField idField;

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
	private Button addInventory;

	@FXML
	private Button removeInventory;

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
	private Label totalSaleLabel;
	@FXML
	private Label totalHoldLabel;
	@FXML
	private Label totalCostLabel;
    @FXML
    private Label totalAmountLabel;

	private static final DecimalFormat df = new DecimalFormat("0.00");

	@FXML
	public void swicthToAdd(ActionEvent event) throws IOException {
		int idFieldnum = Integer.parseInt(idField.getText());
		int costFieldnum = Integer.parseInt(costField.getText());
		int saleFieldnum = Integer.parseInt(saleField.getText());
		int amountFieldnum = Integer.parseInt(amountField.getText());
		int totalCostFieldnum = amountFieldnum * costFieldnum;
		int totalSaleAmountFieldnum = amountFieldnum * saleFieldnum;

		Clothes input = new Clothes(idFieldnum, nameField.getText(), costFieldnum, saleFieldnum, amountFieldnum,
				totalCostFieldnum, totalSaleAmountFieldnum, sizeField.getText(), materialField.getText());
		table.getItems().add(input);

		int totalCost = 0;
		int totalSale = 0;
		int totalAmount=0;
		double hold = 0;

		for (Item item : table.getItems()) {
			totalCost = totalCost + item.getTotalCost();
			totalSale = totalSale + item.getTotalSalePrice();
			totalAmount=totalAmount+ item.getAmount();
			hold = hold + item.getHoldingCostClothes();
		}

		String totalHold = df.format(hold);
		totalCostLabel.setText(Integer.toString(totalCost));
		totalSaleLabel.setText(Integer.toString(totalSale));
		totalAmountLabel.setText(Integer.toString(totalAmount));
		totalHoldLabel.setText(totalHold);
	}

	// https://stackoverflow.com/questions/34857007/how-to-delete-row-from-table-column-javafx
	public void removeInventory(ActionEvent event) throws IOException {
		Item selection = table.getSelectionModel().getSelectedItem();
		table.getItems().remove(selection);
		
		int totalCost = 0;
		int totalSale = 0;
		int totalAmount=0;
		double hold = 0;

		for (Item item : table.getItems()) {
			totalCost = totalCost + item.getTotalCost();
			totalSale = totalSale + item.getTotalSalePrice();
			totalAmount=totalAmount+ item.getAmount();
			hold = hold + item.getHoldingCostClothes();
		}

		String totalHold = df.format(hold);
		totalCostLabel.setText(Integer.toString(totalCost));
		totalSaleLabel.setText(Integer.toString(totalSale));
		totalAmountLabel.setText(Integer.toString(totalAmount));
		totalHoldLabel.setText(totalHold);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// stackoverflow.com/questions/72437983/why-should-i-avoid-using-propertyvaluefactory-in-javafx
		// remember to javadoc everything

		idColumn.setCellValueFactory(data -> data.getValue().idProperty().asObject());
		nameColumn.setCellValueFactory(data -> data.getValue().nameProperty());
		costColumn.setCellValueFactory(data -> data.getValue().costProperty().asObject());
		saleColumn.setCellValueFactory(data -> data.getValue().salePriceProperty().asObject());
		amountColumn.setCellValueFactory(data -> data.getValue().amountProperty().asObject());
		totalCostColumn.setCellValueFactory(data -> data.getValue().totalCostProperty().asObject());
		totalSalePriceColumn.setCellValueFactory(data -> data.getValue().totalSalePriceProperty().asObject());
		materialColumn.setCellValueFactory(data -> data.getValue().materialProperty());
		sizeColumn.setCellValueFactory(data -> data.getValue().sizeProperty());

	}

}
