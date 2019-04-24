package model;

import java.util.Date;

import trees.blackRedTree.RedBlackBST;

public class ForexMarket implements DataAnalysis{
	
	//RedBlackTree
	private String name;
	
	RedBlackBST<ForexExchange,Double> forexMarket;

	public ForexMarket() {
		super();
		forexMarket = new RedBlackBST<ForexExchange,Double>();
	}

	public RedBlackBST<ForexExchange,Double> getForexMarket() {
		return forexMarket;
	}

	public void setForexMarket(RedBlackBST<ForexExchange,Double> forexMarket) {
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
		return forexMarket.max().getPrice();
	}

	@Override
	public Double minValue() {
		// TODO Auto-generated method stub
		return forexMarket.min().getPrice();
	}

	@Override
	public Date[] periodGreatestGrowth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean aboveAPrice(Double price) {
		if(forexMarket.max().getPrice() > price) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
