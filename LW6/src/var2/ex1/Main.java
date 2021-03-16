package var2.ex1;

//Во входном файле расположены два набора положительных чисел;
// между наборами стоит отрицательное число. Построить два списка C1 и С2,
// элементы которых содержат соответственно числа 1-го и 2-го набора таким образом,
// чтобы внутри одного списка числа были упорядочены по возрастанию.
// Затем объединить списки C1 и С2 в один упорядоченный список, изменяя только значения полей ссылочного типа.

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        float c;
        List<Float> c1 = new ArrayList<Float>();
        List<Float> c2 = new ArrayList<Float>();

        Scanner sc = new Scanner(new File("InputNums.txt"));
        boolean select = false;

        while(sc.hasNextFloat()){
            c = sc.nextFloat();
            if (c < 0) {
                select = true;
                continue;
            }
            if (!select) {
                c1.add(c);
            } else {
                c2.add(c);
            }
        }
        sc.close();

        System.out.println("Unsorted:");
        System.out.println("c1:"+c1);
        System.out.println("c2:"+c2);
        System.out.println("Sorted:");
        Collections.sort(c1);
        Collections.sort(c2);
        System.out.println("c1:"+c1);
        System.out.println("c2:"+c2);

        System.out.println("Sorted:");
        c1.addAll(c2);
        Collections.sort(c1);
        System.out.println("c1:"+c1);
    }
}
