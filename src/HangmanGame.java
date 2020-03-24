import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class HangmanGame implements IHangmanGame{	

    private List<String> wordList = new ArrayList<String>();
    private HashMap<String, Integer> existingInput = new HashMap<>();
    private String currentInput;
    private int position = -1;
    private int wordLength;
    private int countTry;
    private int maxTry;
    private char[] wordBoard;
    private boolean validateInput = false;
    private boolean validateMaxTry = false;
    private boolean validateShowRemain = false;
    private boolean validateLetterInput = false;
    private boolean showWordRemain = false;
	
    
    @Override
	public List<String> createWordList() {
		
		Words words = new Words();
		String[] wholeWords = words.getWords();
		
		for(int i = 0; i < wholeWords.length; ++i) {
			if(this.wordList.size() < MAXIMUM_SIZE) {
				if(wholeWords[i].length() == this.wordLength) {
					this.wordList.add(wholeWords[i]);
				}
			}
			else {
				break;
			}
		}
		return wordList;
	}
	
	@Override
	public void validateInput(int input) {
		if(input > 29 || input < 1) {
			throw new IllegalArgumentException();
		}
		
		this.wordLength = input;
		this.createWordList();
		
		if(this.wordList.size() == 0) {
			this.wordLength = 0;
			System.out.println("No word of your length is in the dictionay");
			throw new IllegalArgumentException();
		}
		
		this.validateInput = true;
		this.setWordLength(input);
	}
	
	
	@Override
	public void validateMaxTry(int input) {
		if(input <= 0) {
			throw new IllegalArgumentException();
		}
		this.validateMaxTry = true;
		this.setMaxTry(input);
	}
	
	
	@Override
	public void validateShowRemain(String input) {
		if(!input.equals("yes") && !input.equals("no")) {
			throw new IllegalArgumentException();
		}
		
		this.validateShowRemain = true;
		if(input.equals("yes")) {
			this.showWordRemain = true;
		}
		else {
			this.showWordRemain = false;
		}
	}

	@Override
	public void validateLetterInput(String input) {
		if(input.length() > 1) {
			System.out.println("Not a single letter:");
			throw new IllegalArgumentException();
		}
		if(input.charAt(0) < 'A' || input.charAt(0) > 'z') {
			System.out.println("Not an alphabet letter");
			throw new IllegalArgumentException();
		}
		if(existingInput.get(input.toLowerCase()) != null) {
			System.out.println("The letter has been guessed");
			throw new IllegalArgumentException();
		}
		
		this.validateLetterInput = true;
		existingInput.put(input.toLowerCase(), 0);
		this.currentInput = input.toLowerCase();
	}
	
	
	@Override
	public char[] createWordState() {
		
		this.wordBoard = new char[this.wordLength];
		helper(0);
		
		return wordBoard;
	}
	
	private void helper(int index) {
		if(index == wordLength) {
			return;
		}
		this.wordBoard[index] = '_';
		helper(index + 1);
	}


	@Override
	public char[] updateWordState() {
		
		if(position != -1) {
			wordBoard[position] = this.currentInput.charAt(0);
		}
		
		countTry++;
		position = -1;
		return wordBoard;
	}
	

	@Override
	public int getLetterPosition(String currentInput) {
		
		int[] positionArray = new int[this.wordLength];
		for(String s: wordList) {
			char[] c = s.toCharArray();
			for(int i = 0; i < c.length; i++) {
				if(c[i] == this.currentInput.charAt(0)) {
					positionArray[i]++;
				}
			}
			
		}
		int maxIndex = 0;
		for(int i = 0; i < this.wordLength; ++i) {			
			if(positionArray[i] > positionArray[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	
	@Override
	public void updateWordList() {
		
	    List<String> newWordList = new ArrayList<String>();
		for(String s : wordList) {
			if(!s.contains(this.currentInput)) {
				newWordList.add(s);
			}
		}
		if(newWordList.size() != 0) {
			wordList = newWordList;
			return;
		}
		else{
			this.position = this.getLetterPosition(this.currentInput);
			for(Iterator<String> iterator = wordList.iterator(); iterator.hasNext();) {
				String s = iterator.next();
				if(s.charAt(position) != this.currentInput.charAt(0)) {
					iterator.remove();
				}
			}
		}	
	}

	
	@Override
	public boolean isGameWon() {
		
		if(exceedMaxTry()) {
			return false;
		}
		else {
			for(char c: wordBoard) {
				if(c == '_') {
					return false;
				}
			}
			return true;
		}
		
	}


	@Override
	public boolean exceedMaxTry() {
		return countTry >= maxTry;
	}
	
	@Override
	public int getLength() {
		return this.wordLength;
	}
	
	@Override
	public void setWordLength(int length) {
		this.wordLength = length;
	}
	
	@Override
	public boolean validateInput() {
		return this.validateInput;
	}
	
	@Override
	public int getMax() {
		return this.maxTry;
	}
	
	@Override
	public void setMaxTry(int input) {
		this.maxTry = input;
	}
	
	@Override
	public boolean validateMaxTry() {
		return this.validateMaxTry;
	}
	@Override
	public boolean getShowRemain() {
		return this.showWordRemain;
	}
	
	@Override
	public boolean validateShowRemain() {
		return this.validateShowRemain;
	}
	
	
	@Override
	public String getCurrentInput() {
		return this.currentInput;
	}
	
	@Override
	public void setCurrentInput(String input) {
		this.currentInput = input;
	}
	
	@Override
	public boolean validateLetterInput() {
		return this.validateLetterInput;
	}
	
	@Override
	public void setValidateLetterInput(boolean input) {
		this.validateLetterInput = input;
	}
	
	@Override
	public List<String> getWordList() {
		return this.wordList;
	}
	
	@Override
	public HashMap<String, Integer> getExistingInput(){
		return this.existingInput;
	}
	
	
	@Override
	public char[] loadWordBoard() {
		return this.wordBoard;
	}
	
	@Override
	public void setWordBoard(char[] board) {
		this.wordBoard = board;
	}
	
	@Override
	public void setPosition(int index) {
		this.position = index;
	}
	
	@Override
	public int getPosition() {
		return this.position;
	}

	
	@Override
	public int getCountTry() {
		return this.countTry;
	}

}