package model;

import java.util.ArrayList;
import java.util.List;

public class Garage {
	private String name;
	private List<Car> stock = new ArrayList<Car>();
	private CarFactory usine = CarFactory.getInstance();
	
	public List<Car> getStock() {
		return stock;
	}

	public void setStock(List<Car> stock) {
		this.stock = stock;
	}

	public CarFactory getUsine() {
		return usine;
	}

	

}
