package com.javarush.test.level07.lesson04.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Максимальное среди массива на 20 чисел
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }
    public static int[] initializeArray() throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[20];
        for(int i=0; i<a.length;i++) a[i]=Integer.parseInt(reader.readLine());
        // /Инициализируйте (создайте и заполните) массив тут
        return a;
    }

    public static int max(int[] array) {
        //Найдите максимальное значение в этом методе
        int m=array[0];
        for(int i=1;i<array.length;i++) if (array[i]>m) m=array[i];
        return m;
    }
}
