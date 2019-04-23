package model;

import structures.RedBlackTree;

public class ForexMarket {
	
	//RedBlackTree
	
	RedBlackTree<ForexExchange> forexMarket;

	public ForexMarket(RedBlackTree<ForexExchange> forexMarket) {
		super();
		this.forexMarket = forexMarket;
	}

	public RedBlackTree<ForexExchange> getForexMarket() {
		return forexMarket;
	}

	public void setForexMarket(RedBlackTree<ForexExchange> forexMarket) {
		this.forexMarket = forexMarket;
	}
	
	

}
