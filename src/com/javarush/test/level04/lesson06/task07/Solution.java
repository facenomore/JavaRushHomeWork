package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[] a;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a1=reader.readLine();
        String a2=reader.readLine();
        String a3=reader.readLine();
        a = new int[3];
        a[0] = Integer.parseInt(a1);
        a[1] = Integer.parseInt(a2);
        a[2] = Integer.parseInt(a3);
        if (a[0]==a[1]) System.out.println("3");
        else if (a[2]==a[1]) System.out.println("1");
        else if (a[0]==a[2]) System.out.println("2");
    }
}
