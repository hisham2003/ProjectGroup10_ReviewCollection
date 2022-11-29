package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleIntegerProperty cost;
	private SimpleIntegerProperty salePrice;
	private SimpleIntegerProperty amount;
	private SimpleIntegerProperty totalCost;
	private SimpleIntegerProperty totalSalePrice;

	public Item(int id, String name, int cost, int salePrice, int amount, int totalCost, int totalSalePrice) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.cost = new SimpleIntegerProperty(cost);
		this.salePrice = new SimpleIntegerProperty(salePrice);
		this.amount = new SimpleIntegerProperty(amount);
		this.totalCost = new SimpleIntegerProperty(totalCost);
		this.totalSalePrice = new SimpleIntegerProperty(totalSalePrice);
	}

	public int getId() {
		return id.get();
	}

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
	

	public int getCost() {
		return cost.get();
	}
	public final IntegerProperty costProperty() {
		return cost;

	}

	public void setCost(int cost) {
		this.cost.set(cost);
	}

	public int getSalePrice() {
		return salePrice.get();
	}
	public final IntegerProperty salePriceProperty() {
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

	public int getTotalCost() {
		return totalCost.get();
	}
	public final IntegerProperty totalCostProperty() {
		return totalCost;

	}

	public void setTotalCost(int totalCost) {
		this.totalCost.set(totalCost);
	}

	public int getTotalSalePrice() {
		return totalSalePrice.get();
	}
	public final IntegerProperty totalSalePriceProperty() {
		return totalSalePrice;

	}
	public void setTotalSalePrice(int totalSalePrice) {
		this.totalSalePrice.set(totalSalePrice);
	}

}
