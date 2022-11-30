import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Dictionary {

    private final HashMap<String, String> words = new HashMap<>();

    public Dictionary() {
        InputStreamReader inputStream = new InputStreamReader(Objects.requireNonNull(Dictionary.class.getResourceAsStream("/dictionary.txt")));

        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] entry = line.split(" ", 2);
            if (entry.length == 1) {
                words.put(entry[0], "");
            } else {
                words.put(entry[0], entry[1]);
            }
        }
    }

    public boolean isWord(final String lookupWord) {
        return getDefinition(lookupWord) != null;
    }

    public String getDefinition(String lookupWord) {
        String lookupWordUpperCase = lookupWord.toUpperCase();
        return words.get(lookupWordUpperCase);
    }

}