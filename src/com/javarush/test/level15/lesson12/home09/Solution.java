package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
h ttp://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
h ttp://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;// = "javarush.ru/alpha/index.html?lvl=15&??view&&&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&&?oobj=3.0 ";
        line=reader.readLine();
        String newLine = "";
        char k = ' ';
        for (int i = 0; i < line.length(); i++) {
            if (k == '?') newLine += line.toCharArray()[i];
            if ((k == ' ') && (line.toCharArray()[i] == '?')) k = '?';
        }
        String superNewLine="";
        for (int i = 0; i < newLine.length(); i++) {
            if(newLine.toCharArray()[i]=='?') continue;
                superNewLine+=newLine.toCharArray()[i];
        }

        String[] s = superNewLine.split("&");

        ArrayList<String>[] parameters = new ArrayList[2];
        parameters[0] = new ArrayList<>();
        parameters[1] = new ArrayList<>();

        String[] tmp = new String[2];

        for (int i = 0; i <s.length; i++) {
            if (s[i].contains("=")) tmp = s[i].split("=");
            else if (!s[i].equals("")) {
                tmp[0] = s[i];
                tmp[1] = "";
            } else if (s[i].equals("")) continue;

            parameters[0].add(tmp[0]);
            try {
                parameters[1].add(tmp[1]);
            } catch (Exception e)
            {
                parameters[1].add("");
            }
        }

        for (int i = 0; i < parameters[0].size(); i++) {
            System.out.print(parameters[0].get(i) + " ");
        }

        System.out.println();

        for (int i = 0; i < parameters[1].size(); i++) {
            if (parameters[0].get(i).equals("obj")) {
                try {
                    alert(Double.valueOf(parameters[1].get(i)));
                } catch (Exception e) {
                    alert(parameters[1].get(i));
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}