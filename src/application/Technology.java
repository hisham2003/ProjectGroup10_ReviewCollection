package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

/**
 * Child of Item class. This class represents a Technology item in a store
 * inventory. It has fields for id, name, cost, sale price, amount, total
 * cost,total sale price,size,type,year.
 * 
 * @author HishamSouraya
 */
public class Technology extends Item {
	private SimpleStringProperty size;
	private SimpleStringProperty type;
	private SimpleIntegerProperty year;

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
	 * @param size           The size of the Technology
	 * @param type           The type of the Technology
	 * @param year           The year of the Technology
	 */

	public Technology(int id, String name, double cost, double salePrice, int amount, double totalCost,
			double totalSalePrice, String size, String type, int year) {
		super(id, name, cost, salePrice, amount, totalCost, totalSalePrice);
		this.size = new SimpleStringProperty(size);
		this.type = new SimpleStringProperty(type);
		this.year = new SimpleIntegerProperty(year);
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
	public final StringProperty sizeTechProperty() {
		return size;

	}


	/**
	 * @return the type of this object
	 */
	public String getType() {
		return type.get();
	}

	/**
	 * Utilized code from Item Class
	 * 
	 * @return the `type` property of this object
	 */
	public final StringProperty typeProperty() {
		return type;

	}

	/**
	 * @return the year of this object
	 */
	public int getYear() {
		return year.get();
	}

	/**
	 * Utilized code from Item Class
	 * 
	 * @return the `year` property of this object
	 */
	public final IntegerProperty yearProperty() {
		return year;

	}

}
