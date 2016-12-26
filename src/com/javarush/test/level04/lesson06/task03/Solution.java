package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[] ai;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a=reader.readLine();
        String b=reader.readLine();
        String c=reader.readLine();
        ai=new int[3];
        ai[0] = Integer.parseInt(a);
        ai[1] = Integer.parseInt(b);
        ai[2] = Integer.parseInt(c);
        for(int i=0;i<ai.length-1;i++){
            for(int j=0;j<ai.length-i-1;j++)
            if (ai[j]<ai[j+1]){
                int tmp = ai[j];
                ai[j]=ai[j+1];
                ai[j+1]=tmp;
            }
        }
        System.out.println(ai[0] + " " + ai[1] + " " + ai[2]);
    }
}
