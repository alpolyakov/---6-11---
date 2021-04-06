package var1.ex2;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

//В тексте после k-го символа вставить заданную подстроку.

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Введите k:");
        int k = sc1.nextInt();
        System.out.println("Введите подстроку:");
        String subString = sc2.nextLine();

        Path fileName = Path.of("Input12.txt");
        String actual = Files.readString(fileName);
        String newText = new String();
        newText = actual.substring(0, k) + subString + actual.substring(k);
        System.out.println(newText);
    }
}
