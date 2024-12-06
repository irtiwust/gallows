public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new BigDictionary();
        ConsoleHangman game = new ConsoleHangman(dictionary);
        game.run();
    }
}
