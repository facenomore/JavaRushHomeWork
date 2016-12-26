package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        Map<String, String> createMap = new HashMap<>();
        createMap.put("Ue","sdf");
        createMap.put("Ue1","sdf1");
        createMap.put("Ue2","sdf2");
        createMap.put("Ue3","sdf3");
        createMap.put("Ue4","sdf4");
        createMap.put("Ue5","sdf5");
        createMap.put("Ue6","sdf6");
        createMap.put("Ue7","sdf7");
        createMap.put("Ue8","sdf8");
        createMap.put("Ue9","sdf9");
        return (HashMap<String, String>) createMap;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int i=0;
        for (String pair : map.values())
            if (pair.equals(name)) i++;
        return i;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        return map.containsKey(lastName)?1:0;
    }
}
