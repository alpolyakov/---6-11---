package var3.ex1;

//Текст шифруется по следующему правилу: из исходного текста
//        выбирается 1, 4, 7, 10-й и т.д. (до конца текста) символы,
//        затем 2, 5, 8, 11-й и т.д. (до конца текста) символы,
//        затем 3, 6, 9, 12-й и т.д. Зашифровать заданный текст.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class Main {
    public static ArrayList<Character> convertStringToCharList(String str) {
        ArrayList<Character> chars = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }
        return chars;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of("Input31.txt");
        String actual = Files.readString(fileName);
        System.out.println("Исходный текст:");
        System.out.println(actual);
        System.out.println("\nЗашифрованный текст:");
        ArrayList<Character> chars = convertStringToCharList(actual);
        for(int i = 0; i < chars.size(); i+=3) {
            System.out.print(chars.get(i));
        }
        for(int i = 1; i < chars.size(); i+=3) {
            System.out.print(chars.get(i));
        }
        for(int i = 2; i < chars.size(); i+=3) {
            System.out.print(chars.get(i));
        }
        System.out.println(chars);
    }
}
