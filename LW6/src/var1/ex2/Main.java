package var1.ex2;

import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        //Инициализация первого многочлена
        HashMap<Integer, Integer> d=new HashMap<>();
        Scanner f=new Scanner(System.in);
        System.out.print("Степень 1-го многочлена n= ");
        int n=f.nextInt();
        System.out.print("Степень 2-го многочлена n= ");
        int k=f.nextInt();

        System.out.print("D(x)= c0 ");
        for(int i=1; i<=n; i++)
        {
            System.out.print(" + c"+i+"*x^"+i);
        }
        System.out.println();
        for(int i=0; i<=Integer.max(n, k); i++)
        {
            if (i <= n) {
                System.out.print("c" + i + "=");
                d.put(i, f.nextInt());
            }
            else d.put(i, 0);
        }
        System.out.print("D(x)= "+d.get(0));
        for(int i=1; i<=n; i++){
            System.out.print(" + "+d.get(i)+"x^"+i);
        }
        System.out.println();

        //Инициализация второго многочлена
        HashMap<Integer, Integer> e=new HashMap<>();
        System.out.print("E(x)= a0 ");
        for(int i=1; i<=k; i++)
        {
            System.out.print(" + a"+i+"*x^"+i);
        }
        System.out.println();
        for(int i=0; i<=Integer.max(n, k); i++)
        {
            if (i <= k) {
                System.out.print("c" + i + "=");
                e.put(i, f.nextInt());
            }
            else e.put(i, 0);
        }
        System.out.print("E(x)= "+e.get(0));
        for(int i=1; i<=k; i++)
        {
            System.out.print(" + "+e.get(i)+"x^"+i);
        }
        System.out.println();

        //Сложениее элементов многочлена
        HashMap<Integer, Integer> h=new HashMap<>();
        h.put(0, d.get(0)+e.get(0));
        System.out.print("D(x)+E(x)= "+h.get(0));
        for(int i=1; i<=Integer.max(n, k); i++)
        {
            h.put(i, d.get(i)+e.get(i));
            System.out.print(" + "+h.get(i)+"x^"+i);
        }
    }
}