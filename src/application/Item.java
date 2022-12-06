package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleDoubleProperty cost;
	private SimpleDoubleProperty salePrice;
	private SimpleIntegerProperty amount;
	private SimpleDoubleProperty totalCost;
	private SimpleDoubleProperty totalSalePrice;

	public Item(int id, String name, double cost, double salePrice, int amount, double totalCost, double totalSalePrice) {
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.cost = new SimpleDoubleProperty(cost);
		this.salePrice = new SimpleDoubleProperty(salePrice);
		this.amount = new SimpleIntegerProperty(amount);
		this.totalCost = new SimpleDoubleProperty(totalCost);
		this.totalSalePrice = new SimpleDoubleProperty(totalSalePrice);
	}

//could not put this in clothes since it would not wor find out why
	public double getHoldingCostClothes() {
		return 0.15 * getAmount();
	}
	public double getHoldingCostTech() {
		return 0.20 * getAmount();
	}

	public int getId() {
		return id.get();
	}

// used code from  https://stackoverflow.com/questions/72437983/why-should-i-avoid-using-propertyvaluefactory-in-javafx
	public final IntegerProperty idProperty() {
		return id;

	}

	public void setId(int id) {
		this.id.set(id);
	}

	public String getName() {
		return name.get();
	}

	public final StringProperty nameProperty() {
		return name;

	}

	public void setName(String name) {
		this.name.set(name);
	}

	public double getCost() {
		return cost.get();
	}

	public final DoubleProperty costProperty() {
		return cost;

	}

	public void setCost(int cost) {
		this.cost.set(cost);
	}

	public double getSalePrice() {
		return salePrice.get();
	}

	public final DoubleProperty salePriceProperty() {
		return salePrice;

	}

	public void setSalePrice(int salePrice) {
		this.salePrice.set(salePrice);
	}

	public int getAmount() {
		return amount.get();
	}

	public final IntegerProperty amountProperty() {
		return amount;

	}

	public void setAmount(int amount) {
		this.amount.set(amount);
	}

	public double getTotalCost() {
		return totalCost.get();
	}

	public final DoubleProperty totalCostProperty() {
		return totalCost;

	}

	public void setTotalCost(int totalCost) {
		this.totalCost.set(totalCost);
	}

	public double getTotalSalePrice() {
		return totalSalePrice.get();
	}

	public final DoubleProperty totalSalePriceProperty() {
		return totalSalePrice;

	}

	public void setTotalSalePrice(int totalSalePrice) {
		this.totalSalePrice.set(totalSalePrice);
	}

	

}
