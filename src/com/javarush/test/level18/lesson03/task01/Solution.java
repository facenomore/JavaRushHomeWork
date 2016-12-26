package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        int max = 0;
        if (inputStream.available()>0) max=inputStream.read();
        while (inputStream.available()>0){
            int tmp=inputStream.read();
            if (max<tmp) max=tmp;
        }
        inputStream.close();
        System.out.println(max);
    }
}
