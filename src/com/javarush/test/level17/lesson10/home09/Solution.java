package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
 которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String file1 = "";
        String file2 = "";
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            file1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            file2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader file1Stream = new BufferedReader(new FileReader(file1));
            while (file1Stream.ready()) {
                allLines.add(file1Stream.readLine());
            }
            file1Stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader file2Stream = new BufferedReader(new FileReader(file2));
            while (file2Stream.ready()) {
                forRemoveLines.add(file2Stream.readLine());
            }
            file2Stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream file2Stream = new FileInputStream(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        boolean contain = true;
        for (String s : forRemoveLines) {
            if (!allLines.contains(s)) {
                contain = false;
                break;
            }
        }
        if (contain)
            for (String s : forRemoveLines)
                allLines.remove(s);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
