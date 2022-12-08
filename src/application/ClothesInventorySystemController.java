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

/**
 * The controller for the clothes inventory System that handles most of the
 * Initializations of the properties of the scene and handles errors as well
 * 
 * @author HishamSO
 *
 */
public class ClothesInventorySystemController implements Initializable {
	private Stage stage;
	private Scene scene;
	private int idFieldNum;
	private double costFieldNum;
	private double saleFieldNum;
	private int amountFieldNum;
	private double totalCostFieldNum;
	private int totalSaleAmountFieldNum;
	private static final DecimalFormat df = new DecimalFormat("0.00");

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

	/**
	 * Handles the "Add" button event and adds a new item to the table. has a
	 * numberFormatException to prevent letters or characters
	 * 
	 * @param event
	 * @throws IOException 
	 */
	@FXML
	public void swicthToAdd(ActionEvent event) throws IOException {

		try {
			idFieldNum = Integer.parseInt(idField.getText());
			costFieldNum = Double.parseDouble(costField.getText());
			saleFieldNum = Double.parseDouble(saleField.getText());
			amountFieldNum = Integer.parseInt(amountField.getText());
			totalCostFieldNum = (int) (amountFieldNum * costFieldNum);
			totalSaleAmountFieldNum = (int) (amountFieldNum * saleFieldNum);

			Clothes input = new Clothes(idFieldNum, nameField.getText(), costFieldNum, saleFieldNum, amountFieldNum,
					totalCostFieldNum, totalSaleAmountFieldNum, sizeField.getSelectionModel().getSelectedItem(),
					materialField.getSelectionModel().getSelectedItem());
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

	/**
	 * Handles the "Remove" button event and removes an item from the table.
	 * 
	 * @param event 
	 * @throws IOException 
	 */
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

	/**
	 * Returns user to main main after button is clicked
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void returnToMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the FXML file has been loaded. initializes the columns of the table utilizing
	 * properties initializes the choice boxes utilized ideas and code from
	 * stackoverflow.com/questions/72437983/why-should-i-avoid-using-propertyvaluefactory-in-javafx
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

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
