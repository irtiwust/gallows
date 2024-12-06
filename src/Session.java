public class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    public Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.userAnswer = new char[answer.length()];
        for (int i = 0; i < userAnswer.length; i++) {
            userAnswer[i] = '*';
        }
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }

    public GuessResult guess(char guess) {
        boolean hit = false;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                userAnswer[i] = guess;
                hit = true;
            }
        }

        if (!hit) {
            attempts++;
        }

        return checkGameState();
    }

    public GuessResult giveUp() {
        return new Defeat(userAnswer, attempts, maxAttempts);
    }

    private GuessResult checkGameState() {
        if (attempts >= maxAttempts) {
            return new Defeat(userAnswer, attempts, maxAttempts);
        }
        if (String.valueOf(userAnswer).equals(answer)) {
            return new Win(userAnswer, attempts, maxAttempts);
        }
        return new FailedGuess(userAnswer, attempts, maxAttempts);
    }

    public char[] getUserAnswer() {
        return userAnswer;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }
}
