package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream1 = new FileInputStream(reader.readLine());
        BufferedWriter fileOutputStream2 = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        String s = "";
        int count = 1;

        while (fileInputStream1.available() > 0) {
            String tmp;
            tmp = String.valueOf((char) fileInputStream1.read());
            if (" ".equals(tmp)) count++;
            s += tmp;
        }
        fileInputStream1.close();

        String[] array = new String[count];
        array = s.split(" ");
        for (int i = 0; i < array.length; i++) {
            try {
                Integer.valueOf(array[i]);
                fileOutputStream2.write(array[i]);
                fileOutputStream2.write(" ");
            } catch (Exception e) {
            }
        }
        fileOutputStream2.close();
    }
}
