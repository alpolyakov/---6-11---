package var2.ex1;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

//Найти и напечатать, сколько раз повторяется в тексте каждое слово, которое встречается в нем.

public class Main {
    public static void main(String[] args) throws IOException {
        System.setProperty("console.encoding","Cp866");
        List<String> words = new ArrayList<>();
        List<String> nWords = new ArrayList<>();
        Path fileName = Path.of("Input21.txt");
        String actual = Files.readString(fileName);
        words.addAll(Arrays.asList(actual.split("\\W+")));
        String newActual = actual;

        Map<String ,Integer> map = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String str = words.get(i);
            if (map.containsKey(str)) {
                int cnt = map.get(str);
                map.put(str, ++cnt);
            } else {
                map.put(str, 1);
            }
            if (!nWords.contains(str))
                nWords.add(str);
        }

        for (int i = 0; i < nWords.size(); i++) {
            System.out.println("\"" + nWords.get(i) + "\": " + map.get(nWords.get(i)));
        }
    }
}
