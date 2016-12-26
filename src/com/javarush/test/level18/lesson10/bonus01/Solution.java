package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if ("-e".equals(args[0])) {
            FileInputStream fileInputStream = new FileInputStream(args[1]);
            FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
            while (fileInputStream.available() > 0) {
                int i = fileInputStream.read();
                int g = i ^ 12;
                fileOutputStream.write(g);
            }
            fileInputStream.close();
            fileOutputStream.close();
        }
        if ("-d".equals(args[0])) {
            FileInputStream fileInputStream = new FileInputStream(args[1]);
            FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
            while (fileInputStream.available() > 0) {
                int i = fileInputStream.read();
                int g = i ^ 12;
                fileOutputStream.write(g);
            }
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
