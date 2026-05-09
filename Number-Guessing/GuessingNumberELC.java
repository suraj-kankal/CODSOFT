public class GuessingNumberELC {
    public static void main(String[] args) {
        GuessingNumberBLC game = new GuessingNumberBLC(1, 100, 7);
        int score = 0;

        IO.println();
        IO.println(">>> Welcome to the Number Guessing Game <<<");

        boolean keepPlaying = true;
        while (keepPlaying) {
            game.reset();
            if (playRound(game)) {
                score++;
            }
            
            keepPlaying = getUserInput("Rounds won: " + score + ". Play again? (y/n): ")
                    .equalsIgnoreCase("y");
        }

        IO.println("Final Score: " + score + ". Goodbye!");
    }

    private static boolean playRound(GuessingNumberBLC game) {
        IO.println("New Round! Guess the number (1-100).");

        while (game.getAttemptsLeft() > 0) {
            try {
                int guess = Integer.parseInt(
                    getUserInput("Remaining: " + game.getAttemptsLeft() + " | Enter guess: ")
                );
                String result = game.processGuess(guess);

                if (result.equals("CORRECT")) {
                    IO.println("Bingo! You nailed it.");
                    return true;
                } else {
                    IO.println("Too " + result + "!");
                }
            } catch (NumberFormatException e) {
                IO.println("Invalid input. Enter a number.");
            }
        }

        IO.println("Out of turns! The number was " + game.getTargetNumber());
        return false;
    }

    private static String getUserInput(String prompt) {
        System.out.print(prompt);
        return System.console() != null 
            ? System.console().readLine() 
            : new java.util.Scanner(System.in).nextLine();
    }
}