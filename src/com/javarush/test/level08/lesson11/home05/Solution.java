package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine(); //Считываем

        //Разбираем в массив чар
        ArrayList<Character> ch = new ArrayList<>();
        for (int i=0; i<s.length(); i++)
                ch.add(s.charAt(i));

        if (!(ch.get(0).equals(' '))) ch.set(0,Character.toUpperCase(ch.get(0))); //Проверяем первый символ
        for (int i=1; i<ch.size(); i++) //проверяем и меняем символы после пробелов
            if ((ch.get(i - 1).equals(' ')) && (!(ch.get(i).equals(' '))))
                ch.set(i, Character.toUpperCase(ch.get(i)));
        //собираем и выводим на экран
        s="";
        for (int i=0; i<ch.size(); i++)
            s+=ch.get(i);
        System.out.println(s);

    }
}
