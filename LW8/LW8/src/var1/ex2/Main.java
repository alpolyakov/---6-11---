package var1.ex2;

//Реализовать многопоточное приложение “Магазин”. Вся цепочка: производитель-магазин-покупатель.
//        Пока производитель не поставит на склад продукт, покупатель не может его забрать.
//        Реализовать приход товара от производителя в магазин случайным числом.
//        В том случае, если товара в магазине не хватает– вывести сообщение

public class Main {
    private volatile boolean flag1 = false;
    private volatile boolean flag2 = false;

    // поток Производства
    Runnable production = new Runnable() {
        @Override
        public void run() {
            try {
                int timer = 1000 + (int) (Math.random() * 10000);
                Thread.sleep(timer);
                System.out.println("Производитель: \"Товар отправлен в магазин!\" Прошло: " + timer + " с");
                flag1 = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    // поток Магазина
    Runnable magazine = new Runnable() {
        @Override
        public void run() {
            while(!flag1) {

            }
            System.out.println("Магазин: \"Товар едет, ждите!\"");
            try {
                int timer2 = 1000 + (int) (Math.random() * 10000);
                Thread.sleep(timer2);
                flag2 = true;
                System.out.println("Магазин: \"Товар поступил в продажу!\" Прошло: " + timer2 + " с");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    // поток Покупатель
    Runnable client = new Runnable() {
        @Override
        public void run() {
            while(!flag2) {
                try {
                    System.out.println("Клиент: \"Товара еще нет, жду!\"");
                    int timer3 = 1000;
                    Thread.sleep(timer3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Клиент: \"Товар на складе, покупаю!\"");
            flag2 = true;
        }
    };

    void toStart() {
        new Thread(production).start();
        System.out.println("Запуск производства!");
        new Thread(magazine).start();
        System.out.println("Открытие магазина!");
        new Thread(client).start();
        System.out.println("Покупатель ожидает товар!");
    }

    public static void main(String[] args) {
        new Main().toStart();
    }
}