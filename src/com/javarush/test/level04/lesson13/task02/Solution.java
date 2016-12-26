package com.javarush.test.level04.lesson13.task02;

import java.io.*;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String m=reader.readLine();
        String n=reader.readLine();
        int mInt=Integer.parseInt(m);
        int nInt=Integer.parseInt(n);
        for (int i=1;i<=mInt;i++){
            for (int j=1;j<=nInt;j++) System.out.print("8");
            System.out.println();
        }
        //напишите тут ваш код

    }
}
