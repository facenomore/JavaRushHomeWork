package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/


import java.io.FileInputStream;
import java.io.IOException;

import java.util.Map;
import java.util.TreeMap;


public class Solution {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        TreeMap<Character, Integer> symbols = new TreeMap<>();

        while (fileInputStream.available() > 0) {
            Character c = (char) fileInputStream.read();
            if (!symbols.containsKey(c)) symbols.put(c, 1);
            else symbols.put(c, symbols.get(c) + 1);
        }

        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        fileInputStream.close();
    }
}