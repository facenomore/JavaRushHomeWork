package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
/*    public static void main(String[] args)
    {
        createMap();
        for (Map.Entry<String, Date> pair : createMap().entrySet())
            System.out.println(pair.getKey()+" "+pair.getValue());

//        System.out.println();
//        System.out.println();
        System.out.println();
        removeAllSummerPeople(createMap());
//        for (Map.Entry<String, Date> pair : createMap().entrySet())
//            System.out.println(pair.getKey()+" "+pair.getValue());
    }*/

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Shvarc", new Date("JULY 1 1980"));
        map.put("Uilis", new Date("OCTOBER 1 1980"));
        map.put("Pitt", new Date("NOVEMBER 1 1980"));
        map.put("Chan", new Date("FEBRUARY 1 1980"));
        map.put("DiKaprio", new Date("JANUARY 1 1980"));
        map.put("Shin", new Date("AUGUST 1 1980"));
        map.put("Fasdf", new Date("APRIL 1 1980"));
        map.put("Asdfasd", new Date("MAY 1 1980"));
        map.put("Asdfasdf", new Date("MARCH 1 1980"));
        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map){

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
         //   String key = pair.getKey();
            Date value = pair.getValue();
            if ((value.getMonth()==5)||(value.getMonth()==6)||(value.getMonth()==7))
            {
       //         System.out.println(key + " " + value.getMonth());
                iterator.remove();
            }
        }
//        for (Map.Entry<String, Date> pair1 : map.entrySet())
//            System.out.println(pair1.getKey()+" "+pair1.getValue());
    }
}
