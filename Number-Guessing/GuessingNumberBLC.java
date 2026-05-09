import java.util.Random;

public class GuessingNumberBLC {
    private final int minRange;
    private final int maxRange;
    private final int maxAttempts;
    private int targetNumber;
    private int attemptsLeft;

    public GuessingNumberBLC(int min, int max, int attempts) {
        this.minRange = min;
        this.maxRange = max;
        this.maxAttempts = attempts;
        reset();
    }

    public void reset() {
        Random random = new Random();
        this.targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        this.attemptsLeft = maxAttempts;
    }


    public String processGuess(int guess) {
        attemptsLeft--;
        if (guess == targetNumber) return "CORRECT";
        if (guess < targetNumber) return "LOW";
        return "HIGH";
    }

    public int getAttemptsLeft() { 
        return attemptsLeft; 
    }
    public int getTargetNumber() { 
        return targetNumber; 
    }
}