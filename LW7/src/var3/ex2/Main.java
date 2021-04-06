package var3.ex2;

//На основании правила кодирования, описанного в предыдущем примере, расшифровать заданный набор символов.

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
        Path fileName = Path.of("Input32.txt");
        String actual = Files.readString(fileName);
        ArrayList<Character> chars = convertStringToCharList(actual);
        for(int i = 0; i < chars.size()/3; i++) {
            System.out.print(chars.get(i));
            System.out.print(chars.get(chars.size()/3+1 + i));
            System.out.print(chars.get(chars.size()*2/3+1 + i));
        }
        for (int i = chars.size()/3*3+1; i < chars.size(); i++) {
            System.out.print(chars.get(i));
        }
    }
}
