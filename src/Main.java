
public class Main {
	public static void main(String[] args) {
		HangmanGame hangman = new HangmanGame();
		UserInteraction userInput = new UserInteraction();
		userInput.getWordLength(hangman);			
		userInput.getMaxTry(hangman);
		userInput.showRemain(hangman);
		hangman.createWordState();
		
		while(!hangman.exceedMaxTry() && !hangman.isGameWon()) {		
				userInput.printUserState(hangman);
				userInput.getUserInput(hangman);
				hangman.updateWordList();
				hangman.updateWordState();
				if(hangman.isGameWon()) {
					System.out.println("Congratulation! You have won the game!");
					return;
				}
		}
		System.out.println("Game over. The correct word is " + hangman.getWordList().get(0));
	}
}