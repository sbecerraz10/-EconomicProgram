package application;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class IndexController {
	
	
	@FXML
	private TextField tfForexMarket;
	@FXML
	private TextField tfCapitalMarket;
	@FXML
	private TextField tfInitialDate;
	@FXML
	private TextField tfFinalDate;
	@FXML
	private Button btBrowseForex;
	@FXML
	private Button btBrowseCapital;
	@FXML
	private Button btLoadForex;	
	@FXML
	private Button btLoadCapital;
	@FXML
	private Button btAnalyzeForex;	
	@FXML
	private Button btAnalyzeCapital;
	@FXML
	private Button btGo;
	
	
	
	private File file;
	
	
	
	
	public void initialize() {
		btBrowseCapital.setDisable(true);
		btBrowseForex.setDisable(true);
		btLoadForex.setDisable(true);
		btLoadCapital.setDisable(true);
		btAnalyzeCapital.setDisable(true);
		btAnalyzeForex.setDisable(true);
		clickedGo();
		clickedSearchFile();
		clickedLoadFile();
		analyzeData();
	}
	
	private void clickedGo() {
		btGo.setOnMouseClicked((MouseEvent)->{
			if(tfInitialDate.getText() != "" && tfFinalDate.getText() != "") {
				btBrowseCapital.setDisable(false); btBrowseForex.setDisable(false);
				btLoadForex.setDisable(false); btLoadCapital.setDisable(false);
				btAnalyzeCapital.setDisable(false); btAnalyzeForex.setDisable(false);
				String cdate = tfInitialDate.getText();
				String fdate = tfFinalDate.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm");
				SimpleDateFormat sdff = new SimpleDateFormat("dd/M/yyyy hh:mm");
				Date inidate = null;
				Date findate = null;
				try {
					inidate = sdf.parse(cdate);
					findate = sdff.parse(fdate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Main.getMarket().setInitialDate(inidate);
				Main.getMarket().setFinalDate(findate);
				
				
				
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("No data");
				alert.setHeaderText("Exception");
				alert.setContentText("Please insert a date");
				alert.showAndWait();
			}
				
		});
	}

	private void clickedSearchFile() {
		btBrowseForex.setOnMouseClicked((MouseEvent)->{
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open file");
			//File savedFile = fileChooser.showOpenDialog(null);
			file = fileChooser.showOpenDialog(null);
			if(file!=null) {
				tfForexMarket.setText(file.getAbsolutePath());
			}
				
		});
		
		btBrowseCapital.setOnMouseClicked((MouseEvent)->{
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open file");
			//File savedFile = fileChooser.showOpenDialog(null);
			file = fileChooser.showOpenDialog(null);
			if(file!=null) {
				tfCapitalMarket.setText(file.getAbsolutePath());
			}
			
		});
	}
	
	private void clickedLoadFile() {
		btLoadCapital.setOnMouseClicked((MouseEvent)->{
			try {	
				if(file!=null)
				Main.getMarket().setCurrentFile(file);
				//Cargar el metodo que recorta el archivo
				Main.getMarket().loadCapitalMarket();
			}
			catch(NullPointerException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Numbers");
				alert.setHeaderText("Exception");
				alert.setContentText("Please insert numbers");
				alert.showAndWait();
			}	
		});
		
		btLoadForex.setOnMouseClicked((MouseEvent)->{
			try {	
				if(file!=null)
				Main.getMarket().setCurrentFile(file);
				//Cargar el metodo que recorta el archivo
				Main.getMarket().loadForexMarket();
			}
			catch(NullPointerException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Numbers");
				alert.setHeaderText("Exception");
				alert.setContentText("Please insert numbers");
				alert.showAndWait();
			}	
		});
	}
	
	
	private void analyzeData() {
		btAnalyzeForex.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				goToAnalyze(t);
			}
			
		});
		
		btAnalyzeCapital.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				goToAnalyze(t);
			}
			
		});
				
	}
	
	private void goToAnalyze(MouseEvent t) {
		try { 
			FXMLLoader loader=new FXMLLoader(getClass().getResource("Analyze.fxml")); 
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
