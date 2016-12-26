package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:/Users/a.todchuk/Desktop/3.txt");
        int countAll = 0;
        int countSpace = 0;
        while (fileInputStream.available() > 0) {
            char c = (char) fileInputStream.read();
            countAll++;
            if (c == ' ') countSpace++;
        }
        fileInputStream.close();
        System.out.println(String.format("%.2f%n", (float) countSpace / countAll * 100).replace(',', '.'));
    }
}
