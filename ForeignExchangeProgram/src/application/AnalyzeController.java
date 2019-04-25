package application;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.CapitalMarket;
import model.ForexMarket;

public class AnalyzeController {

	@FXML
	private ChoiceBox<String> cbSelectMarket;
	
	
	@FXML private TextField tfFromGreatestGrowthSingle;
	@FXML private TextField tfToGreatestGrowthSingle;
	@FXML private TextField tfHighestSinglePrice;
	@FXML private TextField tfLowestSinglePrice;
	
	@FXML private TextField tfMarketAbovePrice;

	
	@FXML private ListView lvAboveAPrice;
	@FXML private ListView lvHighestGrowth;
	
	public void initialize() {
		selectMarket();
	}
	
	
	private void selectMarket() {
		ObservableList<String> list = FXCollections.observableArrayList(Main.getMarket().listOfMarkets());
		cbSelectMarket.getItems().addAll(list);
		cbSelectMarket.getSelectionModel()
	    .selectedItemProperty()
	    .addListener( (ObservableValue<? extends String> observable, String oldValue, String newValue) -> displayData(newValue));
		
		//displayData(cbSelectMarket.getSelectionModel().getSelectedItem());
		System.out.println("INN");
	}


	private void displayData(String name) {
		System.out.println(name);
		if(name!=null) {
			Main.getMarket().searchForMarket(name);
			CapitalMarket actualCapital = Main.getMarket().getActualCMarket();
			ForexMarket actualForex = Main.getMarket().getActualFMarket();
			if(actualCapital==null && actualForex != null) {
				System.out.println("INN");
				tfHighestSinglePrice.setText(actualForex.maxValue()+"");
				tfLowestSinglePrice.setText(actualForex.minValue()+"");
			}else if((actualCapital!=null && actualForex == null)) {
				System.out.println("INN");
				tfHighestSinglePrice.setText(actualCapital.maxValue()+"");
				tfLowestSinglePrice.setText(actualCapital.minValue()+"");			
			}
		}	
	}
	
	
	
	
}
