package var1.ex1;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

//В каждом слове текста k-ю букву заменить заданным символом. Если k больше длины слова, корректировку не выполнять.

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Введите k:");
        int k = sc1.nextInt();
        System.out.println("Введите символ:");
        String ch = sc2.nextLine();

        List<String> words = new ArrayList<>();
        List<String> newWords = new ArrayList<>();
        Path fileName = Path.of("Input11.txt");
        String actual = Files.readString(fileName);
        String newActual = "";
        words.addAll(Arrays.asList(actual.split("\\r?\\s")));
        System.out.println(words);
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() >= k)
                newWords.add(words.get(i).substring(0, k-1) + ch + words.get(i).substring(k, words.get(i).length()));
            else
                newWords.add(words.get(i));
        }
        for (int i = 0; i < words.size(); i++) {
            String s = new String();
            actual = actual.replaceFirst(words.get(i), newWords.get(i));
            s = actual.substring(0,actual.indexOf(newWords.get(i)) + words.get(i).length());
            newActual += s;
            actual = actual.substring(actual.indexOf(newWords.get(i)) + words.get(i).length());
        }
        System.out.println(newActual);
    }
}
