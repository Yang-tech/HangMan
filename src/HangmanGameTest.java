import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/**
 * @author yanya
 *
 */
public class HangmanGameTest {
	
	/**
	 * create the new HangmanGame object and test the method "getWordList"
	 * can return the correct value
	 */
	@Test
	public final void testGetWordList() {
		HangmanGame hangman = new HangmanGame();
		assertEquals(0, hangman.getWordList().size());
	}
	
	
	/**
	 * create the new HangmanGame object and test the method "createWordList"
	 * can create the word list according to word length correctly
	 */
	@Test
	public final void testCreateWordList() {
		HangmanGame hangman = new HangmanGame();

		hangman.setWordLength(5);
		hangman.createWordList();
		assertEquals(200, hangman.getWordList().size());
		
		HangmanGame anotherHangman = new HangmanGame();
		anotherHangman.setWordLength(29);
		anotherHangman.createWordList();
		assertEquals(1, anotherHangman.getWordList().size());
	}
	
	
	/**
	 * create the new HangmanGame object and test the method "getLength"
	 * can return the correct value
	 */
	@Test
	public void testGetLength() {
		HangmanGame hangman = new HangmanGame();
		assertEquals(0, hangman.getLength());
	}
	
	
	/**
	 * create the new HangmanGame object and test the method "setLength"
	 * can set the value to word length correctly
	 */
	@Test
	public void testSetLength() {
		HangmanGame hangman = new HangmanGame();
		hangman.setWordLength(5);
		assertEquals(5, hangman.getLength());
	}
	
	
	/**
	 * create the new HangmanGame object and test the method "validateInput"
	 * if input is valid, the method should set word length as input
	 */
	@Test
	public final void testValidateInput() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateInput(5);
		assertEquals(5, hangman.getLength());
	}
	
	/**
	 * create the new HangmanGame object and test whether the method "validateInput"
	 * can throw the correct IllegalArgumentException when input is invalid 
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testValidateInputException1() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateInput(0);
	}
	
	/**
	 * create the new HangmanGame object and test whether the method "validateInput"
	 * can throw the correct IllegalArgumentException when input is invalid 
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testValidateInputException2() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateInput(-5);
	}
	
	/**
	 * create the new HangmanGame object and test whether the method "validateInput"
	 * can throw the correct IllegalArgumentException when input is invalid 
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testValidateInputException3() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateInput(30);
	}
	
	/**
	 * create the new HangmanGame object and test whether the method "validateInput"
	 * can throw the correct IllegalArgumentException when input is invalid 
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testValidateInputException4() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateInput(26);
	}
	
	/**
	 * create the new HangmanGame object and test whether the method "validateInput"
	 * can throw the correct IllegalArgumentException when input is invalid 
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testValidateInputException5() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateInput('a');
	}

	/**
	 * create the new HangmanGame object and test the method "getMax"
	 * can return the correct value
	 */
	@Test
	public void testGetMax() {
		HangmanGame hangman = new HangmanGame();
		assertEquals(0, hangman.getMax());
	}
	
	
	/**
	 * create the new HangmanGame object and test the method "setMaxTry"
	 * can set the value to max try correctly
	 */
	@Test
	public void testSetMaxTry() {
		HangmanGame hangman = new HangmanGame();
		hangman.setMaxTry(5);
		assertEquals(5, hangman.getMax());
	}
	
	/**
	 * create the new HangmanGame object and test the method "validateMaxTry".
	 * if input is valid, the method should set max try as input
	 */
	@Test
	public final void testValidateMaxTry() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateMaxTry(5);
		assertEquals(5, hangman.getMax());
	}
	
	/**
	 * create the new HangmanGame object and test whether the method "validateMaxTry"
	 * can throw the correct IllegalArgumentException when input is invalid 
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testValidateMaxTryException() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateMaxTry(0);
	}
	
	/**
	 * create the new HangmanGame object and test whether the method "validateMaxTry"
	 * can throw the correct IllegalArgumentException when input is invalid 
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testValidateMaxTryException1() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateMaxTry(-5);
	}
	
	
	/**
	 * create the new HangmanGame object and test the method "validateInput"
	 * can return the correct value
	 */
	@Test
	public void testGetValidateInput() {
		HangmanGame hangman = new HangmanGame();
		assertFalse(hangman.validateInput());
	}
	
	/**
	 * create the new HangmanGame object and test the method "validateMaxTry"
	 * can return the correct value
	 */
	@Test
	public void testGetValidateMaxTry() {
		HangmanGame hangman = new HangmanGame();
		assertFalse(hangman.validateMaxTry());
	}
	
	/**
	 * create the new HangmanGame object and test the method "validateShowRemain"
	 * can return the correct value
	 */
	@Test
	public void testGetValidateShowRemain() {
		HangmanGame hangman = new HangmanGame();
		assertFalse(hangman.validateShowRemain());
	}
	
	
	/**
	 * create the new HangmanGame object and test the method "getShowRemain"
	 * can return the correct value
	 */
	@Test
	public void testGetShowRemain() {
		HangmanGame hangman = new HangmanGame();
		assertFalse(hangman.getShowRemain());
	}
	
	
	/**
	 * create the new HangmanGame object and test the method "validateShowRemain".
	 * if input is yes, the method should set showRemain as true
	 */
	@Test
	public final void testValidateShowRemain() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateShowRemain("yes");
		assertTrue(hangman.getShowRemain());
	}
	
	/**
	 * create the new HangmanGame object and test the method "validateShowRemain".
	 * if input is no, the method should set showRemain as false
	 */
	@Test
	public final void testValidateShowRemain2() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateShowRemain("no");
		assertFalse(hangman.getShowRemain());
	}
	
	/**
	 * create the new HangmanGame object and test whether the method "validateMaxTry"
	 * can throw the correct IllegalArgumentException when input is invalid 
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testValidateShowRemainException() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateShowRemain("yee");
	}
	
	/**
	 * create the new HangmanGame object and test the method "validateLetterInput"
	 * can return the correct value
	 */
	@Test
	public void testGetValidateLetterInput() {
		HangmanGame hangman = new HangmanGame();
		assertFalse(hangman.validateLetterInput());
	}
	
	
	/**
	 * create the new HangmanGame object and test the method "seetValidateLetterInput"
	 * can set the position correctly
	 */
	@Test
	public final void testSetValidateLetterInput() {
		HangmanGame hangman = new HangmanGame();
		hangman.setValidateLetterInput(true);
		assertTrue(hangman.validateLetterInput());
	}
	
	/**
	 * Test method for {@link HangmanGame#validateInput(int)}.
	 */
	@Test
	public void testGetCurrentInput() {
		HangmanGame hangman = new HangmanGame();
		assertEquals(null, hangman.getCurrentInput());
	}
	
	
	/**
	 * create the new HangmanGame object and test the method "setCurrentInput"
	 * can set the value to currentInput correctly
	 */
	@Test
	public void testSetCurrentInput() {
		HangmanGame hangman = new HangmanGame();
		hangman.setCurrentInput("a");
		assertEquals("a", hangman.getCurrentInput());
	}
	
	/**
	 * create the new HangmanGame object and test the method "validateLetterInput"
	 * if input is valid, the method should set currentInput as input
	 */
	@Test
	public final void testValidateLetterInput() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateLetterInput("a");
		assertEquals("a", hangman.getCurrentInput());
	}
	
	/**
	 * create the new HangmanGame object and test the method "validateLetterInput"
	 * if input is upper case, the method should set currentInput as lower case
	 */
	@Test
	public final void testValidateLetterInput2() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateLetterInput("Z");
		assertEquals("z", hangman.getCurrentInput());
	}
	
	/**
	 * create the new HangmanGame object and test whether the method "validateLetterInput"
	 * can throw the correct IllegalArgumentException when input is invalid 
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testValidateLetterInputException1() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateLetterInput("ab");
	}
	
	/**
	 * create the new HangmanGame object and test whether the method "validateLetterInput"
	 * can throw the correct IllegalArgumentException when input is invalid 
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testValidateLetterInputException2() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateLetterInput("0");
	}
	
	/**
	 * create the new HangmanGame object and test whether the method "validateLetterInput"
	 * can throw the correct IllegalArgumentException when input is invalid 
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testValidateLetterInputException3() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateLetterInput("~");
	}
	
	/**
	 * create the new HangmanGame object and test whether the method "validateLetterInput"
	 * can throw the correct IllegalArgumentException when input is invalid 
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testValidateLetterInputException() {
		HangmanGame hangman = new HangmanGame();
		hangman.validateLetterInput("a");
		//when the letter has been guessed, it's also an invalid input
		hangman.validateLetterInput("a");
	}
	
	/**
	 * create the new HangmanGame object and test the method "loadWordBoard"
	 * can get the word board correctly
	 */
	@Test
	public void testLoadWordBoard() {
		HangmanGame hangman = new HangmanGame();
		assertEquals(null, hangman.loadWordBoard());
	}
	
	/**
	 * create the new HangmanGame object and test the method "getExistingInput"
	 * can get existingInput correctly
	 */
	@Test
	public void testGetExistingInput() {
		HangmanGame hangman = new HangmanGame();
		HashMap<String, Integer> existingInput = new HashMap<>();
		assertEquals(existingInput, hangman.getExistingInput());
	}
	
	
	/**
	 * create the new HangmanGame object and test the method "setWordBoard"
	 * can set the board correctly
	 */
	@Test
	public void testSetWordBoard() {
		HangmanGame hangman = new HangmanGame();
		char[] board = {'_', '_', '_', '_', '_'};
		hangman.setWordBoard(board);
		assertArrayEquals(board, hangman.loadWordBoard());
	}
	
	/**
	 * create the new HangmanGame object and test the method "createWordState"
	 * can set the word board according to word length correctly
	 */
	@Test
	public final void testCreateWordState() {
		HangmanGame hangman = new HangmanGame();
		hangman.setWordLength(5);
		char[] board = {'_', '_', '_', '_', '_'};
		assertArrayEquals(board, hangman.createWordState());
	}
	
	/**
	 * create the new HangmanGame object and test the method "getPosition"
	 * can return the correct value
	 */
	@Test
	public final void testGetPosition() {
		HangmanGame hangman = new HangmanGame();
		assertEquals(-1, hangman.getPosition());
	}
	
	/**
	 * create the new HangmanGame object and test the method "setPosition"
	 * can set the position correctly
	 */
	@Test
	public final void testSetPosition() {
		HangmanGame hangman = new HangmanGame();
		hangman.setPosition(1);
		assertEquals(1, hangman.getPosition());
	}
	
	/**
	 * create the new HangmanGame object and test the method "getLetterPosition"
	 * can return the correct value
	 */
	@Test
	public final void testGetLetterPosition() {
		HangmanGame hangman = new HangmanGame();
		hangman.setWordLength(22);
		hangman.createWordList();
		hangman.createWordState();
		hangman.setCurrentInput("s");
		assertEquals(21, hangman.getLetterPosition("s"));
	}
	
	/**
	 * create the new HangmanGame object and test the method "updateWordState"
	 * can update the word board correctly with user input
	 */
	@Test
	public final void testUpdateWordState() {
		HangmanGame hangman = new HangmanGame();
		hangman.setWordLength(5);
		hangman.createWordState();
		hangman.setCurrentInput("a");
		hangman.setPosition(1);
		char[] board = {'_', 'a', '_', '_', '_'};
		hangman.updateWordState();
		assertArrayEquals(board, hangman.loadWordBoard());
		
		hangman.setWordLength(5);
		hangman.createWordState();
		hangman.setPosition(-1);
		char[] newBoard = {'_', '_', '_', '_', '_'};
		hangman.updateWordState();
		assertArrayEquals(newBoard, hangman.loadWordBoard());
	}


	/**
	 * create the new HangmanGame object and test the method "upateWordList"
	 * can update the word list according to user input correctly
	 */
	@Test
	public final void testUpdateWordList() {
		HangmanGame hangman = new HangmanGame();
		hangman.setWordLength(22);
		hangman.createWordList();
		hangman.setCurrentInput("m");
		hangman.updateWordList();
		assertEquals(1, hangman.getWordList().size());
		
		HangmanGame anotherHangman = new HangmanGame();
		anotherHangman.setWordLength(22);
		anotherHangman.createWordList();
		anotherHangman.setCurrentInput("s");
		anotherHangman.updateWordList();
		assertEquals(2, anotherHangman.getWordList().size());
	}
	


	/**
	 * create the new HangmanGame object and test the method "isGameWon"
	 * can return the correct win/lose state of game
	 */
	@Test
	public final void testIsGameWon() {
		HangmanGame hangman = new HangmanGame();
		hangman.setMaxTry(1);
		hangman.setWordLength(22);
		hangman.createWordList();
		hangman.setCurrentInput("m");
		hangman.createWordState();
		hangman.updateWordState();
		assertFalse(hangman.isGameWon());
		
		HangmanGame anotherHangman = new HangmanGame();
		anotherHangman.setMaxTry(2);
		anotherHangman.setWordLength(5);
		char[] board = {'a', 'p', 'p', 'l', 'e'};
		anotherHangman.setWordBoard(board);
		assertTrue(anotherHangman.isGameWon());
		
		HangmanGame aHangman = new HangmanGame();
		aHangman.setMaxTry(2);
		aHangman.setWordLength(5);
		char[] aBoard = {'_', 'p', 'p', 'l', 'e'};
		aHangman.setWordBoard(aBoard);
		assertFalse(aHangman.isGameWon());
	}

	/**
	 * create the new HangmanGame object and test the method "exceedMaxTry"
	 * can return the correct value of whether the user exceed max try
	 */
	@Test
	public final void testExceedMaxTry() {
		HangmanGame hangman = new HangmanGame();
		hangman.setMaxTry(2);
		hangman.setWordLength(22);
		hangman.createWordList();
		hangman.setCurrentInput("m");
		hangman.updateWordState();
		assertFalse(hangman.exceedMaxTry());
		
		hangman.setCurrentInput("s");
		hangman.updateWordState();
		assertTrue(hangman.exceedMaxTry());
	}

	/**
	 * create the new HangmanGame object and test the method "getCountTry"
	 * can return the correct value
	 */
	@Test
	public void testGetCountTry() {
		HangmanGame hangman = new HangmanGame();
		assertEquals(0, hangman.getCountTry());
	}

}
