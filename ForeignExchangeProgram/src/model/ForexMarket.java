package model;

import java.util.Date;

import trees.blackRedTree.RedBlackBST;

public class ForexMarket implements DataAnalysis{
	
	//RedBlackTree
	private String name;
	
	RedBlackBST<Double,ForexExchange> forexMarket;

	public ForexMarket() {
		super();
		forexMarket = new RedBlackBST<Double,ForexExchange>();
	}

	public RedBlackBST<Double,ForexExchange> getForexMarket() {
		return forexMarket;
	}

	public void setForexMarket(RedBlackBST<Double,ForexExchange> forexMarket) {
		this.forexMarket = forexMarket;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Double maxValue() {
		// TODO Auto-generated method stub
		return forexMarket.max();
	}

	@Override
	public Double minValue() {
		// TODO Auto-generated method stub
		return forexMarket.min();
	}

	@Override
	public Date[] periodGreatestGrowth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean aboveAPrice(Double price) {
		if(forexMarket.max() > price) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
