package com.javarush.test.level04.lesson10.task03;

import java.io.*;

/* Хорошего не бывает много
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while.
Пример ввода:
абв
2
Пример вывода:
абв
абв
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a1=reader.readLine();
        String a2=reader.readLine();
        int a2i = Integer.parseInt(a2);
        int i=0;//напишите тут ваш код
        while (i<a2i){
            System.out.println(a1);
            i++;
        }
    }
}
