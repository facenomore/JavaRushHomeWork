package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[5];
        for(int i=0; i<5;i++) a[i]=Integer.parseInt(reader.readLine());
        //a[0]=3;
        //a[1]=2;
        //a[2]=1;
        //a[3]=6;
        //a[4]=1;


        int tmp=0;
        for (int i=0;i<5;i++)
            for (int j=0;j<i;j++)
                if (a[j]>a[i])
                {
                    tmp=a[j];
                    a[j]=a[i];
                    a[i]=tmp;
                }
        for(int i=0; i<5;i++) System.out.println(a[i]);
        //напишите тут ваш код
    }
}
