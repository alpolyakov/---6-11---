package var2.ex1;

//Customer: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Номер банковского счета. Создать массив объектов.
//Вывести: a) список покупателей в алфавитном порядке; b) список покупателей, у которых номер кредитной карточки находится
//в заданном интервале.

import java.util.*;

import static java.util.Collections.*;

class Customer {
    private String name;
    private String name2;
    private String name3;
    private String address;
    private int creditCardId;
    private int bankNumberCard;

    Customer(String name, String name2, String name3, String address, int creditCardId, int bankNumberCard) {
        this.name = name;
        this.name2 = name2;
        this.name3 = name3;
        this.address = address;
        this.creditCardId = creditCardId;
        this.bankNumberCard = bankNumberCard;
    }

    public String getName() {
        return name;
    }

    public String getName2() {
        return name2;
    }

    public String getName3() {
        return name3;
    }

    public String getAddress() {
        return address;
    }

    public int getCreditCardId() {
        return creditCardId;
    }

    public int getBankNumberCard() {
        return bankNumberCard;
    }

    public String toString() {
        return String.format("ФИО: %s %s %s\t Страна: %s   Номер карты: %d   Номер банка: %d",
                name2, name, name3, address, creditCardId, bankNumberCard);
    }

}

class Shop {
    private String shopName;
    private ArrayList<Customer> customersList = new ArrayList<>();

    Shop(String shopName) {
        this.shopName = shopName;
    }

    void addCustomerToShopList(Customer customer) {
        customersList.add(customer);
    }

    List<Customer> getListByName() {
        List<Customer> list = new ArrayList<>(customersList);
        Collections.sort(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName2().compareToIgnoreCase(o2.getName2());
            }
        });
        return list;
    }

    List<Customer> getListByDiapasonCreaditCard(int diapazonStart, int diapazonEnd) {
        List<Customer> list = new ArrayList<>();
        for (Customer c : customersList) {
            if (c.getCreditCardId() >= diapazonStart && c.getCreditCardId() <=diapazonEnd) {
                list.add(c);
            }
        }

        return list;
    }

}

public class Main {
    public static void main(String[] args) {
        Shop shop1 = new Shop("Shop1");
        shop1.addCustomerToShopList(new Customer("Емельян", "Парамедов", "Михайлович", "Украина", 20202020, 12345));
        shop1.addCustomerToShopList(new Customer("Алексей", "Дмитриев", "Иванович", "Россия", 30303030, 23456));
        shop1.addCustomerToShopList(new Customer("Станислав", "Даудов", "Иванович", "Италия", 40404040, 34567));
        shop1.addCustomerToShopList(new Customer("Виктор", "Викторов", "Иванович", "Украина", 41414141, 45678));
        shop1.addCustomerToShopList(new Customer("Ян", "Милов", "Иванович", "Латвия", 77777777, 56789));
        shop1.addCustomerToShopList(new Customer("Диана", "Ылева", "Ивановна", "Россия", 99909090, 67890));
        shop1.addCustomerToShopList(new Customer("Маргарита", "Ретузова", "Ивановна", "Украина", 10101010, 78901));
        shop1.addCustomerToShopList(new Customer("Степан", "Яблоко", "Иванович", "Россия", 87879787, 89012));
        shop1.addCustomerToShopList(new Customer("Стапан", "Даудов", "Иванович", "США", 61686868, 90123));
        shop1.addCustomerToShopList(new Customer("Антон", "Антон", "Иванович", "Украина", 12121212, 10234));

        System.out.println("\nСортировка по ФИО:");
        List<Customer> listSortByName = shop1.getListByName();
        for (Customer c : listSortByName) {
            System.out.println(c);
        }

        System.out.println("\nКарты в диапозoне '20000000 - 70000000':");
        List<Customer> listSortByDiapazonCreditCard = shop1.getListByDiapasonCreaditCard(20000000, 70000000);
        for (Customer c : listSortByDiapazonCreditCard) {
            System.out.println(c);
        }


    }
}
