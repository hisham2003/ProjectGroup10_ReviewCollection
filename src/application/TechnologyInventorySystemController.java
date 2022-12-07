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

public class TechnologyInventorySystemController implements Initializable {
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
	private ChoiceBox<String> typeField;
	@FXML
	private ChoiceBox<String> sizeBox;
	@FXML
	private TextField yearField;

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
	private TableColumn<Technology, String> typeColumn;
	@FXML
	private TableColumn<Technology, String> sizeColumn;
	@FXML
	private TableColumn<Technology, Integer> yearColumn;

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
	
	int idFieldNum;
	double costFieldNum;
	double saleFieldNum;
	int amountFieldNum;
	double totalCostFieldNum;
	int totalSaleAmountFieldNum;
	int yearFieldNum;
	String sizeFieldNum;

	@FXML
	public void swicthToAdd(ActionEvent event) throws IOException {

		try {
			
			idFieldNum = Integer.parseInt(idField.getText());
			costFieldNum = Double.parseDouble(costField.getText());
			saleFieldNum = Double.parseDouble(saleField.getText());
			amountFieldNum = Integer.parseInt(amountField.getText());
			totalCostFieldNum = amountFieldNum * costFieldNum;
			totalSaleAmountFieldNum = (int) (amountFieldNum * saleFieldNum);
			yearFieldNum=Integer.parseInt(yearField.getText());
			sizeFieldNum=sizeField.getText() + " " +sizeBox.getSelectionModel().getSelectedItem();
			
			Technology input = new Technology(idFieldNum, nameField.getText(), costFieldNum, saleFieldNum, amountFieldNum,
					totalCostFieldNum, totalSaleAmountFieldNum, sizeFieldNum, typeField.getSelectionModel().getSelectedItem(),yearFieldNum);
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
			totalHold = totalHold + item.getHoldingCostTech();
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
			totalHold = totalHold + item.getHoldingCostTech();
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
		typeColumn.setCellValueFactory(data -> data.getValue().typeProperty());
		sizeColumn.setCellValueFactory(data -> data.getValue().sizeTechProperty());
		yearColumn.setCellValueFactory(data -> data.getValue().yearProperty().asObject());
		
		
		//for Choice boxes
		sizeBox.getItems().add("inch");
		sizeBox.getItems().add("cm");
		typeField.getItems().add("TV");
		typeField.getItems().add("Smartphone");
		typeField.getItems().add("Appliances");
	}

}
