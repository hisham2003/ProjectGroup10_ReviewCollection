package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

/**
 * Child of Item class. This class represents a clothes item in a store
 * inventory. It has fields for id, name, cost, sale price, amount, total
 * cost,total sale price,size,material.
 * 
 * @author HishamSouraya
 */

public class Clothes extends Item {
	private SimpleStringProperty size;
	private SimpleStringProperty material;

	/**
	 * Constructor for the Clothes class
	 * 
	 * @param id             The id of the item
	 * @param name           The name of the item
	 * @param cost           The cost of the item
	 * @param salePrice      The sale price of the item
	 * @param amount         The amount of the item
	 * @param totalCost      The total cost of the item
	 * @param totalSalePrice The total sale price of the item
	 * @param size           The size of the clothes
	 * @param material       The material of the clothes
	 */
	public Clothes(int id, String name, double cost, double salePrice, int amount, double totalCost,
			double totalSalePrice, String size, String material) {
		super(id, name, cost, salePrice, amount, totalCost, totalSalePrice);
		this.size = new SimpleStringProperty(size);
		this.material = new SimpleStringProperty(material);

	}

	/**
	 * @return the size of this object
	 */
	public String getSize() {
		return size.get();
	}

	/**
	 * Utilized code from Item Class
	 * 
	 * @return the `size` property of this object
	 */
	public final StringProperty sizeProperty() {
		return size;

	}

	/**
	 * Sets the size of this object. used this.variable.set(variable) due to the
	 * nature of simpleTypePropertys
	 * 
	 * @param size
	 */
	public void setSize(String size) {
		this.size.set(size);
	}

	/**
	 * @return the material of this object
	 */
	public String getMaterial() {
		return material.get();
	}

	/**
	 * Utilized code from Item Class
	 * 
	 * @return the `material` property of this object
	 */
	public final StringProperty materialProperty() {
		return material;

	}

}
