package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        /*String s = "Чувствительный и проницательный сердцем Алеша" +
                " иногда целую неделю обдумывавший с наслаждением" +
                " как бы ей что подарить и как то она примет подарок" +
                " делавший из этого для себя настоящие праздники с восторгом" +
                " сообщавший мне заранее свои ожидания и мечты впадал в уныние от ее" +
                " журьбы и слез так что его становилось жалко а впоследствии между ними " +
                "бывали из за подарков упреки огорчения и ссоры";*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        String glassnie="";
        String soGlassnie="";
        for (int i = 0 ; i < s.length(); i++)
            if (isVowel(s.toCharArray()[i]))
            glassnie+=s.toCharArray()[i]+" ";
            else if (s.toCharArray()[i]!=' ') soGlassnie+=s.toCharArray()[i]+" ";
        System.out.println(glassnie);
        System.out.println(soGlassnie);

        //напишите тут ваш код
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
