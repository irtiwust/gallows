import java.util.Random;

public class BigDictionary implements Dictionary {

    private final String[] themes = {"Animals", "Sports", "Fruits", "Professions"};
    Random random = new Random();
    int themeIndex = random.nextInt(themes.length);
    
    private final String[] wordsA = {"cat", "dog", "rabbit", "horse", "bird", "fish", "parrot", "hyena", "giraffe", "antelope"};
    private final String[] wordsS = {"swimming", "cycling", "tennis", "boxing", "shooting", "sailing", "baseball", "football", "volleyball", "surfing"};
    private final String[] wordsF = {"apple", "banana", "orange", "mango", "peach", "lemon", "pear", "guava", "kiwi", "grape"};
    private final String[] wordsP = {"photographer", "scientist", "programmer", "engineer", "tutor", "surgeon", "barista", "judge", "pilot", "banker"};

    @Override
    public String getTheme(){
        return themes[themeIndex];
    }

    @Override
    public String randomWord() {
        Random random1 = new Random();
        
        switch (themes[themeIndex]) {
            case "Animals":
                return wordsA[random1.nextInt(wordsA.length)];
            case "Sports":
                return wordsS[random1.nextInt(wordsS.length)];
            case "Fruits":
                return wordsF[random1.nextInt(wordsF.length)];
            case "Professions":
                return wordsP[random1.nextInt(wordsP.length)];
            default:
                return null;
        }
    }
}
