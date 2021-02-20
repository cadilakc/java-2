package ru.fda.dz_2_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    Map<String, List<String>> hashMap = new HashMap<>();
    List<String> phoneNumber;

    public void phoneBook() {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Petrov", "551-51-51");
        phoneBook.add("Sidorov", "552-52-52");
        phoneBook.add("Pupkin", "553-53-53");
        phoneBook.add("Ivanov", "554-54-54");
        phoneBook.add("Ivanov", "555-55-55");
        phoneBook.add("Petrov", "556-56-56");
        phoneBook.add("Sidorov", "557-57-57");
        phoneBook.add("Pupkin", "558-58-58");
        phoneBook.add("Ivanov", "559-59-59");

        System.out.println(phoneBook.get("Ivanov"));
        System.out.println(phoneBook.get("Petrov"));
        System.out.println(phoneBook.get("Sidorov"));
        System.out.println(phoneBook.get("Pupkin"));
    }

    public void add(String surname, String phone) {
        if (hashMap.containsKey(surname)) {
            phoneNumber = hashMap.get(surname);
        } else {
            phoneNumber = new ArrayList<>();
        }
        phoneNumber.add(phone);
        hashMap.put(surname, phoneNumber);
    }

    public List<String> get(String surname) {
        return hashMap.get(surname);
    }
}

