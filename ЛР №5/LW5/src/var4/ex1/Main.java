package var4.ex1;

/********************
 *
 * 2. Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.
 *
 ***************************/

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<String>();
        List<String> backlines = new ArrayList<>();

        Path fileName = Path.of("src\\var4\\ex1\\Main.java");
        Path fileNameResult = Path.of("JavaProgramResult.txt");
        String actual = Files.readString(fileName);

        lines.addAll(Arrays.asList(actual.split("\\r?\\n")));
        for (int i = 0; i < lines.size(); i++) {
            List<String> backline = new ArrayList<>();
            String line = lines.get(i);
            for (int j = line.length()-1; j >= 0 ; j--) {
                String ch = Character.toString(line.charAt(j));
                backline.add(ch);
            }
            String backstring = backline.toString().substring(1, backline.toString().length() - 1);
            backstring += "\n";
            backlines.add(backstring);
        }
        String fileString = backlines.toString().substring(1, backlines.toString().length() - 1);
        Files.writeString(fileNameResult, fileString.replace(", ", ""));
    }
}
