public interface GuessResult {
    char[] state();
    int attempt();
    int maxAttempts();
    String message();
}
