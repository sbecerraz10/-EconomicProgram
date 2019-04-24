package model;

import trees.blackRedTree.RedBlackBST;

public class ForexMarket {
	
	//RedBlackTree
	
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
	
	

}
