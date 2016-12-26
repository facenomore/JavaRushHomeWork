package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {


        Map<Integer, String> month  =  new HashMap<Integer, String>();
        month.put(1,"January");
        month.put(2,"February");
        month.put(3,"March");
        month.put(4,"April");
        month.put(5,"May");
        month.put(6,"June");
        month.put(7,"July");
        month.put(8,"August");
        month.put(9,"September");
        month.put(10,"October");
        month.put(11,"November");
        month.put(12,"December");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        System.out.println(s + " is " + getNeedsValueOfMap(month, s) +  " month");
        getNeedsValueOfMap(month, s);


//"January", "February", "March", "April", "May", "June", "July", "August","September","October","November", "December"

        //напишите тут ваш код
    }

    private static int getNeedsValueOfMap(Map<Integer, String> month, String s)
    {
        Iterator<Map.Entry<Integer,String>> iterator = month.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, String> pair = iterator.next();
            String value = pair.getValue();
            int key = pair.getKey();
            if (s.equals(value))
                return key;
        }
        return 0;
    }
}
