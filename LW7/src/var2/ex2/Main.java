package var2.ex2;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

//7. В тексте найти и напечатать все слова максимальной и все слова минимальной длины.

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> words = new ArrayList<>();
        //List<String> nWords = new ArrayList<>();
        Path fileName = Path.of("Input22.txt");
        String actual = Files.readString(fileName);
        words.addAll(Arrays.asList(actual.split("\\W+")));

        int maxL = words.get(0).length();
        int minL = words.get(0).length();
        int nMin = 0;
        int nMax = 0;

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() > maxL)
                maxL = words.get(i).length();
            if (words.get(i).length() < minL)
                minL = words.get(i).length();
        }

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() >= maxL)
                nMax += 1;
            if (words.get(i).length() <= minL)
                nMin += 1;
        }
        System.out.println("Max length: " +  nMax + ", Min length: " + nMin);
    }
}
