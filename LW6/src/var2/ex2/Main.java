package var2.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    class Car {
        private String name;
        public Car(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class AutoStop {
        private List<Car> cars = new ArrayList<>();
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

        public void addCar(String name) throws Exception{
            Car car = new Car(name);
            if (cars.size() < places)
                cars.add(car);
            
        }
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
