package application;

import java.io.IOException;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.CapitalMarket;
import model.ForexMarket;

public class AnalyzeController {

	@FXML
	private ChoiceBox<String> cbSelectMarket;
	
	
	@FXML private TextField tfFromGreatestGrowthSingle;
	@FXML private TextField tfToGreatestGrowthSingle;
	@FXML private TextField tfHighestSinglePrice;
	@FXML private TextField tfLowestSinglePrice;
	@FXML private TextField tfPeriodTime;
	
	@FXML private TextField tfMarketAbovePrice;

	
	@FXML private ListView lvAboveAPrice;
	@FXML private ListView lvHighestGrowth;
	@FXML private Button searchAboveAPrice;
	
	
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
		searchAboveAPrice();
	}


	private void searchAboveAPrice() {
		searchAboveAPrice.setOnMouseClicked((MouseEvent)->{
			try {	
				lvAboveAPrice.getItems().clear();
				Double price = Double.parseDouble(tfMarketAbovePrice.getText());
				ObservableList<String> list = FXCollections.observableArrayList(Main.getMarket().listOfAboveAPrice(price));
				lvAboveAPrice.getItems().addAll(list);
			}
			catch(Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Numbers");
				alert.setHeaderText("Exception");
				alert.setContentText("Please insert numbers");
				alert.showAndWait();
			}	
		});
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
				tfPeriodTime.setText("");
			}else if((actualCapital!=null && actualForex == null)) {
				System.out.println("INN");
				tfHighestSinglePrice.setText(actualCapital.maxValue()+"");
				tfLowestSinglePrice.setText(actualCapital.minValue()+"");
				tfPeriodTime.setText("");
			}
		}	
	}
	
	@FXML 
	public void goToIndex(MouseEvent t) {
		try { 
			FXMLLoader loader=new FXMLLoader(getClass().getResource("Index.fxml")); 
			Parent showThrow = loader.load(); 
			Scene sceneThrow = new Scene(showThrow);
			Stage windowThrow = (Stage)((Node) t.getSource()).getScene().getWindow();
			//windowThrow.getIcons().add(new Image("images/Pokebola.png"));
			windowThrow.setScene(sceneThrow);
			windowThrow.show();
			
		} catch (IOException e) { 
				e.printStackTrace();
		}
	}
	
	
	
	
}
