package ru.fda.dz_2_3;


public class MainApp {
    public static void main(String[] args) {
        System.out.println("-----------------------Пункт-№1----------------------------------");
        Words words = new Words();
        words.words();
        System.out.println("-----------------------Пункт-№2----------------------------------");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.phoneBook();
    }

}