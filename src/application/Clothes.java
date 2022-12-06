package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

public class Clothes extends Item {
	private SimpleStringProperty size;
	private SimpleStringProperty material;


	public Clothes(int id, String name, double cost, double salePrice, int amount, double totalCost, double totalSalePrice,
			String size, String material) {
		super(id, name, cost, salePrice, amount, totalCost, totalSalePrice);
		this.size = new SimpleStringProperty(size);
		this.material = new SimpleStringProperty(material);

	}
	
	

	public String getSize() {
		return size.get();
	}

	public final StringProperty sizeProperty() {
		return size;

	}

	public void setSize(String size) {
		this.size.set(size);
	}

	public String getMaterial() {
		return material.get();
	}

	public final StringProperty materialProperty() {
		return material;

	}

	
	
	

}
