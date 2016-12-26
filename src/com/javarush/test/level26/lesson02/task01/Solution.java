package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] array = {3, 4, 7, -1, 5, 2, 1, -18, 11, 5, 48, 49, -23, 92, 94};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(array)));
    }

    public static Integer[] sort(Integer[] array) {
        final Integer median;
        Arrays.sort(array);

        if (array.length % 2 != 0)
            median = array[array.length / 2];
        else
            median = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;

        System.out.println(median);

        Comparator<Integer> medianByCompare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer value = Math.abs(o1 - median) - Math.abs(o2 - median);
                if (value == 0) value = o1 - o2;
                return value;
            }
        };

        Collections.sort(Arrays.asList(array), medianByCompare);
        return array;
    }
}
