package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String floatBlock = "";
        int count = 1;
        reader.close();

        FileInputStream fileInputStream1 = new FileInputStream(file1);
        while (fileInputStream1.available() > 0) {
            char c = (char) fileInputStream1.read();
            if (c == ' ') count++;
            floatBlock += c;
        }
        fileInputStream1.close();

        String[] floatString = new String[count];
        int[] floatToInt = new int[count];
        floatString = floatBlock.split(" ");

        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
        for (int i = 0; i < count; i++) {
            floatToInt[i] = Math.round(Float.valueOf(floatString[i]));
            String s = String.valueOf(floatToInt[i]);
            for (int j = 0; j < s.length(); j++)
                fileOutputStream2.write((byte) s.toCharArray()[j]);
            fileOutputStream2.write((byte) ' ');
        }
        fileOutputStream2.close();
    }
}
