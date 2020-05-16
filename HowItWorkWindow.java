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
					"1. Program został napisany aby pomóc w nauce słówek w obcym języku."
							+ "\n2. Przewagą tego programu jest to że może samemu można wprowadzić słówka których chcesz się uczyć."
							+ "\n3. Najpierw dodaj słówka, których chcesz się nauczyć do listy."
							+ "\n4. Następnie naciśnij przycisk (Następny Wyraz) aby wylosować wyraz do tłumaczenia."
							+ "\n5. Wprowadź poprawną odpowiedź i wciśnij przycisk \"Sprawdź\" lub naciśnij enter."
							+ "\n6. Aby wylosować kolejny wyraz wciśnij spacje lub przycisk (Następny wyraz)."
							+ "\n7. Po dziesięciu poprawnych odpowiedziach z rzędu, dane słówko zostaje uznane za nauczone i przeniesione do listy wyrazów nauczoonych."
							+ "\n8. Jeśli odpowiedź nie jest poprawna, to liczba poprawnych odpowiedzi danego słówka zostaje zmniejszona o trzy."
							+ "\n9. Przed zamknięciem programu należy zapisać stan aby nie utracić wprowadzonych danych."
							+ "\n10. Po uruchomieniu programu dane wczytane zostaną automatycznie."
					);
			
		}
	}

}
