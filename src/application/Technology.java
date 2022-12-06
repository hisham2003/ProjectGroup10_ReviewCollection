package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

public class Technology extends Item {
	private SimpleStringProperty size;
	private SimpleStringProperty type;
	private SimpleIntegerProperty year;


	public Technology(int id, String name, double cost, double salePrice, int amount, double totalCost, double totalSalePrice,
			String size, String type,int year) {
		super(id, name, cost, salePrice, amount, totalCost, totalSalePrice);
		this.size = new SimpleStringProperty(size);
		this.type = new SimpleStringProperty(type);
		this.year = new SimpleIntegerProperty(year);
	}
	
	

	public String getSize() {
		return size.get();
	}

	public final StringProperty sizeTechProperty() {
		return size;

	}

	public void setSize(String size) {
		this.size.set(size);
	}

	public String getType() {
		return type.get();
	}

	public final StringProperty typeProperty() {
		return type;

	}
	public int getYear() {
		return year.get();
	}

	public final IntegerProperty yearProperty() {
		return year;

	}

	public void setAmount(int year) {
		this.year.set(year);
	}


	
	
	

}
