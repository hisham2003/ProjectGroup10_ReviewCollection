
package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 * This class represents an item in a store inventory. It has fields for id,
 * name, cost, sale price, amount, total cost, and total sale price. It also has
 * methods for calculating the holding cost for clothes and tech items.
 * 
 * @author HishamSouraya
 */

public class Item {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleDoubleProperty cost;
	private SimpleDoubleProperty salePrice;
	private SimpleIntegerProperty amount;
	private SimpleDoubleProperty totalCost;
	private SimpleDoubleProperty totalSalePrice;

	/**
	 * Constructor for the Item class
	 * 
	 * @param id             The id of the item
	 * @param name           The name of the item
	 * @param cost           The cost of the item
	 * @param salePrice      The sale price of the item
	 * @param amount         The amount of the item
	 * @param totalCost      The total cost of the item
	 * @param totalSalePrice The total sale price of the item
	 */
	public Item(int id, String name, double cost, double salePrice, int amount, double totalCost,
			double totalSalePrice) {
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.cost = new SimpleDoubleProperty(cost);
		this.salePrice = new SimpleDoubleProperty(salePrice);
		this.amount = new SimpleIntegerProperty(amount);
		this.totalCost = new SimpleDoubleProperty(totalCost);
		this.totalSalePrice = new SimpleDoubleProperty(totalSalePrice);
	}

	/**
	 * Method to calculate the holding cost for clothes items
	 * 
	 * @return The holding cost for clothes items
	 */
	public double getHoldingCostClothes() {
		return 0.15 * getAmount();
	}

	/**
	 * Method to calculate the holding cost for tech items
	 * 
	 * @return The holding cost for tech items
	 */
	public double getHoldingCostTech() {
		return 0.20 * getAmount();
	}

	/**
	 * @return the ID of this object
	 */
	public int getId() {
		return id.get();
	}

	/**
	 * Utilized code from
	 * https://stackoverflow.com/questions/72437983/why-should-i-avoid-using-propertyvaluefactory-in-javafx
	 * 
	 * @return the `id` property of this object
	 */
	public final IntegerProperty idProperty() {
		return id;

	}

	/**
	 * Sets the ID of this object. used this.variable.set(variable) due to the
	 * nature of simpleTypePropertys
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id.set(id);
	}

	/**
	 * @return the Name of this object
	 */
	public String getName() {
		return name.get();
	}

	/**
	 * @return the `name` property of this object
	 */
	public final StringProperty nameProperty() {
		return name;

	}

	/**
	 * Sets the Name of this object. used this.variable.set(variable) due to the
	 * nature of simpleTypePropertys
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name.set(name);
	}

	/**
	 * @return the cost of this object
	 */
	public double getCost() {
		return cost.get();
	}

	/**
	 * @return the `cost` property of this object
	 */
	public final DoubleProperty costProperty() {
		return cost;

	}

	/**
	 * Sets the cost of this object. used this.variable.set(variable) due to the
	 * nature of simpleTypePropertys
	 * 
	 * @param cost
	 */
	public void setCost(int cost) {
		this.cost.set(cost);
	}

	/**
	 * @return the salePrice of this object
	 */
	public double getSalePrice() {
		return salePrice.get();
	}

	/**
	 * @return the `salePrice` property of this object
	 */
	public final DoubleProperty salePriceProperty() {
		return salePrice;

	}

	/**
	 * Sets the sale of this object. used this.variable.set(variable) due to the
	 * nature of simpleTypePropertys
	 * 
	 * @param sale
	 */
	public void setSalePrice(int salePrice) {
		this.salePrice.set(salePrice);
	}

	/**
	 * @return the amount of this object
	 */
	public int getAmount() {
		return amount.get();
	}

	/**
	 * @return the `amount` property of this object
	 */
	public final IntegerProperty amountProperty() {
		return amount;

	}

	/**
	 * Sets the amount of this object. used this.variable.set(variable) due to the
	 * nature of simpleTypePropertys
	 * 
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount.set(amount);
	}

	/**
	 * @return the total cost of this object
	 */
	public double getTotalCost() {
		return totalCost.get();
	}

	/**
	 * @return the `totalCost` property of this object
	 */
	public final DoubleProperty totalCostProperty() {
		return totalCost;

	}

	/**
	 * Sets the total Cost of this object. used this.variable.set(variable) due to
	 * the nature of simpleTypePropertys
	 * 
	 * @param totalCost
	 */
	public void setTotalCost(int totalCost) {
		this.totalCost.set(totalCost);
	}

	/**
	 * @return the total sale of this object
	 */
	public double getTotalSalePrice() {
		return totalSalePrice.get();
	}

	/**
	 * @return the `totalSale` property of this object
	 */
	public final DoubleProperty totalSalePriceProperty() {
		return totalSalePrice;

	}

	/**
	 * Sets the total Sale price of this object. used this.variable.set(variable)
	 * due to the nature of simpleTypePropertys
	 * 
	 * @param totalSalePrice
	 */
	public void setTotalSalePrice(int totalSalePrice) {
		this.totalSalePrice.set(totalSalePrice);
	}

}
