package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args[0].equals("-u")) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            bufferedReader.close();
            String productName = "";

            for (int i = 2; i < args.length - 2; i++)
                productName = productName + args[i] + " ";
            String trueProductName = setSpaces(productName, 30);

            String truePrice = setSpaces(args[args.length - 2], 8);
            String trueQuantity = setSpaces(args[args.length - 1], 4);

            String id = setSpaces(args[1], 8);
            String finalString = id + trueProductName + truePrice + trueQuantity;
            ArrayList<String> allNewLines = updateId(fileName, Long.parseLong(args[1]), finalString);
            BufferedWriter printWriter = new BufferedWriter(new FileWriter(fileName));
            for (String s : allNewLines) {
                printWriter.write(s);
                printWriter.newLine();
            }
            printWriter.close();

        } else if (args[0].equals("-d")) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            bufferedReader.close();

            ArrayList<String> allNewLines = removeId(fileName, Long.parseLong(args[1]));
            BufferedWriter printWriter = new BufferedWriter(new FileWriter(fileName));
            for (String s : allNewLines) {
                printWriter.write(s);
                printWriter.newLine();
            }
            printWriter.close();
        } else System.out.println("Wrong argument");
    }

    public static ArrayList<String> updateId(String fileName, Long updateId, String finalString) throws IOException {
        ArrayList<String> allLines = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        Long currentId;
        while ((line = bufferedReader.readLine()) != null) {
            currentId = Long.parseLong(line.substring(0, 8).replaceAll("\\s", ""));
            if (!updateId.equals(currentId)) allLines.add(line);
            else allLines.add(finalString);
        }
        bufferedReader.close();
        return allLines;
    }

    public static ArrayList<String> removeId(String fileName, Long idForRemove) throws IOException {
        ArrayList<String> allLines = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        Long currentId;
        while ((line = bufferedReader.readLine()) != null) {
            currentId = Long.parseLong(line.substring(0, 8).replaceAll("\\s", ""));
            if (!idForRemove.equals(currentId)) allLines.add(line);
        }
        bufferedReader.close();
        return allLines;
    }

    public static String getId(String fileName) throws IOException {
        ArrayList<Long> allIds = new ArrayList<Long>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        Long currentId;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.substring(0, 8).replaceAll("\\s", "");
            currentId = Long.parseLong(line);
            allIds.add(currentId);
        }
        bufferedReader.close();
        Long maxId = Collections.max(allIds);
        Long MyId = maxId + 1;
        return MyId.toString();
    }


    public static String setSpaces(String previousName, int count) {
        String trueName;
        if (previousName.length() > count)
            trueName = previousName.substring(0, count);
        else {
            String s = "";
            for (int i = 0; i < (count - previousName.length()); i++)
                s = s + " ";
            trueName = previousName + s;
        }
        return trueName;
    }
}
