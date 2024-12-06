public class Win implements GuessResult {
    private final char[] state;
    private final int attempt;
    private final int maxAttempts;

    public Win(char[] state, int attempt, int maxAttempts) {
        this.state = state;
        this.attempt = attempt;
        this.maxAttempts = maxAttempts;
    }

    @Override
    public char[] state() {
        return state;
    }

    @Override
    public int attempt() {
        return attempt;
    }

    @Override
    public int maxAttempts() {
        return maxAttempts;
    }

    @Override
    public String message() {
        return "You won!";
    }
}
