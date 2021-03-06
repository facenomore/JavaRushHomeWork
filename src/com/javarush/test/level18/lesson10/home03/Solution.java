package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream1 = new FileOutputStream(reader.readLine());
        FileInputStream fileInputStream2 = new FileInputStream(reader.readLine());
        FileInputStream fileInputStream3 = new FileInputStream(reader.readLine());

        while (fileInputStream2.available()>0){
            fileOutputStream1.write(fileInputStream2.read());
        }
        while (fileInputStream3.available()>0){
            fileOutputStream1.write(fileInputStream3.read());
        }
        fileOutputStream1.close();
        fileInputStream2.close();
        fileInputStream3.close();
        reader.close();
    }
}
