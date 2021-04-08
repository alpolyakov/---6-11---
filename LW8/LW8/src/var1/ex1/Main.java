package var1.ex1;

//Реализовать многопоточное приложение “Робот”.
//        Надо написать робота, который умеет ходить. За движение каждой его ноги отвечает отдельный поток.
//        Шаг выражается в выводе в консоль LEFT или RIGHT.

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread("    ()\n");
        thread1.start();
        MyThread thread2 = new MyThread("()    \n");
        thread2.start();
        Thread.sleep(5000);

        thread1.setFlag(false);  //остановка
        thread1.join(); // ожидает завершение потока
        //test("()  ()\n");
        Thread.sleep(3000);
    }

    public static Object key = new Object();
    public static void test(String message) {

        try {
            synchronized (key) {
                Thread.sleep(200);
                System.out.print(message);
                Thread.sleep(200);
                key.notify(); // возобновление потока
                key.wait(); // поток в режим ожидания
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class MyThread extends Thread {
    private String mess;
    private volatile boolean flag = true;

    MyThread(String m) {
        this.mess = m;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while(flag) {
            Main.test(this.mess);
        }
    }
}