package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

import static java.lang.Math.random;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> integerArray = new ArrayList<>();
        integerArray.add(new int[5]);
        integerArray.add(new int[2]);
        integerArray.add(new int[4]);
        integerArray.add(new int[7]);
        integerArray.add(new int[0]);
        for (int i = 0; i < integerArray.size(); i++)
        {
            int[] element=new int[integerArray.get(i).length];

            for (int j=0; j < integerArray.get(i).length; j++)
                    element[j]= (i+1)*(j+1);
            integerArray.set(i,element);
        }
        return integerArray;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
