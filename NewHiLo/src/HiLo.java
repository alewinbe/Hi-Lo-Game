import java.util.Scanner;

public class HiLo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String playAgain = "";
		do {

			// Create a random number for the user to guess
			int theNumber = (int)(Math.random() * 100 + 1);
			System.out.println(theNumber);
			int guess = 0;
			int numberofTries = 0;
			while (guess != theNumber) {
				numberofTries = numberofTries + 1;
				System.out.println("Guess a number between 1 and 100: ");
				guess = scan.nextInt();
				System.out.println("You guessed: " + guess + ".");
				if (guess < theNumber) 
					System.out.println(guess + " is too low. Try again.");
				else if (guess > theNumber)
					System.out.println(guess + " is too high. Try again.");
				else 
					System.out.println("That's right! The number was: " + theNumber + ".");
					System.out.println("It took you: " + numberofTries + " " + "tries.");
			} // end of while loop for guessing
			System.out.println("Play again (y/n)?");
			playAgain = scan.next();
		} while (playAgain.equalsIgnoreCase("y"));
		System.out.println("Thanks for playing!");
		scan.close();
	}
}
