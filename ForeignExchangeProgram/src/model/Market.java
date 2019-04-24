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
		
		
		while((cadena= br.readLine())!= null) {
			String[] elements = cadena.split(",");
			String name = elements[0];
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
			
			
			while((cadena= br.readLine())!= null) {
				String[] elements = cadena.split(";");
				String name = elements[0];
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
	
	
	
	
	
	

}
