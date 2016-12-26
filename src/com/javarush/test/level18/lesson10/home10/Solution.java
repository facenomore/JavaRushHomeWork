package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> fileName = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while (!"end".equals(s)) {
            s = reader.readLine();
            if (!"end".equals(s)) fileName.add(s);
        }
        reader.close();

        for (int i = 0; i < fileName.size() - 1; i++) {
            for (int j = 0; j < fileName.size() - i - 1; j++) {
                String fileNameJ = "";
                String fileNameJ1 = "";
                fileNameJ = fileName.get(j).substring(fileName.get(j).lastIndexOf('.') + 5);
                fileNameJ1 = fileName.get(j + 1).substring(fileName.get(j + 1).lastIndexOf('.') + 5);
                int fileNumberJ = Integer.valueOf(fileNameJ);
                int fileNumberJ1 = Integer.valueOf(fileNameJ1);
                if (fileNumberJ > fileNumberJ1) {
                    String tmp = fileName.get(j);
                    fileName.set(j, fileName.get(j + 1));
                    fileName.set(j + 1, tmp);
                }
            }
        }

        byte[] buff = new byte[1000];

        String resultFile = fileName.get(0).substring(0, fileName.get(0).lastIndexOf('.'));

        FileOutputStream fileOutputStream = new FileOutputStream(resultFile);
        for (String z : fileName) {
            FileInputStream fileInputStream = new FileInputStream(z);
            while (fileInputStream.available() > 0) {
                int count = fileInputStream.read(buff);
                fileOutputStream.write(buff, 0, count);
            }
            fileInputStream.close();
        }
        fileOutputStream.close();
    }
}

