package var1.ex1;

/******************************************************************************
 Выполнить задания на основе варианта 1 лабораторной работы 4, контролируя состояние потоков ввода/вывода.
 При возникновении ошибок, связанных с корректностью выполнения математических операций, генерировать и обрабатывать исключительные ситуации.
 Предусмотреть обработку исключений, возникающих при нехватке памяти, отсутствии требуемой записи (объекта) в файле, недопустимом значении поля и т.д.

 Создать класс City (город) с внутренним классом, с помощью объектов которого можно хранить информацию о проспектах, улицах, площадях.
 *******************************************************************************/

import java.util.Scanner;
//import java.util.InputMismatchException;

public class Main {
    static public void main(String[]args){
        City ct = new City();
        System.out.println(ct.toString());
    }
}

class City {
    private static Scanner ob = new Scanner(System.in);
    private Info info;
    private String city;

    public City() {
        boolean validInput = false;
        do {
            try {
                System.out.print("Введите название города: ");
                setCity(ob.next());
                validInput = true;
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!validInput);
        info = new Info();
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return info.toString();
    }

    public void setCity(String city) throws Exception {
        if (city.equals("0"))
            throw new Exception("Вы не ввели название города\n");
        else
            this.city=city;
    }
    public class Info {
        int pr,st,sq;

        public Info() {
            boolean validInput = false;
            int k = 0;
            do {
                try {
                    System.out.print("Кол-во проспектов в городе:");
                    k = ob.nextInt();
                    validInput = true;
                } catch(Exception e) {
                    System.out.println("Введите число!");
                    ob.next();
                }
            } while (!validInput);
            setPr(k);

            validInput = false;
            k = 0;
            do {
                try {
                    System.out.print("Количество улиц в городе:");
                    k = ob.nextInt();
                    validInput = true;
                } catch(Exception e) {
                    System.out.println("Введите число!");
                    ob.next();
                }
            } while (!validInput);
            setSt(k);

            validInput = false;
            k = 0;
            do {
                try {
                    System.out.print("Количествово площадей в городе:");
                    k = ob.nextInt();
                    validInput = true;
                } catch(Exception e) {
                    System.out.println("Введите число!");
                    ob.next();
                }
            } while (!validInput);
            setSq(k);
        }

        public int getPr(){
            return pr;
        }
        public void setPr(int pr){
            this.pr=pr;
        }
        public int getSt(){
            return st;
        }
        public void setSt(int st){
            this.st=st;
        }

        public int getSq(){
            return sq;
        }

        public void setSq(int sq){
            this.sq=sq;
        }

        @Override
        public String toString(){
            return "в городе "+getCity()+" "+getPr()+" проспектов,"+getSt()+" улицы и "+getSq()+" площадей";
        }
    }
}
