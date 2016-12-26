package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a=reader.readLine();
        int ai = Integer.parseInt(a);
        String b=reader.readLine();
        int bi = Integer.parseInt(b);
        String c=reader.readLine();
        int ci = Integer.parseInt(c);
        String d=reader.readLine();
        int di = Integer.parseInt(d);
        if ((ai>bi)&&(ai>ci)&&(ai>di)) System.out.println(ai);
        else if ((bi>ci)&&(bi>di)) System.out.println(bi);
        else if (ci>di) System.out.println(ci);
        else System.out.println(di);
    }
}
