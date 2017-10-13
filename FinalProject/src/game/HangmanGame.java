package game;

import java.util.Scanner;
import java.util.Random;

/* This program is basically a hangman game but written in Java. Made for classwork/entertainment purposes only.
// It will show the gallows, add a limb each time you get it wrong, and show you the letters that you have guessed. 
Chooses a random word from the string array to use for the game */

public class HangmanGame
{
	static Scanner input = new Scanner(System.in);
	static Random random = new Random();
	static char userGuess = 0;
	//Create string array for words that are used in game. 
	static String [] words = {"royal", "heavy", "scuzz", "memes", "dizzy", "abuzz"};
	//Randomly select a word from the word array.
	static int word = random.nextInt(words.length);
	static String hiddenWord = words[word], newHiddenWord = null;
	//Number of tries will be 6 so the hangman methods can properly execute.
	static int numberOfTries = 6;
  
	public static void main(String[] args) {
		boolean wordGuessed = false, lostGame = false;
		//Make variable to be used later on, when replacing dashes in the hidden word.
		int position = 0;
		final int WORD_LENGTH = hiddenWord.length();
		char letter = 0;
		display();
		hangman();
		
    
		//Replaces all the characters in the word with "-"s
		for(int x = 0; x < hiddenWord.length(); x++)
			newHiddenWord = hiddenWord.replaceAll(".", "-");

		System.out.println();
		System.out.println(newHiddenWord);
		System.out.println("You get 5 tries before the man is hung, guess the word or ye shall be done.");
		
		//Do while loop so it at least executes once.
		do {
		System.out.println("Guess a (lowercase) letter >> ");
		userGuess = input.next().charAt(0);
		
		//For loop, this is the block of code that detects if the guess was correct or not.
		for(position = 0; position < WORD_LENGTH; ++position)
		{
			letter = hiddenWord.charAt(position);
			if(letter == userGuess)
			{
				newHiddenWord = newHiddenWord.substring(0, position) + userGuess + newHiddenWord.substring(position + 1, WORD_LENGTH);
				System.out.println(newHiddenWord);
				System.out.println("Correct!");
			}
		}
		
		//If the guessed letter is not in the word, then it leads to the other methods to show you lost a try.
		//indexOf will detect if the character is inside the string, if it isn't then it returns -1.
		if(hiddenWord.indexOf(userGuess) == -1)
		{
			numberOfTries = numberOfTries - 1;
			//If statements to display the other methods for gallows. Never repeats because the numberOfTries value always goes down by one,
			//making the code move onto the next one each time. 
			if(numberOfTries == 5)
			{
				hangmanHead();
				System.out.println(newHiddenWord);
				System.out.println("Incorrect!");
			}

			if(numberOfTries == 4)
			{
				hangmanRightArm();
				System.out.println(newHiddenWord);
				System.out.println("Incorrect!");
			}
				
			if(numberOfTries == 3)
			{
				hangmanLeftArm();
				System.out.println(newHiddenWord);
				System.out.println("Incorrect!");
			}
					
			if(numberOfTries == 2)
			{	
				hangmanRightLeg();
				System.out.println(newHiddenWord);
				System.out.println("Incorrect!");
			}
			//Ends the game by going to the losing screen
			if(numberOfTries == 1)
			{
				hangmanLeftLeg();
				lostGame = true;
				losingScreen();
			}	
		}
		
		if(newHiddenWord.equals(hiddenWord))
		{
			wordGuessed = true;
			if(wordGuessed)
			{
				victoryScreen();
			}
		}
	}while(!lostGame || wordGuessed);
	}
	
	private static void victoryScreen() {
		System.out.println("Congratulations! You won!");
		System.exit(0);
	}
	
	private static void losingScreen() {
		System.out.println("Oh, too bad! You lost! :(");
		System.out.println("The actual word was " + hiddenWord);
		System.exit(0);
	}
	
	// Used to display hangman gallows
	public static void hangman()
	{
		System.out.println("__________\r\n" + 
				"|        |\r\n" + 
				"|        |\r\n" + 
				"|     -------\r\n" + 
				"|	    \r\n" + 
				"|	       \r\n" + 
				"|     	     \r\n" + 
				"|                  \r\n" + 
				"|  	      \r\n" + 
				"|_________\r\n" + 
				"\r\n" + 
				"");

}

	public static void hangmanHead()
	{
		System.out.println("__________\r\n" + 
				"|        |\r\n" + 
				"|        |\r\n" + 
				"|     -------\r\n" + 
				"|      (-_-)\r\n" + 
				"|\r\n" + 
				"|	       \r\n" + 
				"|     	     \r\n" + 
				"|                  \r\n" + 
				"|  	      \r\n" + 
				"|_________\r\n" + 
				"\r\n" + 
				"");

		
	}
  
	public static void hangmanRightArm()
	{
		System.out.println("__________\r\n" + 
				"|        |\r\n" + 
				"|        |\r\n" + 
				"|     -------\r\n" + 
				"|      (-_-)\r\n" + 
				"|        |	\r\n" + 
				"|      / | \r\n" + 
				"|     	     \r\n" + 
				"|                  \r\n" + 
				"|  	      \r\n" + 
				"|_________\r\n" + 
				"\r\n" + 
				"");
		
	}
	
	public static void hangmanLeftArm()
	{
		System.out.println("__________\r\n" + 
				"|        |\r\n" + 
				"|        |\r\n" + 
				"|     -------\r\n" + 
				"|      (-_-)\r\n" + 
				"|        |	\r\n" + 
				"|      / | \\\r\n" + 
				"|     	     \r\n" + 
				"|                  \r\n" + 
				"|  	      \r\n" + 
				"|_________\r\n" + 
				"\r\n" + 
				"");

	}
	
	public static void hangmanRightLeg()
	{
		System.out.println("__________\r\n" + 
				"|        |\r\n" + 
				"|        |\r\n" + 
				"|     -------\r\n" + 
				"|      (-_-)\r\n" + 
				"|        |	\r\n" + 
				"|      / | \\\r\n" + 
				"|        |   \r\n" + 
				"|      /   \r\n" + 
				"|  	      \r\n" + 
				"|_________\r\n" + 
				"\r\n" + 
				"");

	}
	
	public static void hangmanLeftLeg()
	{
		System.out.println("__________\r\n" + 
				"|        |\r\n" + 
				"|        |\r\n" + 
				"|     -------\r\n" + 
				"|      (-_-)\r\n" + 
				"|        |	\r\n" + 
				"|      / | \\\r\n" + 
				"|        |   \r\n" + 
				"|      /   \\ \r\n" + 
				"|  	      \r\n" + 
				"|_________\r\n" + 
				"\r\n" + 
				"");
	}
	
	// Displays the intro to hangman, for style
	public static void display()
	{
		System.out.println(" _                                             \r\n" + 
				"| |                                            \r\n" + 
				"| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  \r\n" + 
				"| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \r\n" + 
				"| | | | (_| | | | | (_| | | | | | | (_| | | | |\r\n" + 
				"|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\r\n" + 
				"                    __/ |                      \r\n" + 
				"                   |___/                       ");
	}
}