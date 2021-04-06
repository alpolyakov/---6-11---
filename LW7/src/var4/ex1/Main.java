package var4.ex1;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

//Вывести в заданном тексте все слова, расположив их в алфавитном порядке.

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> words = new ArrayList<>();
        List<String> nWords = new ArrayList<>();
        Path fileName = Path.of("Input41.txt");
        String actual = Files.readString(fileName);
        words.addAll(Arrays.asList(actual.split("\\W+")));
        String newActual = actual;

        for (int i = 0; i < words.size(); i++) {
            String str = words.get(i);
            if (!nWords.contains(str))
                nWords.add(str);
        }
        Collections.sort(nWords);

        for (int i = 0; i < nWords.size(); i++) {
            System.out.println("\"" + nWords.get(i) + "\"");
        }
    }
}
