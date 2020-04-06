package application;

import java.util.ArrayList;

public class WordsList {
	
	private ArrayList<Word> wordsList;
	private ArrayList<Word> learnedWordsList;
	
	public WordsList() {
		wordsList = new ArrayList<Word>();
		learnedWordsList = new ArrayList<Word>();
	}
	
	public void addWord(Word word) {
		wordsList.add(word);
	}
	
	public void removeWord(int index) {
		if(wordsList.size() > 0) {
			wordsList.remove(index);
		}else {
			
		}
	}
	
	public void addWordToLearned(Word word) {
		learnedWordsList.add(word);
	}

	public ArrayList<Word> getWordsList() {
		return wordsList;
	}

	public void setWordsList(ArrayList<Word> wordsList) {
		this.wordsList = wordsList;
	}

	public ArrayList<Word> getLearnedWordsList() {
		return learnedWordsList;
	}

	public void setLearnedWordsList(ArrayList<Word> learnedWordsList) {
		this.learnedWordsList = learnedWordsList;
	}
	
	
	

}
