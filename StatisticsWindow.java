package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class StatisticsWindow {
	
	@FXML
	private TextArea wordsListTA;
	@FXML
	private Button showB;
	@FXML
	private Button closeB;
	private WordsList wordsList;
	private String language;
	private String whichList;
	
	public StatisticsWindow() {
		language  = LearnWindow.language;
		whichList = LearnWindow.whichList;
		
	}
	@FXML
	private void initialize() {
		initShowButton();
		initCloseButton();
		initLanguage();
	}
	
	public void initShowButton() {
		showB.setOnAction((event) -> {
			if(whichList.equals("statistics")) {
				showStatistics();
			}else if(whichList.equals("learned")) {
				showLearned();
			}else {
				showToLearn();
			}
		});
	}
	
	public void initCloseButton() {
		closeB.setOnAction((event) -> {
			Stage stage = (Stage) closeB.getScene().getWindow();
			stage.close();
		});
	}
	
	public void initData(WordsList wL) {
		wordsList = wL;
		
	}
	
	public void initLanguage() {
		
		if(language.equals("EN")) {
			showB.setText("Show");
			closeB.setText("Close");
			
		}else {
			showB.setText("Pokaż");
			closeB.setText("Zamknij");
			
		}
	}
	
	
	public void showStatistics() {
		StringBuilder sb = new StringBuilder();
		if(language.equals("EN")) {
			sb.append("\n     Statistics   \n\n");
			for(Word w : wordsList.getLearnedWordsList()) {
				sb.append(w + " => " + "All attempts (" + w.getTotalShowCounter() + "), Correct answers in a row (" + w.getCorrectCounter() + "), Incorrect answers (" + w.getIncorrectCounter() + ")" );
				sb.append("\n ");
			}
			
			for(Word w : wordsList.getWordsList()) {
				sb.append(w + " => " + "All attempts (" + w.getTotalShowCounter() + "), Correct answers in a row (" + w.getCorrectCounter() + "), Incorrect answers (" + w.getIncorrectCounter() + ")" );
				sb.append("\n ");			
			}
		}else {
			sb.append("\n     Statystyki   \n\n");	
			for(Word w : wordsList.getLearnedWordsList()) {
				sb.append(w + " => " + "Wszystkie próby (" + w.getTotalShowCounter() + "), Poprawne odpowiedzi z rzędu (" + w.getCorrectCounter() + "), Niepoprawne odpowiedzi (" + w.getIncorrectCounter() + ")" );
				sb.append("\n ");
			}
			for(Word w : wordsList.getWordsList()) {
				sb.append(w + " => " + "Wszystkie próby (" + w.getTotalShowCounter() + "), Poprawne odpowiedzi z rzędu (" + w.getCorrectCounter() + "), Niepoprawne odpowiedzi (" + w.getIncorrectCounter() + ")" );
				sb.append("\n ");
			}
		}
		wordsListTA.setText(sb.toString());
	}
	
	public void showLearned() {
		StringBuilder sb = new StringBuilder();
		if(language.equals("EN")) {
			sb.append("\n     Learned Words   \n\n");
		}else {
			sb.append("\n     Wyrazy Nauczone   \n\n");
		}
		for(Word w : wordsList.getLearnedWordsList()) {
			sb.append(w);
			sb.append("\n");
		}
		wordsListTA.setText(sb.toString());
	}
	
	public void showToLearn() {
		StringBuilder sb = new StringBuilder();
		
		if(language.equals("EN")) {
			sb.append("\n     Words To Learn   \n\n");
		}else {
			sb.append("\n     Wyrazy Do Nauczenia   \n\n");
		}
		for(Word w : wordsList.getWordsList()) {
			sb.append(w);
			sb.append("\n");
		}
		wordsListTA.setText(sb.toString());
	}
}
