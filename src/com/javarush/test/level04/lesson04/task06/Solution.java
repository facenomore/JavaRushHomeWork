package com.javarush.test.level04.lesson04.task06;

/* День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название «понедельник», «вторник»,
 «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше или меньше 7 – вывести «такого дня недели не существует».
Пример для номера 5:
пятница
Пример для номера 10:
такого дня недели не существует
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String x=reader.readLine();
        int Integer= java.lang.Integer.parseInt(x);
        String name;
        switch (Integer) {
            case 1:  name = "понедельник";
                break;
            case 2:  name = "вторник";
                break;
            case 3:  name = "среда";
                break;
            case 4:  name = "четверг";
                break;
            case 5:  name = "пятница";
                break;
            case 6:  name = "суббота";
                break;
            case 7:  name = "воскресенье";
                break;
            default: name = "такого дня недели не существует";
                break;
        }
        System.out.println(name);


    }

}