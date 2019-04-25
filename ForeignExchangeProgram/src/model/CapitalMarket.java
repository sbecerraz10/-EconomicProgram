package model;

import java.util.Date;

import trees.AVLSearchTree.AVLTreeST;

public class CapitalMarket implements DataAnalysis{
	
	
	//AVL
	private String name;
	
	

	private AVLTreeST<Double,ForexExchange> capitalMarket;

	public CapitalMarket() {
		super();
		capitalMarket = new AVLTreeST<Double,ForexExchange>();
	}

	public AVLTreeST<Double,ForexExchange> getCapitalMarket() {
		return capitalMarket;
	}

	public void setCapitalMarket(AVLTreeST<Double,ForexExchange> capitalMarket) {
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
		return capitalMarket.max();
	}

	@Override
	public Double minValue() {
		return capitalMarket.min();
	}

	@Override
	public Date[] periodGreatestGrowth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean aboveAPrice(Double price) {
		if(capitalMarket.max() > price) {
			return true;
		}else {
			return false;
		}
	}
	

}
