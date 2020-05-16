package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class HowItWorkWindow {
	
	@FXML
	private TextArea informationTA;
	@FXML
	private Button closeB;
	private String language;
	
	public HowItWorkWindow() {
		language  = LearnWindow.language;
	}
	
	@FXML
	private void initialize() {
		initCancelButton();
		initInformationTA();

	}
	
	public void initCancelButton() {
		closeB.setOnAction((event) -> {
			Stage stage = (Stage) closeB.getScene().getWindow();
			stage.close();
		});
	}
	
	public void initInformationTA() {
		if(language.equals("EN")) {
			informationTA.setText(
					"1. The program was created to help in learning new words from a foreign language."
							+ "\n2. The advantage of this program is the fact that you enter the words which you want to learn."
							+ "\n3. First add the words which you want to learn to the list."
							+ "\n4. Then press the button (Next Word) to draw the word from the list."
							+ "\n5. Enter the correct answer and check the correctness using the \"Check\" button or press enter"
							+ "\n6. To drow another word, press space bar or the (Next Word) button."
							+ "\n7. After ten correct answers in a row, the word will be considered as learned and will be moved to the list of learned words"
							+ "\n8. If the answer is incorrect, the number of correct answers will be reduced by three"
							+ "\n9. Before shutting down the program, save your status so that you don't lose progress and data"
							+ "\n10. After starting the program, the data will be loaded automatically"
					);
		}
		else {
			informationTA.setText(
					"1. Program zosta³ napisany aby pomóc w nauce s³ówek w obcym jêzyku."
							+ "\n2. Przewag¹ tego programu jest to ¿e mo¿e samemu mo¿na wprowadziæ s³ówka których chcesz siê uczyæ."
							+ "\n3. Najpierw dodaj s³ówka, których chcesz siê nauczyæ do listy."
							+ "\n4. Nastêpnie naciœnij przycisk (Nastêpny Wyraz) aby wylosowaæ wyraz do t³umaczenia."
							+ "\n5. WprowadŸ poprawn¹ odpowiedŸ i wciœnij przycisk \"SprawdŸ\" lub naciœnij enter."
							+ "\n6. Aby wylosowaæ kolejny wyraz wciœnij spacje lub przycisk (Nastêpny wyraz)."
							+ "\n7. Po dziesiêciu poprawnych odpowiedziach z rzêdu, dane s³ówko zostaje uznane za nauczone i przeniesione do listy wyrazów nauczoonych."
							+ "\n8. Jeœli odpowiedŸ nie jest poprawna, to liczba poprawnych odpowiedzi danego s³ówka zostaje zmniejszona o trzy."
							+ "\n9. Przed zamkniêciem programu nale¿y zapisaæ stan aby nie utraciæ wprowadzonych danych."
							+ "\n10. Po uruchomieniu programu dane wczytane zostan¹ automatycznie."
					);
			
		}
	}

}
