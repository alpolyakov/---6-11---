/********************
 *
 * 3. В каждой строке найти слова, начинающиеся с гласной буквы.
 *
 ***************************/

package var3.ex2;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException{
        List<String> lines = new ArrayList<String>();

        Path fileName = Path.of("demo2.txt");
        String actual = Files.readString(fileName);
        System.out.println("Содержимое файла:");
        System.out.println(actual + "\n");

        lines.addAll(Arrays.asList(actual.split("\\r?\\n")));

        System.out.println("Слова, начинающиеся с гласной буквы");
        for (int i = 0; i < lines.size(); i++) {
            List<String> words = new ArrayList<String>();
            String line = lines.get(i);
            words.addAll(Arrays.asList(line.split("\\s+")));
            System.out.print(i + " строка: ");
            for (int j = 0; j < words.size() ; j++) {
                String ch = Character.toString(words.get(j).charAt(0));
                if (ch.matches("[aouiyeAOUIYEуеыаоэяиюУЕЫАОЭЯИЮ]"))
                    System.out.print(words.get(j) + ", ");
            }
            System.out.println("");
        }
    }
}
