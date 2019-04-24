package model;

import trees.AVLSearchTree.AVLTreeST;

public class CapitalMarket {
	
	
	//AVL
	
	
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
	
	
	
	
	

}
