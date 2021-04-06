package var4.ex2;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

//8. Подсчитать, сколько раз заданное слово входит в текст.

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите слово:");
        String word = sc.nextLine();
        List<String> words = new ArrayList<>();
        List<String> nWords = new ArrayList<>();
        Path fileName = Path.of("Input42.txt");
        String actual = Files.readString(fileName);
        words.addAll(Arrays.asList(actual.split("\\W+")));

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
        Collections.sort(nWords);
        int r = 0;
        if (map.get(word) != null) {
            r = map.get(word);
        }
        System.out.println("Слово \"" + word + "\" встречается в тексте " + r + " раз");

    }
}
