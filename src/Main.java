import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 100;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(MAX - MIN + 1) + MIN;
        int numberOfTries = 0;
        int guess = 0;
        boolean win = false;

        System.out.println("Welcome to the Guess The Number game!");
        System.out.println("I have selected a number between " + MIN + " and " + MAX + ". Can you guess it?");

        while (!win) {
            System.out.print("Enter your guess: ");
            try {
                guess = scanner.nextInt();
                numberOfTries++;

                if (guess < MIN || guess > MAX) {
                    System.out.println("Please enter a number between " + MIN + " and " + MAX + ".");
                } else if (guess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high. Try again.");
                } else {
                    win = true;
                    System.out.println("Congratulations! You've guessed the number.");
                    System.out.println("It took you " + numberOfTries + " tries.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear the invalid input
            }
        }

        scanner.close();
    }
}
