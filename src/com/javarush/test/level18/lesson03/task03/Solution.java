package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
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
        int max=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max<entry.getValue()) max=entry.getValue();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==max) System.out.print(entry.getKey() + " ");
        }

        inputStream.close();

    }
}
