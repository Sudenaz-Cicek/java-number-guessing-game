
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        printWelcome();

        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        Scanner scanner = new Scanner(System.in);

        playRound(scanner, secretNumber);

        
        scanner.close();
    }

    public static void printWelcome() {
        System.out.println("=================================");
        System.out.println("   NUMBER GUESSING GAME");
        System.out.println("=================================");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Can you guess it?");
        System.out.println();
    }

    public static int readGuess(Scanner scanner) {
        while (true) {
            System.out.print("Guess the number (1-100): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.next(); 
                continue;       
            }

            int guess = scanner.nextInt();

            if (guess < 1 || guess > 100) {
                System.out.println("Number must be between 1 and 100!");
            } else {
                return guess; 
            }
        }
    }

    public static int playRound(Scanner scanner, int secretNumber) {

        int attempts = 0;
        int guess;

        do {
            guess = readGuess(scanner);

            if (secretNumber > guess) {
                System.out.println("Enter a higher number.");
            } else if (secretNumber < guess) {
                System.out.println("Enter a lower number.");
            } else {
                System.out.println("Correct!");
            }

            attempts++;

        } while (guess != secretNumber);

        System.out.println("Game completed in " + attempts + " attempts.");

        return attempts;
    }
    
   
}
