package var2.ex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class Car {
    private String name;
    private int number;

    public Car(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class AutoStop {
    private HashMap<Integer, Car> cars = new HashMap<>();
    private int places;

    public AutoStop(int places) {
        this.places = places;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public HashMap<Integer, Car> getCars() {
        return cars;
    }

    public void addCar(Integer i, Car car) throws Exception {
        if (cars.get(i) == null && i<4 && i>=0)
            cars.put(i, car);
        else if (i>=4 || i<0)
            throw new Exception("Мест не осталось!");
        else
            throw new Exception("Место " + i + " занято!");
    }

    public void delCar(Car car) {
        cars.forEach((integer, car1) -> {if (car == car1) cars.remove(integer);});
    }

    public void delCarByIndex(Integer i) {
        cars.remove(i);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMV x3", 101);
        Car car2 = new Car("Lada Vesta", 105);
        Car car3 = new Car("Tuareg", 112);
        Car car4 = new Car("Daewoo Matiz", 121);
        Car car5 = new Car("Gelandewagen", 666);
        Car car6 = new Car("Tesla Model R", 228);
        List<Car> cars = new ArrayList<>();
        cars.add(car5);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car1);
        cars.add(car6);

        AutoStop parkingLot = new AutoStop(4);
        for (Car car: cars) {
            try {
                parkingLot.addCar(cars.indexOf(car), car);
                System.out.println("Машина " + car.getName() + ", №" + car.getNumber() + " запарковалась на место: " + cars.indexOf(car));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("\nЗанятые места на стоянке:");
        parkingLot.getCars().forEach((integer, car) -> System.out.println(car.getName() + ", №" + car.getNumber() + ", Место:" + integer));
        //System.out.println(parkingLot.getCars().get(12));

        System.out.println("\nОсвобождение парковочного места 2");
        parkingLot.delCarByIndex(2);
        //parkingLot.getCars().forEach((integer, car) -> System.out.println(car.getName() + ", №" + car.getNumber() + ", Место:" + integer));

        Car car10 = new Car("Toyota Corolla", 777);
        System.out.println("\nПриезд новой машины " + car10.getName() + ", номер: " + car10.getNumber());

        System.out.println("\nПоиск места для парковки:");
        for (int j = 0; j < parkingLot.getPlaces(); j++) {
            try {
                parkingLot.addCar(j, car10);
                j = parkingLot.getPlaces();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nЗанятые места на стоянке:");
        parkingLot.getCars().forEach((integer, car) -> System.out.println(car.getName() + ", №" + car.getNumber() + ", Место:" + integer));
    }
}

/*public class Main {
    static boolean checkCross(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
// здесь программа расчета пересечения  отрезков  (x1,y1,x2,y2) и отрезка (x3,y3,x4,y4)

        return false;
    }
    public static void main(String[] args) {
        int n = 10;  // здесь задается число отрезков
        int[][] coord = new int[n][2];
        Random rnd = new Random();
// инициализация массива точек
        for (int i = 0; i < n; i++) {
            int x = rnd.nextInt(25);  // здесь задаются случайные значения x точек отрезков
            int y = rnd.nextInt(25);  // здесь задаются случайные значения y точек отрезков
            coord[i][0] = x;
            coord[i][1] = y;
        }
// выводим массив точек на печать
        for (int i = 0; i < n; i+=2) {
            System.out.println("Line" + i/2 + "[" + coord[i][0] + "," + coord[i][1]+","+
                    coord[i+1][0] + "," + coord[i+1][1]+"]");
        }
// расчет отрезков в цикле
        System.out.println("Results:");
        for (int i = 0; i < n - 2; i += 2) {
            for (int j = i + 2; j < n; j+=2) {
                boolean result;
                int x1 = coord[i][0];
                int y1 = coord[i][1];
                int x2 = coord[i + 1][0];
                int y2 = coord[i + 1][1];
                int x3 = coord[j + 0][0];
                int y3 = coord[j + 0][1];
                int x4 = coord[j + 1][0];
                int y4 = coord[j + 1][1];

                result = checkCross(x1, y1, x2, y2, x3, y3, x4, y4);
                System.out.println("lines [" + x1 + "," + y1 + "," + x2 + "," + y2 + "]" +
                        "[" + x3 + "," + y3 + "," + x4 + "," + y4 + "]" +
                        "   cross:" + result);
            }
        }
    }
}*/

/*
class Section {
    float startX;
    float startY;
    float endX;
    float endY;

    public Section(float startX, float startY, float endX, float endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public float getStartX() {
        return startX;
    }

    public void setStartX(float startX) {
        this.startX = startX;
    }

    public float getStartY() {
        return startY;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public float getEndX() {
        return endX;
    }

    public void setEndX(float endX) {
        this.endX = endX;
    }

    public float getEndY() {
        return endY;
    }

    public void setEndY(float endY) {
        this.endY = endY;
    }
}

public class Main {
}
*/
