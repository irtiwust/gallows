import java.util.Scanner;

public class ConsoleHangman {
    private final Dictionary dictionary;
    private final Scanner scanner;

    public ConsoleHangman(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println();
        System.out.println("Theme: " + dictionary.getTheme());
        String wordToGuess = dictionary.randomWord();
        Session session = new Session(wordToGuess, 6);

        while (true) {
            System.out.println();
            drawHangman(session.getAttempts());
            System.out.println("Current word: " + String.valueOf(session.getUserAnswer()));
            System.out.print("Guess a letter (or type 'give up' to surrender): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("give up")) {
                printState(session.giveUp(), wordToGuess);
                break;
            }

            if (input.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guess = input.charAt(0);
            GuessResult result = session.guess(guess);

            if (result instanceof Defeat) {
                drawHangman(session.getAttempts());
            }

            printState(result, wordToGuess);

            if (result instanceof Win || result instanceof Defeat) {
                break;
            }
        }
    }

    private void printState(GuessResult guess, String wordToGuess) {
        System.out.println(guess.message());
        if (guess instanceof Win) {
            System.out.println("The word is: " + wordToGuess);
        }
        if (guess instanceof Defeat) {
            System.out.println("The word was: " + wordToGuess);
        }
    }

    private void drawHangman(int attempts) {
        String[] hangmanStages = new String[7];
        hangmanStages[0] = "   -----\n   |   |\n       |\n       |\n       |\n       |\n=========";
        hangmanStages[1] = "   -----\n   |   |\n   O   |\n       |\n       |\n       |\n=========";
        hangmanStages[2] = "   -----\n   |   |\n   O   |\n   |   |\n       |\n       |\n=========";
        hangmanStages[3] = "   -----\n   |   |\n   O   |\n  /|   |\n       |\n       |\n=========";
        hangmanStages[4] = "   -----\n   |   |\n   O   |\n  /|\\  |\n       |\n       |\n=========";
        hangmanStages[5] = "   -----\n   |   |\n   O   |\n  /|\\  |\n  /    |\n       |\n=========";
        hangmanStages[6] = "   -----\n   |   |\n   O   |\n  /|\\  |\n  / \\  |\n       |\n=========";

        System.out.println(hangmanStages[attempts]);
    }
}