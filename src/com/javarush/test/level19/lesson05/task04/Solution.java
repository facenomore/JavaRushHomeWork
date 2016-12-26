package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream1 = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(reader.readLine());
        reader.close();

        while (fileInputStream1.available() > 0) {
            int i = fileInputStream1.read();
            if (i == 46) fileOutputStream2.write(33);
            else fileOutputStream2.write(i);
        }
        fileInputStream1.close();
        fileOutputStream2.close();
    }
}
