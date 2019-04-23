package model;

import java.time.LocalDate;

public class ForexExchange {
	
	
	

	private String name;
	private LocalDate date;
	private double price;
	
	
	public ForexExchange(String name, LocalDate date, double price) {
		super();
		this.name = name;
		this.date = date;
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
