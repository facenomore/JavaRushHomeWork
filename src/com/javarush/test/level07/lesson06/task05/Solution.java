package com.javarush.test.level07.lesson06.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> str = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<5; i++)
            str.add(i,reader.readLine());
        String tmp;
        for (int i=0; i<13; i++)     {
            tmp = str.get(4);
            str.remove(4);
            str.add(0, tmp);
        }
        for (int i=0; i<5; i++)
             System.out.println(str.get(i));  //напишите тут ваш код

    }
}
