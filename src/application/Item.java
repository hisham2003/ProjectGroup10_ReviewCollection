package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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

	public void setId(int id) {
		this.id = new SimpleIntegerProperty(id);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}

	public int getCost() {
		return cost.get();
	}

	public void setCost(int cost) {
		this.cost =  new SimpleIntegerProperty(cost);
	}

	public int getSalePrice() {
		return salePrice.get();
	}

	public void setSalePrice(int salePrice) {
		this.salePrice =  new SimpleIntegerProperty(salePrice);
	}

	public int getAmount() {
		return amount.get();
	}

	public void setAmount(int amount) {
		this.amount =  new SimpleIntegerProperty(amount);
	}

	public int getTotalCost() {
		return totalCost.get();
	}

	public void setTotalCost(int totalCost) {
		this.totalCost =  new SimpleIntegerProperty(totalCost);
	}

	public int getTotalSalePrice() {
		return totalSalePrice.get();
	}

	public void setTotalSalePrice(int totalSalePrice) {
		this.totalSalePrice =  new SimpleIntegerProperty(totalSalePrice);
	}

}
