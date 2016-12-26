package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        int n,m;
        ArrayList<String> list= new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.valueOf(reader.readLine());
        m=Integer.valueOf(reader.readLine());

        for (int i=0; i<n;i++)
            list.add(reader.readLine());

        for (int i=0;i<m;i++){
            list.add(list.get(0));
            list.remove(0);
        }

        for (String i : list)
            System.out.println(i);
    }
}
