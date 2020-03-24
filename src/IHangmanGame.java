
import java.util.HashMap;
import java.util.List;

/**
 * @author yanya
 *
 */

public interface IHangmanGame {
	
	public static final int MAXIMUM_SIZE = 200;
	
	/**
	 * construct an array of words with the length of user input
	 * The maximum length of the array cannot exceed MAXIMUM_LENGTH
	 * @return 
	 */
	public char[] createWordState();
	
	/**
	 * update the word board when user guess
	 */
	public char[] updateWordState();
	
	/**
	 * create a word list include all the words in the dictionary with the length
	 * of user input.  
	 * @return 
	 */
	public List<String> createWordList();
	
	/** 
	 * check if the length is valid.
	 * (1) the word length should be less than or equal to 29, larger than 0
	 * (2) the word length can not fall into the "gaps" in the dictionary
	 * if the input is valid, set wordLength as input
	 * @param input the word length people input
	 * @throws IllegalArgumentException if the input is invalid
	 */
	public void validateInput(int input);
	
	/**
	 * check if the max number is valid
	 * the number must be larger than 0
	 * if input is valid, set maxTry as input
	 * @param input the max number to try
	 * @throws IllegalArgumentException if the input is invalid
	 */
	public void validateMaxTry(int input);
	
	/**
	 * check if the string input is valid
	 * the input must be "yes" or "no"
	 * if input is "yes", set showWordRemain as true
	 * @param input whether the user wants to show word remain
	 * @throws IllegalArgumentException if the input is invalid
	 */
	public void validateShowRemain(String input);
	
	/**
	 * check if the string input is valid
	 * the input must be a single letter
	 * if input is valid, set currentInput as input
	 * @param input the letter user guess
	 * @throws IllegalArgumentException if the input is invalid
	 */
	public void validateLetterInput(String input);
	
	/**
	 * update the word list after each time of user input
	 * the update method should follow: 
	 * (1) remove the words containing the letter user guesses
	 * (2) if all of the words containing the letter, calculated the number of times 
	 * the letter occurred in each position. Keep the words with letter in the specific 
	 * position and remove the rest in the word list.
	 */
	public void updateWordList();
 	
	
	/**
	 * count the letter's occurrence times in each of the position
	 * @return maxIndex The index of position with highest frequency the letter occur
	 */
	public int getLetterPosition(String currentInput);
	
	/**
	 * If the user still have remaining guesses and each letter in the word has been guessed
	 * out by the user, then the user win.
	 * Otherwise lose
	 * @return true if the user won the game, false otherwise.
	 */
	public boolean isGameWon();
	
	/**
	 * @return true if the user run out of their guesses, false otherwise.
	 */
	public boolean exceedMaxTry();	
	
	/**
	 * get the current word list containing the words user need to guess from
	 * @return the current WordList.
	 */
	public List<String> getWordList();

	
	/**
	 * Gets the wordLength.
	 * @return the wordLength to guess.
	 */
	public int getLength();
	
	/**
	 * Gets the max try number.
	 * @return the max try number.
	 */
	public int getMax();
	
	/**
	 * Sets the max try.
	 * @param input the max number to try
	 */
	public void setMaxTry(int input);
	
	/**
	 * Gets current letter input.
	 * @return the current letter input.
	 */
	public String getCurrentInput();
	
	/**
	 * Sets word length.
	 * @param length the word length.
	 */
	public void setWordLength(int length);
	
	/**
	 * Gets current word board.
	 * @return the current word board.
	 */
	public char[] loadWordBoard();
	
	/**
	 * Sets the word board.
	 * @param board the word board
	 */
	public void setWordBoard(char[] board);
	
	/**
	 * Sets the position.
	 * @param index the position index
	 */
	public void setPosition(int index);
	
	/**
	 * Gets the position.
	 * @return the position index.
	 */
	public int getPosition();
	
	/**
	 * Sets the current input.
	 * @param input the current input
	 */
	public void setCurrentInput(String input) ;
	
	/**
	 * Gets the current number of try times.
	 * @return the current number of try times.
	 */
	public int getCountTry();
	
	/**
	 * Gets whether the input is valid.
	 * @return the true or false state of the input.
	 */
	public boolean validateInput();
	
	/**
	 * Gets whether the input is valid.
	 * @return the true or false state of the input.
	 */
	public boolean validateMaxTry();
	
	/**
	 * Gets the true or false state of showRemain.
	 * @return the true or false state of showRemain.
	 */
	public boolean getShowRemain();
	
	/**
	 * Gets whether the input is valid.
	 * @return the true or false state of the input.
	 */
	public boolean validateShowRemain();

	/**
	 * Gets whether the letter input is valid.
	 * @return the true or false state of the input.
	 */
	public boolean validateLetterInput();
	
	/**
	 * Gets the hash map of existing input letter.
	 * @return hash map of existing letter input.
	 */
	public HashMap<String, Integer> getExistingInput();
	
	/**
	 * Sets the state of whether LetterInput is validate.
	 * @param input the current input
	 */
	void setValidateLetterInput(boolean input);

}