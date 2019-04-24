package model;

import java.util.Date;

public interface DataAnalysis {
	
	
	public Double maxValue();
	public Double minValue();
	public Date[] periodGreatestGrowth();
	public boolean aboveAPrice(Double price);
	

}
