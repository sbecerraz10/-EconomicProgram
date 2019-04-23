package application;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class IndexController {
	
	
	@FXML
	private TextField tfForexMarket;
	@FXML
	private TextField tfCapitalMarket;
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
	
	
	private File file;
	
	
	
	
	public void initialize() {
		clickedSearchFile();
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
	
}
