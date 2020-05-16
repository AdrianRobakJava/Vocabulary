package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystemNotFoundException;
import java.util.Random;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LearnWindow {

	@FXML
	private Label wordLabel;
	@FXML
	private Label translationL;
	@FXML
	private Label wordL;
	@FXML
	private Label correctL;
	@FXML
	private Label saveL;
	@FXML
	private TextField translationTF;
	@FXML
	private Button addNewWordB;
	@FXML
	private Button checkB;
	@FXML
	private Button allWordListB;
	@FXML
	private Button wordsToLearnB;
	@FXML
	private Button nextWordB;
	@FXML
	private Button showTranslationB;
	@FXML
	private Button howItWorkB;
	@FXML
	private Button statisticsB;
	@FXML
	private Button plenB;
	@FXML
	private Button saveB;
	@FXML
	private Button loadB;
	@FXML
	private Button closeB;
	private WordsList wordsList;
	private Word word;

	public static String whichList;
	// Current language
	public static String language = "EN";

	// Current index for object "word" in object wordsList in ArrayList
	private int wordIndex;

	// Can have values 1 and 0, needed for the correct working of the spell check
	// buttons
	private int checkButton = 0;

	public LearnWindow() {
		wordsList = new WordsList();
	}

	@FXML
	private void initialize() {
		initAddNewWordButton();
		initCloseButton();
		initLearnedListButton();
		initWordsToLearnListButton();
		initNextWordButton();
		initCheckButton();
		initStatisticsButton();
		initShowTranslationButton();
		initShowHowItWorkButton();
		initPlEnButton();
		// initAddWords();
		initSaveButton();
		initLoadButton();
		loadAllWords();
		initCheckWordByEnter();
		// initKey();

	}

	public void initPlEnButton() {
		plenB.setOnAction((event) -> {
			try {
				changeMenuLanguage();
			} catch (Exception e) {
				e.printStackTrace();
			}
			saveL.setText("");
		});
	}

	public void initAddNewWordButton() {
		addNewWordB.setOnAction((event) -> {
			try {
				showAddNewWordWindow();
			} catch (Exception e) {
				e.printStackTrace();
			}
			saveL.setText("");
		});
	}

	public void initShowHowItWorkButton() {
		howItWorkB.setOnAction((event) -> {
			try {
				showHowItWorkWindow();
			} catch (Exception e) {
				e.printStackTrace();
			}
			saveL.setText("");
		});
	}

	public void initNextWordButton() {
		nextWordB.setOnAction((event) -> {
			try {
				wordL.setText("");
				nextWord();
				translationTF.setText("");
				checkButton = 1;

			} catch (Exception e) {
				e.printStackTrace();
			}
			// Go back to the text field
			translationTF.requestFocus();

			correctL.setText("");
			saveL.setText("");
		});
	}

	public void initCheckButton() {
		checkB.setOnAction((event) -> {
			checkButtonCode();
		});
	}
	
	public void initCheckWordByEnter() {
		translationTF.setOnKeyPressed((event)->{
			if(event.getCode().equals(KeyCode.ENTER)) {
				checkButtonCode();
			}
		});
	}
	
	public void checkButtonCode() {
		try {
			if (!translationTF.getText().isEmpty() && checkButton == 1) {
				checkWord();
			} else {
				correctL.setTextFill(Color.RED);
				if (language.equals("EN")) {
					if (translationTF.getText().isEmpty() && checkButton == 0) {
						correctL.setText("Draw your word!");
					}
					if (checkButton == 1) {
						correctL.setText("The field is empty!");
					}
				} else {
					if (translationTF.getText().isEmpty() && checkButton == 0) {
						correctL.setText("Wylosuj nowy wyraz!");
					}
					if (checkButton == 1) {
						correctL.setText("Nic nie wpisano!");
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		saveL.setText("");
		nextWordB.requestFocus();
	}
	 

	public void initShowTranslationButton() {
		showTranslationB.setOnAction((event) -> {
			if (checkButton == 1) {
				correctL.setTextFill(Color.BLUE);
				correctL.setText(word.getYourWord());
			}
			saveL.setText("");
		});
	}

	public void initCloseButton() {
		closeB.setOnAction((event) -> {
			Stage stage = (Stage) closeB.getScene().getWindow();
			stage.close();
		});
	}

	public void initStatisticsButton() {
		statisticsB.setOnAction((event) -> {
			try {
				whichList = "statistics";
				showStatisticsWindow();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}
			saveL.setText("");
		});
	}

	public void initLearnedListButton() {
		allWordListB.setOnAction((event) -> {
			try {
				whichList = "learned";
				showStatisticsWindow();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}
			saveL.setText("");
		});
	}

	public void initWordsToLearnListButton() {

		wordsToLearnB.setOnAction((event) -> {
			try {
				whichList = "toLearn";
				showStatisticsWindow();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}
			saveL.setText("");
		});
	}

	public Stage showAddNewWordWindow() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddNewWordWindow.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Add New Word");
		Scene scene = new Scene(loader.load());
		stage.setScene(scene);
		AddNewWordWindow controller = loader.<AddNewWordWindow>getController();
		controller.initData(wordsList);
		stage.show();
		return stage;
	}

	public Stage showHowItWorkWindow() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("HowItWorkWindow.fxml"));
		Stage stage = new Stage();
		stage.setTitle("How It Work");
		Scene scene = new Scene(loader.load());
		stage.setScene(scene);
		stage.show();
		return stage;
	}

	public Stage showStatisticsWindow() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("StatisticsWindow.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Statistics Window");
		Scene scene = new Scene(loader.load());
		stage.setScene(scene);
		StatisticsWindow controller = loader.<StatisticsWindow>getController();
		controller.initData(wordsList);
		stage.show();
		return stage;
	}

	// A method of drawing words to be translated
	public void nextWord() {
		Random rand = new Random();
		if (wordsList.getWordsList().size() > 0) {
			wordIndex = rand.nextInt(wordsList.getWordsList().size());
			word = wordsList.getWordsList().get(wordIndex);
			wordL.setText(word.onlyTranslation());
		} else {
			correctL.setTextFill(Color.RED);
			if (language.equals("EN")) {
				correctL.setText("You have already lerned all the words.");
			} else {
				correctL.setText("Nauczyłeś się już wszystkich wprowadzonych wyrazów.");
			}
		}
	}

	// Method to check the correctness of the translation
	public void checkWord() {
		String temp = translationTF.getText();

		if (wordsList.getWordsList().size() > 0) {
			if (temp.equals(word.getYourWord())) {
				word.addOneToCorrect();
				correctL.setTextFill(Color.GREEN);
				if (language.equals("EN")) {
					correctL.setText("Good it is correct!\n " + word.getYourWord() + " ");
				} else {
					correctL.setText("Dobrze, poprawna odpowiedź!\n " + word.getYourWord() + " ");
				}
				checkButton = 0;

				// After ten correct answers in a row, the word will be transferred to the list
				// of learned words
				if (word.getCorrectCounter() >= 10) {
					if (language.equals("EN")) {
						correctL.setText("Good it is correct!\nNow you know that word very well.");
					} else {
						correctL.setText("Dobrze, poprawna odpowiedź!\nTeraz znasz ten wyraz bardzo dobrze.");
					}
					wordsList.addWordToLearned(word);
					wordsList.removeWord(wordIndex);
				}
			} else {
				word.addOneToIncorrect();
				correctL.setTextFill(Color.RED);
				if (language.equals("EN")) {
					correctL.setText("Incorrect!");
				} else {
					correctL.setText("Niepoprawne tłumaczenie!");
				}
			}
		} else {
			correctL.setTextFill(Color.RED);
			if (language.equals("EN")) {
				correctL.setText("You have already learned everything!");
			} else {
				correctL.setText("Nauczyłeś się już wszystkich słówek!");
			}
		}
	}

	public void initAddWords() {
		Word w1 = new Word("word", "wyraz");
		wordsList.addWord(w1);
		Word w2 = new Word("mouse", "mysz");
		wordsList.addWord(w2);
		Word w3 = new Word("key", "klucz");
		wordsList.addWord(w3);
		Word w4 = new Word("castle", "zamek");
		wordsList.addWord(w4);
		Word w5 = new Word("water", "woda");
		wordsList.addWord(w5);
	}

	public void changeMenuLanguage() {
		if (language.equals("EN")) {
			howItWorkB.setText("Jak To Działa");
			checkB.setText("Sprawdź");
			nextWordB.setText("Następne Słowo");
			showTranslationB.setText("Pokaż Tłumaczenie");
			addNewWordB.setText("Dodaj Nowe Słowo");
			saveB.setText("Zapisz");
			loadB.setText("Wczytaj");
			statisticsB.setText("Statystyki");
			wordsToLearnB.setText("Wyrazy Do Nauczenia");
			allWordListB.setText("Nauczone Wyrazy");
			closeB.setText("Zamknij");
			wordLabel.setText("Wyraz");
			translationL.setText("Tłumaczenie");
			language = "PL";
		} else {
			howItWorkB.setText("How It Work");
			checkB.setText("Check");
			nextWordB.setText("Next Word");
			showTranslationB.setText("Show Translation");
			addNewWordB.setText("Add New Word");
			saveB.setText("Save");
			loadB.setText("Load");
			statisticsB.setText("Statistics");
			wordsToLearnB.setText("Words To Learn");
			allWordListB.setText("Learned Words");
			closeB.setText("Close");
			wordLabel.setText("Word");
			translationL.setText("Translation");
			language = "EN";
		}

	}

	public void initSaveButton() {

		saveB.setOnAction((event) -> {
			try {
				saveAllWords();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

	}

	public void initLoadButton() {

		loadB.setOnAction((event) -> {
			try {
				if (wordsList.getWordsList().size() == 0 && wordsList.getLearnedWordsList().size() == 0) {
					loadAllWords();
				} else {
					saveL.setTextFill(Color.RED);
					if (language.equals("EN")) {
						saveL.setText("Data has already\n been loaded.");
					} else {
						saveL.setText("Dane zostały już wczytane.");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

	}

	public void loadAllWords() {
		try {
			File file1 = new File("Learned.csv");
			Scanner sc1 = new Scanner(file1);
			while (sc1.hasNextLine()) {
				String str = sc1.nextLine();
				String[] values = str.split(",");
				Word word = new Word(values[0], values[1], values[2], values[3]);
				word.setTotalShowCounter(Integer.parseInt(values[4]));
				word.setCorrectCounter(Integer.parseInt(values[5]));
				word.setIncorrectCounter(Integer.parseInt(values[6]));
				wordsList.getLearnedWordsList().add(word);

			}
			sc1.close();

			File file2 = new File("ToLearn.csv");
			Scanner sc2 = new Scanner(file2);
			while (sc2.hasNextLine()) {
				String str = sc2.nextLine();
				String[] values = str.split(",");
				Word word = new Word(values[0], values[1], values[2], values[3]);
				word.setTotalShowCounter(Integer.parseInt(values[4]));
				word.setCorrectCounter(Integer.parseInt(values[5]));
				word.setIncorrectCounter(Integer.parseInt(values[6]));
				wordsList.getWordsList().add(word);
			}
			sc2.close();
		} catch (FileNotFoundException e) {
			System.out.println("Nie ma takiego pliku");
		}
		saveL.setTextFill(Color.GREEN);
		if (language.equals("EN")) {
			saveL.setText("Data has been loaded.");
		} else {
			saveL.setText("Dane zostały wczytane.");
		}

	}

	public void saveAllWords() {
		try {
			PrintWriter pw1 = new PrintWriter(new File("Learned.csv"));

			for (Word w : wordsList.getLearnedWordsList()) {
				pw1.append(w.getYourWord() + ",");
				pw1.append(w.getYourTranslation1() + ",");
				pw1.append(w.getYourTranslation2() + ",");
				pw1.append(w.getYourTranslation3() + ",");
				pw1.append(w.getTotalShowCounter() + ",");
				pw1.append(w.getCorrectCounter() + ",");
				pw1.append(w.getIncorrectCounter() + "");
				pw1.append("\n");
			}

			pw1.close();

			PrintWriter pw2 = new PrintWriter(new File("ToLearn.csv"));

			for (Word w : wordsList.getWordsList()) {
				pw2.append(w.getYourWord() + ",");
				pw2.append(w.getYourTranslation1() + ",");
				pw2.append(w.getYourTranslation2() + ",");
				pw2.append(w.getYourTranslation3() + ",");
				pw2.append(w.getTotalShowCounter() + ",");
				pw2.append(w.getCorrectCounter() + ",");
				pw2.append(w.getIncorrectCounter() + "");
				pw2.append("\n");
			}

			pw2.close();
			saveL.setTextFill(Color.GREEN);
			if (language.equals("EN")) {
				saveL.setText("Data saved.");
			} else {
				saveL.setText("Dane zostały zapisane.");
			}

		} catch (FileNotFoundException e) {
			saveL.setTextFill(Color.RED);
			if (language.equals("EN")) {
				saveL.setText("Data has not been saved.");
			} else {
				saveL.setText("Dane nie zostały zapisane.");
			}
		}

	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
