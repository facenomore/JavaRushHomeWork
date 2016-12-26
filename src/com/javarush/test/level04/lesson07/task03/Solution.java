package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] a;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        a=new int[3];
        String a1=reader.readLine();
        a[0] = Integer.parseInt(a1);
        String a2=reader.readLine();
        a[1] = Integer.parseInt(a2);
        String a3=reader.readLine();
        a[2] = Integer.parseInt(a3);
        int x=0;
        for (int i=0;i<3;i++) if (a[i]>0) x++;
        System.out.println(x);


        //напишите тут ваш код

    }
}
