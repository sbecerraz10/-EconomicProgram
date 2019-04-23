package model;

import structures.Stack;

public class Market {
	
	
	//Principal model class
	
	private Stack<ForexMarket> forexMarkets;
	
	
	public Market() {
		
	}


	public Stack<ForexMarket> getForexMarkets() {
		return forexMarkets;
	}


	public void setForexMarkets(Stack<ForexMarket> forexMarkets) {
		this.forexMarkets = forexMarkets;
	}
	

}
