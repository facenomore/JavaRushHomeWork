package com.javarush.test.level08.lesson11.home09;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число,
 иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        isDateOdd("JAN 5 2013");
    }

    public static boolean isDateOdd(String date)
    {
        try{
            DateFormat format = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
            Date dateDate = format.parse(date);
            Date startDate = new Date(dateDate.getYear(), 0, 1);
            long countTime = dateDate.getTime()- startDate.getTime()+1;
            long msDay = 24 * 60 * 60 * 1000;
            int dayCount = (int) (countTime/msDay);
            System.out.println(dayCount);
            if (dayCount%2==1) return true;
            else return false;
        }
        catch (ParseException e){
            System.out.println("Хибна структура дати.");
        }
        return true;
    }
}
