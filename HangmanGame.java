import java.util.Scanner;

public class HangmanGame {
    private String[] words = {"java", "python", "ruby", "javascript"};
    private String wordToGuess;
    private StringBuilder currentGuess;
    private int numGuesses;
    private int maxGuesses = 6;
    private char[] guessedLetters;
    
    public HangmanGame() {
        wordToGuess = words[(int) (Math.random() * words.length)];
        currentGuess = new StringBuilder("-".repeat(wordToGuess.length()));
        guessedLetters = new char[26];
    }
    
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (numGuesses < maxGuesses && currentGuess.indexOf("-") != -1) {
            System.out.println("Current guess: " + currentGuess);
            System.out.println("Guess a letter: ");
            char guess = scanner.next().charAt(0);
            if (isGuessed(guess)) {
                System.out.println("You already guessed that letter. Try again.");
                continue;
            }
            guessedLetters[numGuesses] = guess;
            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    currentGuess.setCharAt(i, guess);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Incorrect guess!");
                numGuesses++;
            } else {
                System.out.println("Correct guess!");
            }
        }
        if (numGuesses == maxGuesses) {
            System.out.println("You lost! The word was " + wordToGuess);
        } else {
            System.out.println("Congratulations! You guessed the word " + wordToGuess);
        }
    }
    
    private boolean isGuessed(char guess) {
        for (int i = 0; i < numGuesses; i++) {
            if (guessedLetters[i] == guess) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        game.play();
    }
}
