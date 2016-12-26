package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        int tmp = 0;
        if (inputStream.available() > 0) map.put(inputStream.read(), 1);
        while (inputStream.available() > 0) {
            tmp = inputStream.read();
            if (map.containsKey(tmp)) map.put(tmp, map.get(tmp) + 1);
            else map.put(tmp, 1);
        }
        int min = map.get(tmp);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (min > entry.getValue()) min = entry.getValue();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) System.out.print(entry.getKey() + " ");
        }
        inputStream.close();
    }
}
