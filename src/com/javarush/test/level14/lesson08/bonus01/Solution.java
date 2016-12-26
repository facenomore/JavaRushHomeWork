package com.javarush.test.level14.lesson08.bonus01;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int i=Integer.parseInt("d");
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            FileInputStream f = new FileInputStream("c:\\doc.txt");
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new EOFException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new IOException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new InterruptedIOException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
           ArrayList<String> array = new ArrayList<>();
           array.get(1);
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            int[] array = new int[10];
            int z=array[10];
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new RuntimeException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new Exception();
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //Add your code here

    }
}
