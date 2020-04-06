package application;

public class Word {
	
	private String yourWord;
	private String yourTranslation1 = " ";
	private String yourTranslation2 = " ";
	private String yourTranslation3 = " ";
	private int totalShowCounter = 0;
	private int correctCounter = 0;
	private int incorrectCounter = 0;
	
	public Word(String yourWord, String yourTranslation1) {
		this.yourWord = yourWord;
		this.yourTranslation1 = yourTranslation1;
	}
	public Word(String yourWord, String yourTranslation1, String yourTranslation2) {
		this.yourWord = yourWord;
		this.yourTranslation1 = yourTranslation1;
		this.yourTranslation2 = yourTranslation2;
	}
	public Word(String yourWord, String yourTranslation1, String yourTranslation2, String yourTranslation3) {
		this.yourWord = yourWord;
		this.yourTranslation1 = yourTranslation1;
		this.yourTranslation2 = yourTranslation2;
		this.yourTranslation3 = yourTranslation3;
	}
	
	public String toString() {
		if(!yourTranslation2.equals(" ") && !yourTranslation3.equals(" ")) {
			return yourWord + " - " + yourTranslation1 + ", " +  yourTranslation2 + ", " + yourTranslation3;
		}else if((!yourTranslation2.equals(" "))) {
			return yourWord + " - " + yourTranslation1 + ", " +  yourTranslation2;
		}else{
			return yourWord + " - " + yourTranslation1;
		}
	}
	
	public String onlyTranslation() {
		if(!yourTranslation2.equals(" ") && !yourTranslation3.equals(" ")) {
			return yourTranslation1 + ", " +  yourTranslation2 + ", " + yourTranslation3;
		}else if((!yourTranslation2.equals(" "))) {
			return yourTranslation1 + ", " +  yourTranslation2;
		}else{
			return yourTranslation1;
		}
	}
	
	public void addOneToCorrect() {
		correctCounter++;
		totalShowCounter++;
	}
	
	public void addOneToIncorrect() {
		incorrectCounter++;
		totalShowCounter++;
		if(correctCounter > 2) {
			correctCounter -=3;
		}
	}
	
	public String getYourWord() {
		return yourWord;
	}
	public void setYourWord(String yourWord) {
		this.yourWord = yourWord;
	}
	public String getYourTranslation1() {
		return yourTranslation1;
	}
	public void setYourTranslation1(String yourTranslation1) {
		this.yourTranslation1 = yourTranslation1;
	}
	public String getYourTranslation2() {
		return yourTranslation2;
	}
	public void setYourTranslation2(String yourTranslation2) {
		this.yourTranslation2 = yourTranslation2;
	}
	public String getYourTranslation3() {
		return yourTranslation3;
	}
	public void setYourTranslation3(String yourTranslation3) {
		this.yourTranslation3 = yourTranslation3;
	}
	public int getTotalShowCounter() {
		return totalShowCounter;
	}
	public void setTotalShowCounter(int totalShowCounter) {
		this.totalShowCounter = totalShowCounter;
	}
	public int getCorrectCounter() {
		return correctCounter;
	}
	public void setCorrectCounter(int correctCounter) {
		this.correctCounter = correctCounter;
	}
	public int getIncorrectCounter() {
		return incorrectCounter;
	}
	public void setIncorrectCounter(int incorrectCounter) {
		this.incorrectCounter = incorrectCounter;
	}
	
	
	
	
	
	

}
