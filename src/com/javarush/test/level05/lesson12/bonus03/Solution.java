package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] a;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nString = reader.readLine();
        int n = Integer.parseInt(nString);
        int maximum;

        a = new int[n];
        a[0]=Integer.parseInt(reader.readLine());
        maximum=a[0];
        for (int i=1; i<n;i++){
            a[i]=Integer.parseInt(reader.readLine());
            if (maximum<a[i]) maximum=a[i];
        }
        System.out.println(maximum);
    }
}
