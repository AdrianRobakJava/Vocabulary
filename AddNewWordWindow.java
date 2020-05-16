package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AddNewWordWindow {
	
	@FXML
	private Label newWordL;
	@FXML
	private Label repeatNewWordL;
	@FXML
	private Label yourTranslationL;
	@FXML
	private Label addNewWordL;
	@FXML
	private Button cancelB;
	@FXML
	private Button addWordB;
	@FXML
	private TextField newWordTF;
	@FXML
	private TextField repeatNewWordTF;
	@FXML
	private TextField yourTranslation1TF;
	@FXML
	private TextField yourTranslation2TF;
	@FXML
	private TextField yourTranslation3TF;
	@FXML
	private Label correctL;
	private WordsList wordsList;
	private String language;
	
	public AddNewWordWindow() {
		language  = LearnWindow.language;
	}
	
	public void initData(WordsList wL) {
		wordsList = wL;
		
	}
	
	@FXML
	private void initialize() {
		initCancelButton();
		initAddWordButton();
		initLanguage();
		
	}
	
	public void initLanguage() {
		
		if(language.equals("EN")) {
			addWordB.setText("Add Word");
			cancelB.setText("Cancel");
			addNewWordL.setText("Add New Word");
			newWordL.setText("New Word");
			repeatNewWordL.setText("Repeat New Word");
			yourTranslationL.setText("Your Translation");
		}else {
			addWordB.setText("Dodaj Wyraz");
			cancelB.setText("Anuluj");
			addNewWordL.setText("Dodaj Nowy Wyraz");
			newWordL.setText("Nowy Wyraz");
			repeatNewWordL.setText("Powtórz Wyraz");
			yourTranslationL.setText("Twoje Tłumaczenie");
		}
	}
	
	public void initAddWordButton() {
		addWordB.setOnAction((event)->{
			Stage stage = (Stage) cancelB.getScene().getWindow();
			if(newWordTF.getText().equals(repeatNewWordTF.getText()) && !yourTranslation1TF.getText().isEmpty() && yourTranslation2TF.getText().isEmpty() && yourTranslation3TF.getText().isEmpty() && !newWordTF.getText().isEmpty()) {
				wordsList.addWord(new Word(newWordTF.getText(), yourTranslation1TF.getText()));
				stage.close();
			}else if(newWordTF.getText().equals(repeatNewWordTF.getText()) && !yourTranslation1TF.getText().isEmpty() && !yourTranslation2TF.getText().isEmpty() && yourTranslation3TF.getText().isEmpty() && !newWordTF.getText().isEmpty()){
				wordsList.addWord(new Word(newWordTF.getText(), yourTranslation1TF.getText(), yourTranslation2TF.getText()));
				stage.close();
			}else if(newWordTF.getText().equals(repeatNewWordTF.getText()) && !yourTranslation1TF.getText().isEmpty() && !yourTranslation2TF.getText().isEmpty() && !yourTranslation3TF.getText().isEmpty() && !newWordTF.getText().isEmpty()){
				wordsList.addWord(new Word(newWordTF.getText(), yourTranslation1TF.getText(), yourTranslation2TF.getText(), yourTranslation3TF.getText()));
				stage.close();
			}else {
				correctL.setTextFill(Color.RED);
				if(language.equals("EN")) {
					correctL.setText("Fields incorrectly completed!!!");
				}else {
					correctL.setText("Błednie wypełnione pola!!!");
				}
			}
			
		});
	}
	
	public void initCancelButton() {
		cancelB.setOnAction((event) -> {
			Stage stage = (Stage) cancelB.getScene().getWindow();
			stage.close();
		});
	}
	


}
