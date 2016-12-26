package com.javarush.test.level04.lesson04.task10;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  //напишите тут ваш код
        String integS1 = reader.readLine();
        String integS2 = reader.readLine();
        String integS3 = reader.readLine();
        String s = "";
        int integI1 = Integer.parseInt(integS1);
        int integI2 = Integer.parseInt(integS2);
        int integI3 = Integer.parseInt(integS3);

        if ((integI1==integI2)&&(integI1==integI3)) s = integI1 + " " + integI2 + " " + integI3;
        else if (integI1 == integI2) s = integI1 + " " + integI2;
        else if (integI2 == integI3) s = integI2 + " " + integI3;
        else if (integI1 == integI3) s = integI1 + " " + integI3;

        System.out.println(s);
    }
}