package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;


public class Market {
	
	
	//Principal model class
	
	private ArrayList<ForexMarket> forexMarkets;
	private ArrayList<CapitalMarket> capitalMarkets;
	
	private File currentFile;
	
	private CapitalMarket actualCMarket;
	private ForexMarket actualFMarket;
	
	public Market() {
		super();
		forexMarkets = new ArrayList<ForexMarket>();
		capitalMarkets = new ArrayList<CapitalMarket>();
	}

	public void loadForexMarket() {
		try {
		FileReader fr = new FileReader(currentFile);
		BufferedReader br = new BufferedReader(fr);
		String cadena = "";
		
		ForexMarket forexMarket = new ForexMarket();
		String name1 = "";
		
		while((cadena= br.readLine())!= null) {
			String[] elements = cadena.split(",");
			String name = elements[0];
			name1 = name;
			String cdate = elements[1];
			String cdate1 = cdate.substring(1,cdate.length());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm");
			
			Date date = null;
			try {
				date = sdf.parse(cdate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double price = Double.parseDouble(elements[2]);
			ForexExchange forexExchange = new ForexExchange(name,date,price);
			forexMarket.getForexMarket().add(forexExchange, forexExchange.getPrice());
		}
		forexMarket.setName(name1);
		forexMarkets.add(forexMarket);
		
		br.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void loadCapitalMarket() {
		try {
			FileReader fr = new FileReader(currentFile);
			BufferedReader br = new BufferedReader(fr);
			String cadena = "";
			
			CapitalMarket capitalMarket = new CapitalMarket();
			String name1 = "";
			
			while((cadena= br.readLine())!= null) {
				String[] elements = cadena.split(";");
				String name = elements[0];
				name1 = name;
				String cdate = elements[1];
				String cdate1 = cdate.substring(1,cdate.length());
				SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm");
				
				Date date = null;
				try {
					date = sdf.parse(cdate1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				double price = Double.parseDouble(elements[2]);
				ForexExchange forexExchange = new ForexExchange(name,date,price);
				capitalMarket.getCapitalMarket().add(forexExchange, forexExchange.getPrice());
			}
			capitalMarket.setName(name1);
			capitalMarkets.add(capitalMarket);
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<String> listOfMarkets(){
		
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i < forexMarkets.size(); i++) {
			list.add(forexMarkets.get(i).getName());
		}
		for(int i=0; i < capitalMarkets.size(); i++) {
			list.add(capitalMarkets.get(i).getName());
		}
		
		return list;
	}
	
	public void searchForMarket(String name) {
		if(name.startsWith("#")) {
			for (int i = 0; i < capitalMarkets.size(); i++) {
				if(name.equals(capitalMarkets.get(i).getName())) {
					actualCMarket = capitalMarkets.get(i);
					actualFMarket = null;
				}
			}
		}else {
			for (int i = 0; i < forexMarkets.size(); i++) {
				if(name.equals(forexMarkets.get(i).getName())) {
					actualFMarket = forexMarkets.get(i);
					actualCMarket = null;
				}
			}			
		}
	}
	
	
	public ArrayList<ForexMarket> getForexMarkets() {
		return forexMarkets;
	}


	public void setForexMarkets(ArrayList<ForexMarket> forexMarkets) {
		this.forexMarkets = forexMarkets;
	}


	public ArrayList<CapitalMarket> getCapitalMarkets() {
		return capitalMarkets;
	}


	public void setCapitalMarkets(ArrayList<CapitalMarket> capitalMarkets) {
		this.capitalMarkets = capitalMarkets;
	}

	public File getCurrentFile() {
		return currentFile;
	}

	public void setCurrentFile(File currentFile) {
		this.currentFile = currentFile;
	}

	public CapitalMarket getActualCMarket() {
		return actualCMarket;
	}

	public void setActualCMarket(CapitalMarket actualCMarket) {
		this.actualCMarket = actualCMarket;
	}

	public ForexMarket getActualFMarket() {
		return actualFMarket;
	}

	public void setActualFMarket(ForexMarket actualFMarket) {
		this.actualFMarket = actualFMarket;
	}
	
	
	
	
	
	

}
