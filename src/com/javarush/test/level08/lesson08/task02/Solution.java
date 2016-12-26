package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> createSet = new HashSet<Integer>();
        createSet.add(12);
        createSet.add(9);
        createSet.add(1);
        createSet.add(3);
        createSet.add(5);
        createSet.add(10);
        createSet.add(14);
        createSet.add(16);
        createSet.add(18);
        createSet.add(20);
        createSet.add(7);
        createSet.add(2);
        createSet.add(4);
        createSet.add(11);
        createSet.add(19);
        createSet.add(6);
        createSet.add(8);
        createSet.add(13);
        createSet.add(15);
        createSet.add(17);
        return createSet;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            if (iterator.next()>10)
                iterator.remove();
        }
        return set;
    }
}