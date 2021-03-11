package var4.ex2;

/********************
 *
 * Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
 *
 ***************************/

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<String>();
        List<String> changedLines = new ArrayList<>();

        Path fileName = Path.of("src\\var4\\ex2\\Main.java");
        Path fileNameResult = Path.of("JavaProgram_4_2_Result.txt");
        String actual = Files.readString(fileName);

        lines.addAll(Arrays.asList(actual.split("\\r?\\n")));
        for (int i = 0; i < lines.size(); i++) {
            List<String> words = new ArrayList<String>();
            String line = lines.get(i);
            words.addAll(Arrays.asList(line.split("\\W+")));
            System.out.println("----" + words);
            String startWord = null;
            String endWord = null;

            if (words.size() > 0) {
                int j =0;
                startWord = words.get(0);
                endWord = words.get(words.size() - 1);
            }
            else {
                startWord = "";
                endWord = "";
            }
            int j = 0;
            if (words.size() > 1) {
                while (startWord == "" || startWord == " ") {
                    //startWord = "";
                    j += 1;
                    startWord = words.get(j);
                }
            }
            //String endWord = words.get(words.size() - 1);
            System.out.println("{'" + startWord + "', '" + endWord + "'}");
            //System.out.println(words);

            line = line.replace(startWord, "ThisIsStartWordForReplace");
            line = line.replace(endWord, startWord);
            line = line.replace("ThisIsStartWordForReplace", endWord);
            line += "\n";

            changedLines.add(line);
        }
        String fileString = changedLines.toString().substring(1, changedLines.toString().length() - 1);

        Files.writeString(fileNameResult, fileString.replace(", ", ""));
    }
}

/********************************************************************************************************************************

package var4.ex2;

/********************
 *
 * 9. Прочитать текст Java-программы и
 * все слова public в объявлении атрибутов и методов класса заменить на слово private.
 *
 ***************************

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<String>();
        List<String> changedLines = new ArrayList<>();

        Path fileName = Path.of("src\\var4\\ex2\\Main.java");
        Path fileNameResult = Path.of("JavaProgram_4_2_Result.txt");
        String actual = Files.readString(fileName);

        lines.addAll(Arrays.asList(actual.split("\\r?\\n")));
        for (int i = 0; i < lines.size(); i++) {
            List<String> words = new ArrayList<String>();
            String line = lines.get(i);

            line = line.replace("public class ", "reserved class ");
            line = line.replace("public ", "private ");
            line = line.replace("reserved class ", "public class ");
            line += "\n";

            changedLines.add(line);
        }
        String fileString = changedLines.toString().substring(1, changedLines.toString().length() - 1);
        Files.writeString(fileNameResult, fileString.replace(", ", ""));
    }
}

*************************************************************************************************************************************************/
