package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String m=reader.readLine();
        String n=reader.readLine();
        String k=reader.readLine();
        int mInt=Integer.parseInt(m);
        int nInt=Integer.parseInt(n);
        int kInt=Integer.parseInt(k);

        if (((mInt>kInt)&&(mInt<nInt))||((mInt<kInt)&&(mInt>nInt))) System.out.println(mInt);
        else if (((nInt>kInt)&&(nInt<mInt))||((nInt<kInt)&&(nInt>mInt))) System.out.println(nInt);
        else if (((kInt>nInt)&&(kInt<mInt))||((kInt<nInt)&&(kInt>mInt))) System.out.println(kInt);
    }
}
