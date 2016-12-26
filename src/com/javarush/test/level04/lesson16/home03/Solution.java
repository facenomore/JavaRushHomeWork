package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
     int x=0,s=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            String m=reader.readLine();
            x=Integer.parseInt(m);
            s+=x;
        } while (x!=-1);
        System.out.println(s);
        //напишите тут ваш код
    }
}
