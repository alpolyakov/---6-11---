package var1.ex2;

//Определить класс Комплекс. Класс должен содержать несколько конструкторов. Реализовать методы для сложения, вычитания, умножения, деления, присваивания
//комплексных чисел. Создать два вектора размерности n из комплексных координат. Передать их в метод, который выполнит их сложение.

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


class Complex {
    double re;
    double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex() {
        re = 0;
        im = 0;
    }

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("re=").append(re);
        sb.append(", im=").append(im);
        sb.append('}');
        return sb.toString();
    }

    public Complex add(Complex z1) {
        Complex z = new Complex();
        z.re = re + z1.re;
        z.im = im + z1.im;
        return z;
    }

    public Complex mult(Complex z1) {
        Complex z = new Complex();
        z.re = re*z1.re - im*z1.im;
        z.im = re*z1.im + z1.re*im;
        return z;
    }
}

class ComplexList {
    List<Complex> complexList;

    public ComplexList() {
        complexList = new ArrayList<>();
    }

    public boolean remove(int k) {
        boolean f;
        if (f = isPossibleToRemove(k))
            complexList.remove(k);
        return f;
    }

    private boolean isPossibleToRemove(int k) {
        return (k>=0 && k<complexList.size());
    }

    public void addNumber (Complex z) {
        complexList.add(z);
    }

    public void addRandomNComplex(int n, double max) {
        Random rand = new Random();
        double re;
        double im;
        for (int i = 0; i < n; i++) {
            re = (rand.nextDouble()-0.5)*2*max;
            im = (rand.nextDouble()-0.5)*2*max;
            complexList.add(new Complex(re, im));
        }
    }

    public void output() {
        int i=0;
        for (Complex z: complexList) {
            System.out.println("Число " + ++i + ": " + z.toString());
        }
    }

    public Complex summ() {
        Complex res = new Complex();
        for (Complex z: complexList) {
            res = res.add(z);
        }
        return res;
    }

    public Complex mult() {
        Complex res = new Complex();
        int i = 0;
        for (Complex z: complexList) {
            if (i==0) res = z;
            else res = res.mult(z);
            i++;
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Complex z1 = new Complex(2, -2);
        Complex z2 = new Complex(1, 2);
        Complex z3 = new Complex(3, -4);
        ComplexList numbers = new ComplexList();
        numbers.addNumber(z1);
        numbers.addNumber(z2);
        numbers.addNumber(z3);
        numbers.addNumber(z2.add(z3));
        numbers.addNumber(z2.mult(z3));

        //Вывод комплексных чисел
        numbers.output();

        //Сумма вектора комплексных чисел
        System.out.println(numbers.summ());

        //Умножение вектора комплексных чисел
        System.out.println(numbers.mult());
    }
}
