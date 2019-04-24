package model;

import java.util.Date;

import trees.AVLSearchTree.AVLTreeST;

public class CapitalMarket implements DataAnalysis{
	
	
	//AVL
	private String name;
	
	

	private AVLTreeST<ForexExchange,Double> capitalMarket;

	public CapitalMarket() {
		super();
		capitalMarket = new AVLTreeST<ForexExchange,Double>();
	}

	public AVLTreeST<ForexExchange,Double> getCapitalMarket() {
		return capitalMarket;
	}

	public void setCapitalMarket(AVLTreeST<ForexExchange,Double> capitalMarket) {
		this.capitalMarket = capitalMarket;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Double maxValue() {
		return capitalMarket.max().getPrice();
	}

	@Override
	public Double minValue() {
		return capitalMarket.min().getPrice();
	}

	@Override
	public Date[] periodGreatestGrowth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean aboveAPrice(Double price) {
		if(capitalMarket.max().getPrice() > price) {
			return true;
		}else {
			return false;
		}
	}
	

}
