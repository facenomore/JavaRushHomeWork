package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);

        if (inputStream.available() > 0) map.put(inputStream.read(), 1);
        while (inputStream.available() > 0) {
            int tmp = inputStream.read();
            if (map.containsKey(tmp)) map.put(tmp, map.get(tmp) + 1);
            else map.put(tmp, 1);
        }

        inputStream.close();

        int[] array = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            array[i] = entry.getKey();
            i++;
        }

        for (i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}