package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s=null;
        int sum=0;
        do{
            s=reader.readLine();
            if (s.equals("сумма")) break;;
            sum+=Integer.parseInt(s);
        }
        while (!s.equals("сумма"));
        System.out.println(sum);
        //напишите тут ваш код
    }
}
