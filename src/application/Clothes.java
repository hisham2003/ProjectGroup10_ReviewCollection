package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Clothes extends Item {
	private SimpleStringProperty size;
	private SimpleStringProperty material;

	public Clothes(int id, String name, int cost, int salePrice, int amount, int totalCost, int totalSalePrice,
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
		return size;

	}

	public void setMaterial(String material) {
		this.material.set(material);
	}

}
