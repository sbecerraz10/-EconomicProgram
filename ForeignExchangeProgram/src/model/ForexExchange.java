package model;

import java.util.Date;

public class ForexExchange implements Comparable<ForexExchange>{
	
	
	

	private String name;
	private Date date;
	private Double price;
	
	
	public ForexExchange(String name, Date date, double price) {
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public int compareTo(ForexExchange o) {
		// TODO Auto-generated method stub
		if(this.price < o.price) {
			return -1;
		}else{
			return 1;
		}
	}
	
	
	
	
	

}
