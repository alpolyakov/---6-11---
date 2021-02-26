//Patient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Номер медицинской карты, Диагноз. Создать массив объектов.
//Вывести: a) список пациентов, имеющих данный диагноз; b) список пациентов, номер медицинской карты у которых находится в заданном интервале.

import java.util.*;

import static java.util.Collections.*;

class Patient {
    private String name;
    private String name2;
    private String name3;
    private String address;
    private int patientCardId;
    private String diagnoz;

    Patient(String name, String name2, String name3, String address, int patientCardId, String diagnoz) {
        this.name = name;
        this.name2 = name2;
        this.name3 = name3;
        this.address = address;
        this.patientCardId = patientCardId;
        this.diagnoz = diagnoz;
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
        return patientCardId;
    }

    public String getDiagnoz() {
        return diagnoz;
    }

    public String toString() {
        return String.format("ФИО: %s %s %s\nАдрес: %s \nНомер карты: %d\nДиагноз: %s\n____________________",
                name2, name, name3, address, patientCardId, diagnoz);
    }

}

class Hospital {
    private String hospitalName;
    private ArrayList<Patient> patientsList = new ArrayList<>();

    Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    void addPatientToHospitalList(Patient patient) {
        patientsList.add(patient);
    }

    List<Patient> getListByDiag(String diag) {
        List<Patient> list = new ArrayList<>();
        for (Patient c : patientsList) {
            if (c.getDiagnoz() == diag) {
                list.add(c);
            }
        }
        return list;
    }

    List<Patient> getListByDiapasonCreaditCard(int diapazonStart, int diapazonEnd) {
        List<Patient> list = new ArrayList<>();
        for (Patient c : patientsList) {
            if (c.getCreditCardId() >= diapazonStart && c.getCreditCardId() <=diapazonEnd) {
                list.add(c);
            }
        }
        return list;
    }

}

public class Main {
    public static void main(String[] args) {
        Hospital hospital1 = new Hospital("hospital1");
        hospital1.addPatientToHospitalList(new Patient("Емельян", "Парамедов", "Михайлович", "Украина", 20202020, "Нервоз"));
        hospital1.addPatientToHospitalList(new Patient("Алексей", "Дмитриев", "Иванович", "Россия", 30303030, "Грыжа"));
        hospital1.addPatientToHospitalList(new Patient("Станислав", "Даудов", "Иванович", "Италия", 40404040, "Коронавирус"));
        hospital1.addPatientToHospitalList(new Patient("Виктор", "Викторов", "Иванович", "Украина", 41414141, "Гепатит С"));
        hospital1.addPatientToHospitalList(new Patient("Ян", "Милов", "Иванович", "Латвия", 77777777, "Перелом ребер"));
        hospital1.addPatientToHospitalList(new Patient("Диана", "Ылева", "Ивановна", "Россия", 99909090, "Коронавирус"));
        hospital1.addPatientToHospitalList(new Patient("Маргарита", "Ретузова", "Ивановна", "Украина", 10101010, "Бессонница"));
        hospital1.addPatientToHospitalList(new Patient("Степан", "Яблоко", "Иванович", "Россия", 87879787, "ОРВИ"));
        hospital1.addPatientToHospitalList(new Patient("Стапан", "Даудов", "Иванович", "США", 61686868, "Коронавирус"));
        hospital1.addPatientToHospitalList(new Patient("Антон", "Антон", "Иванович", "Украина", 12121212, "ОРВИ"));

        System.out.println("\nПациенты с коронавирусом:");
        List<Patient> listSortByDiag = hospital1.getListByDiag("Коронавирус");
        for (Patient c : listSortByDiag) {
            System.out.println(c);
        }
        System.out.println("############################################");

        System.out.println("\nКарты в диапозoне '20000000 - 70000000':");
        List<Patient> listSortByDiapazonCreditCard = hospital1.getListByDiapasonCreaditCard(20000000, 70000000);
        for (Patient c : listSortByDiapazonCreditCard) {
            System.out.println(c);
        }


    }
}