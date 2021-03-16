package var1.ex1;

//Ввести строки из файла, записать в список ArrayList.
// Выполнить сортировку строк, используя метод sort() из класса Collections.

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<String>();
        List<String> sortLines = new ArrayList<String>();
        Path fileName = Path.of("InputLines.txt");
        String actual = Files.readString(fileName);
        lines.addAll(Arrays.asList(actual.split("\\r?\\n")));

        System.out.println("Несортированные cтроки:");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
        Collections.sort(lines);

        System.out.println("\nОтсортированные cтроки:");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }
}
