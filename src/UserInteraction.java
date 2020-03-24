import java.util.Scanner;

/**
 * @author yanya
 *
 */
public class UserInteraction{
	
	/**
	 * Ask the user to input a word length. Must check if the length is valid.
	 * @param hangman the object of HangmanGame
	 */
	public void getWordLength(HangmanGame hangman) {
		
		System.out.println("Please enter the word length:");
		Scanner scan = new Scanner(System.in);
		int input = 0;
		 
		do {
			while(!scan.hasNextInt()) {
				System.out.println("Please enter a valid word length:");
				scan.next();
			}
			
			input = scan.nextInt();
			try {
				hangman.validateInput(input);
			}
			catch (IllegalArgumentException e) {
				System.out.println("Please enter a valid word length:");
			} 

		} while(!hangman.validateInput());
		
		
	}
	
	/**
	 * Ask the user to input a number. check if the input is valid
	 * @param hangman the object of HangmanGame
	 */
	
	public void getMaxTry(HangmanGame hangman) {
		System.out.println("Please enter the number of times to try:");
		Scanner scan = new Scanner(System.in);
		int input = 0;
		
		do {
			while(!scan.hasNextInt()) {
				System.out.println("Please enter a valid max try:");
				scan.next();
			}
			
			input = scan.nextInt();
			try {
				hangman.validateMaxTry(input);
			}
			catch (IllegalArgumentException e){
				System.out.println("Please enter a valid number:");
			}
		} while(!hangman.validateMaxTry()) ;
		
	}
	
	/**
	 * Ask the user to input whether they want to show a running total of remaining words.
	 * @param hangman the object of HangmanGame
	 */
	public void showRemain(HangmanGame hangman){
		System.out.println("Do you want to have a running total of remaining number? Enter yes or no");
		Scanner scan = new Scanner(System.in);
		String input = null;

		while (!hangman.validateShowRemain()) {
			input = scan.next();
			try {
				hangman.validateShowRemain(input);
			}
			catch (IllegalArgumentException e){
				System.out.println("Please type yes or no:");
			}
		}
		
	}
	
	/**
	 * Ask the user to input a single letter, if the user enters a letter guesses before, 
	 * ask again until the user enters a letter that they haven't guessed yet. 
	 * Must check if the input is valid
	 * @param hangman the object of HangmanGame
	 */
	public void getUserInput(HangmanGame hangman) {
		System.out.println("Please enter the letter you guess:");
		Scanner scan = new Scanner(System.in);
		String input = null;
		
		hangman.setValidateLetterInput(false);
		while(! hangman.validateLetterInput()) {
			input = scan.next();
			try {
				hangman.validateLetterInput(input);
			}
			catch (IllegalArgumentException e){
				System.out.println("Please enter a valid letter:");
			}
		}
		
	}
	
	/**
	 * Print out how many guesses the user has remaining, along with any letters the 
	 * player has guessed and the current blanked-out version of the word. If the user 
	 * chose earlier to see the number of words remaining, print that out too.
	 * @param hangman the object of HangmanGame
	 */
	public void printUserState(HangmanGame hangman) {
		int remain = hangman.getMax() - hangman.getCountTry();
		System.out.println("Your remaining guesses:" + remain);
		System.out.println("You have guessed: ");
		for(String s: hangman.getExistingInput().keySet()) {
			System.out.println(s);
		}
		System.out.println("Your current guessed state: ");
		for(char c: hangman.loadWordBoard()) {
			System.out.print(c);
			System.out.print(" ");
		}
		System.out.println();
		if(hangman.getShowRemain()) {
			System.out.println("The words remaining is: " + hangman.getWordList().size());
		}
	}
}

