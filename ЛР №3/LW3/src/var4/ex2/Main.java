package var4.ex2;

//Система Вступительные экзамены. Абитуриент регистрируется на Факультет, сдает Экзамены.
//Преподаватель выставляет Оценку.
//Система подсчитывает средний балл и определяет Абитуриентов, зачисленных в учебное заведение.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Exam {
    private int min;      //Проходной балл
    private int max;      //Максимальный балл
    private String name;

    public Exam(String name, int min, int max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}

class Exams {
    private Exam ex1 = new Exam("Математика", 75, 100);
    private Exam ex2 = new Exam("Русскмй язык", 60, 100);
    private Exam ex3 = new Exam("Обществознание", 50, 100);
    private Exam ex4 = new Exam("Математика", 60, 100);

    // Проходной балл за все экзамены
    private int pBall = ex1.getMin() + ex2.getMin() + ex3.getMin() + ex4.getMin() + 50;

    public Exam[] getExams() {
        return new Exam[] {ex1, ex2, ex3, ex4};
    }

    public int getPBall() {
        return pBall;
    }
}

class Abiturient {
    private int ex1ball;
    private int ex2ball;
    private int ex3ball;
    private int ex4ball;
    private String name;

    public Abiturient(int ex1ball, int ex2ball, int ex3ball, int ex4ball, String name) {
        this.ex1ball = ex1ball;
        this.ex2ball = ex2ball;
        this.ex3ball = ex3ball;
        this.ex4ball = ex4ball;
        this.name = name;
    }

    public int getEx1Ball() {
        return ex1ball;
    }

    public int getEx2Ball() {
        return ex2ball;
    }

    public int getEx3Ball() {
        return ex3ball;
    }

    public int getEx4Ball() {
        return ex4ball;
    }

    public String getName() {
        return name;
    }

    public double getBall() {
        return (ex1ball + ex2ball + ex3ball + ex4ball)/4;
    }

    public String toString() {
        return name + ": " + ex1ball + ", " + ex2ball + ", " + ex3ball + ", " + ex4ball;
    }
}

class Prepod {
    String abiName;   //абитуриент
    int[] marks = new int[4];          //оценка

    public Prepod(String abiName) {
        this.abiName = abiName;
    }

    public Abiturient getMarks() {
        for (int i = 0; i < 4; i++) {
            int min = 33;
            int max = 100;
            int diff = max - min;
            Random random = new Random();
            marks[i] = random.nextInt(diff + 1) + min;
        }
        return new Abiturient(marks[0], marks[1], marks[2], marks[3], abiName);
    }
}

public class Main {
    public static void main(String[] args) {
        Exams exs = new Exams();
        Prepod pr = new Prepod("Иванов А.А.");
        Abiturient ab = pr.getMarks();
        System.out.println(ab.toString());
        System.out.println("Проходной балл: " + exs.getPBall() + "\nСтудент набрал: " + ab.getBall()*4);
    }
}
