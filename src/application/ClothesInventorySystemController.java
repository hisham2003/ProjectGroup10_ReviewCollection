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
	private ChoiceBox<String> sizeField;

	@FXML
	private ChoiceBox<String> materialField;

	@FXML
	private Button addInventory;

	@FXML
	private Button removeInventory;

	@FXML
	private TableView<Item> table;

	@FXML
	private TableColumn<Item, Double> costColumn;

	@FXML
	private TableColumn<Item, String> nameColumn;

	@FXML
	private TableColumn<Item, Double> totalCostColumn;

	@FXML
	private TableColumn<Item, Integer> amountColumn;

	@FXML
	private TableColumn<Item, Double> totalSalePriceColumn;

	@FXML
	private TableColumn<Item, Double> saleColumn;

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
	@FXML
	private Label errorLabel;
	@FXML
	private Button escapeButton;

	private static final DecimalFormat df = new DecimalFormat("0.00");

	int idFieldnum;
	double costFieldnum;
	double saleFieldnum;
	int amountFieldnum;
	double totalCostFieldnum;
	int totalSaleAmountFieldnum;

	@FXML
	public void swicthToAdd(ActionEvent event) throws IOException {

		try {
			idFieldnum = Integer.parseInt(idField.getText());
			costFieldnum = Double.parseDouble(costField.getText());
			saleFieldnum = Double.parseDouble(saleField.getText());
			amountFieldnum = Integer.parseInt(amountField.getText());
			totalCostFieldnum = amountFieldnum * costFieldnum;
			totalSaleAmountFieldnum = (int) (amountFieldnum * saleFieldnum);
			Clothes input = new Clothes(idFieldnum, nameField.getText(), costFieldnum, saleFieldnum, amountFieldnum,
					totalCostFieldnum, totalSaleAmountFieldnum, sizeField.getSelectionModel().getSelectedItem(), materialField.getSelectionModel().getSelectedItem());
			table.getItems().add(input);
		} catch (NumberFormatException e) {
			errorLabel.setText("Only use numerical values for id,cost,sale,amount");
		}

		double totalCost = 0;
		double totalSale = 0;
		int totalAmount = 0;
		double totalHold = 0;

		for (Item item : table.getItems()) {
			totalCost = totalCost + item.getTotalCost();
			totalSale = totalSale + item.getTotalSalePrice();
			totalAmount = totalAmount + item.getAmount();
			totalHold = totalHold + item.getHoldingCostClothes();
		}
		
		String formattedCost = df.format(totalCost);
		String formattedSale = df.format(totalSale);
		String formattedHold = df.format(totalHold);

		totalCostLabel.setText(formattedCost);
		totalSaleLabel.setText(formattedSale);
		totalAmountLabel.setText(Integer.toString(totalAmount));
		totalHoldLabel.setText(formattedHold);

	}

	// https://stackoverflow.com/questions/34857007/how-to-delete-row-from-table-column-javafx
	public void removeInventory(ActionEvent event) throws IOException {
		Item selection = table.getSelectionModel().getSelectedItem();
		table.getItems().remove(selection);

		double totalCost = 0;
		double totalSale = 0;
		int totalAmount = 0;
		double totalHold = 0;

		for (Item item : table.getItems()) {
			totalCost = totalCost + item.getTotalCost();
			totalSale = totalSale + item.getTotalSalePrice();
			totalAmount = totalAmount + item.getAmount();
			totalHold = totalHold + item.getHoldingCostClothes();
		}

		String formattedCost = df.format(totalCost);
		String formattedSale = df.format(totalSale);
		String formattedHold = df.format(totalHold);

		totalCostLabel.setText(formattedCost);
		totalSaleLabel.setText(formattedSale);
		totalAmountLabel.setText(Integer.toString(totalAmount));
		totalHoldLabel.setText(formattedHold);

	}

	public void returnToMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
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
		
		
		materialField.getItems().add("Cotton");
		materialField.getItems().add("Fabric");
		materialField.getItems().add("Polyester");
		sizeField.getItems().add("S");
		sizeField.getItems().add("M");
		sizeField.getItems().add("L");
		sizeField.getItems().add("XL");

	}

}
