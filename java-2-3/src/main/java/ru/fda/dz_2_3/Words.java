package ru.fda.dz_2_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Words {

    public void words() {
        List<String> arrList = new ArrayList<>(Arrays.asList("Collection", "Array", "String", "Integer", "Collection", "Collection", "Array", "Boolean", "Short", "Collection", "Boolean", "Collection", "Array"));
        HashMap<String, Integer> hMap = new HashMap<>();
        Integer item;

        for (String arrLists : arrList) {
            item = hMap.get(arrLists);
            if (item == null) {
                hMap.put(arrLists, 1);
            } else {
                hMap.put(arrLists, item + 1);
            }
        }

        System.out.println("Всего слов в списке: " + arrList.size());
        System.out.println("Всего уникальных слов в списке: " + hMap.size());
        System.out.println("Слова и колличество раз их упоминания: " + hMap);
    }

}
