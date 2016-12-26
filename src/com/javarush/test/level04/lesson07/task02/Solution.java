package com.javarush.test.level04.lesson07.task02;

/* Строка - описание
Ввести с клавиатуры целое число в диапазоне 1 - 999. Вывести его строку-описание следующего вида:
«четное однозначное число» - если число четное и имеет одну цифру,
«нечетное однозначное число» - если число нечетное и имеет одну цифру,
«четное двузначное число» - если число четное и имеет две цифры,
«нечетное двузначное число» - если число нечетное и имеет две цифры,
«четное трехзначное число» - если число четное и имеет три цифры,
«нечетное трехзначное число» - если число нечетное и имеет три цифры.
Если введенное число не попадает в диапазон 1 - 999, в таком случае ничего не выводить на экран.
Пример для числа 100:
четное трехзначное число
Пример для числа 51:
нечетное двузначное число
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a1=reader.readLine();
        int a1i = Integer.parseInt(a1);
        int i=a1i%2;
        if ((a1i>=1)&&(a1i<=999))
        {
            if (((a1i-99) > 0) && (i == 1)) System.out.println("нечетное трехзначное число");
            else if (((a1i-99) > 0) && (i == 0)) System.out.println("четное трехзначное число");
            else if (((a1i-9) > 0) && (i == 1)) System.out.println("нечетное двузначное число");
            else if (((a1i-9) > 0) && (i == 0)) System.out.println("четное двузначное число");
            else if (i == 1) System.out.println("нечетное однозначное число");
            else if (i == 0) System.out.println("четное однозначное число");
        }
        else System.out.println();
        //напишите тут ваш код

    }
}
