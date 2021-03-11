/********************
 * В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия.
 * При этом могут рассматриваться два варианта:
 * · каждая строка состоит из одного слова;
 * · каждая строка состоит из нескольких слов.
 * Имена входного и выходного файлов,
 * а также абсолютный путь к ним могут быть введены как параметры командной строки или храниться в файле.
 *
 * 4. Найти и вывести слова текста, для которых последняя буква одного слова совпадает с первой буквой следующего слова.
 * ********************/

package var3.ex1;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<String>();
        Path fileName = Path.of("demo.txt");
        String actual = Files.readString(fileName);
        System.out.println("Содержимое файла:");
        System.out.println(actual + "\n");

        words.addAll(Arrays.asList(actual.split("\\s+")));

        System.out.println("Слова, , для которых последняя буква одного слова совпадает с первой буквой следующего слова:");
        for (int i = 0; i < words.size() - 1; i++) {
            if (words.get(i).charAt(words.get(i).length() - 1) == words.get(i + 1).charAt(0))
                System.out.println(words.get(i) + " -> " + words.get(i+1));
        }
        System.out.println(words);

        scanner.close();
    }
}
