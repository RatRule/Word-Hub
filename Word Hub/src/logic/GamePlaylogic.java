package logic;

import java.util.ArrayList;
import java.util.Collections;

import data.UserDataAccess;
import data.WordDataAccess;
import entities.Labels;
import entities.UserEntity;

public class GamePlaylogic {
	String category;
	String level;
	String currentWord;
	private int currentScore=0;
	ArrayList<String> completedWordList;
	
	
	public GamePlaylogic(String category,String level) {
		this.category=category;
		this.level=level;
		
	}
	public String getWord() {
		WordDataAccess word=new WordDataAccess();
		currentWord=word.getRandomWord(category, level);
		String rWord=randomize(currentWord);
		return rWord;

	}
	
	private String randomize(String word) {
		char[] wordArray=word.toCharArray();
		ArrayList<Character> array = new ArrayList<Character>();
		for(int i=0;i<wordArray.length;i++) {
			array.add(wordArray[i]);
		}
		Collections.shuffle(array);
		for(int i=0;i<array.size();i++)
			wordArray[i]=array.get(i);
		return(String.valueOf(wordArray));
		
	}
	public boolean checkWord(String userText) {
		if(userText.equals(currentWord)) {
			return true;
		}
		else return false;
	}
	
	public static void main(String[] args) {
		GamePlaylogic obj = new GamePlaylogic("", "");
		System.out.println(obj.randomize("Lion"));
	}
	public int getCurrentScore() {
		return currentScore;
	}
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	public void updateScore() {
		if(level.equals(Labels.Levels.LEVEL1))
			currentScore=currentScore + 2 ;
		else if(level.equals(Labels.Levels.LEVEL2))
			currentScore=currentScore + 4 ;
		else if(level.equals(Labels.Levels.LEVEL3))
			currentScore=currentScore + 6 ;
			
	}
	public void updateHighScore() {
		UserEntity user = new UserDataAccess().getUser(Session.getUserId());
		if(currentScore>user.getHighScore()) {
			user.setHighScore(currentScore);
			UserDataAccess userData=new UserDataAccess();
			userData.updateHighScore(Session.getUserId(), user.getHighScore());
		}
	}
	
	
}