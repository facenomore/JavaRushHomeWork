package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> myMap = new HashMap<String, String>();
        myMap = createMap();
        removeTheFirstNameDuplicates(myMap);
        System.out.println(myMap);
    }

    public static HashMap<String, String> createMap() {
        HashMap<String, String> createMap = new HashMap<String, String>();
        createMap.put("Некрасов", "Николай");
        createMap.put("Белов", "Василий");
        createMap.put("Гоголь", "Николай");
        createMap.put("Толстой", "Лев");
        createMap.put("Горький", "Максим");
        createMap.put("Бунин", "Иван");
        createMap.put("Грибоедов", "Александр");
        createMap.put("Пушкин", "Александр");
        createMap.put("Чуковский", "Корней");
        createMap.put("Булгаков", "Михаил");

        return createMap;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //инициализация первого итератора для прокрутки карты
        ArrayList<String> doubleString = new ArrayList<String>();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            //в каждом прогоне внешнего цикла заново создаем итератор для внутреннего цикла
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            String value = pair.getValue();
            //внутренний цикл прокрутки карты для сравнения итератора внешнего цикла со всеми значениями карты,
            // кроме как с одинаковым ключем
            Iterator<Map.Entry<String, String>> newIterator = map.entrySet().iterator();
            while (newIterator.hasNext()) {

                Map.Entry<String, String> newPair = newIterator.next();
                String newKey = newPair.getKey();
                String newValue = newPair.getValue();

                if ((newValue.equals(value)) && (!(newKey.equals(key))) && (!(doubleString.contains(newValue))))
                    doubleString.add(value);
            }
        }
        for (String s : doubleString) removeItemFromMapByValue(map, s);
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}


/*import java.util.*;
        import java.lang.*;
        import java.io.*;

class Ideone
{
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Пупкин", "Василий");
        map.put("Иванов", "Василий");
        map.put("Пушкин", "Александр");

        Map<String,Integer> counts = new HashMap<>();
        for (String firstName : map.values()) {
            counts.put(firstName, counts.getOrDefault(firstName, 0) + 1);
        }
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (counts.get(entry.getValue()) == 1) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println(result);
    }
}*/

