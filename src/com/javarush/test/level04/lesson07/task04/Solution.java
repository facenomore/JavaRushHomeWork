package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
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
        int x=0,y=0;
        for (int i=0;i<3;i++)
            if (a[i]>0) x++;
            else y++;
        System.out.println("количество отрицательных чисел: " + y);
        System.out.println("количество положительных чисел: " + x);
        //напишите тут ваш код

    }
}
