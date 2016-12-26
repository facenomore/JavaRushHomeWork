package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();//"C:\\Users\\Tod\\Desktop\\1\\1.txt";
        String ss="";
        InputStream inStream = new FileInputStream(s);
        List<Integer> odd = new ArrayList<>();

        while (inStream.available() > 0)
        {
            int data = inStream.read(); //читаем один байт из потока для чтения
            if (((char) data!='\n')&&((char) data!='\r'))
                ss+=(char) data;
            else if ((char) data!='\r')
            {
                if ((Integer.parseInt(ss)%2==0))
                {
                    odd.add(Integer.parseInt(ss));
                    ss = "";
                }
                else
                ss="";
            }

        }
        inStream.close(); //закрываем потоки
        if ((Integer.parseInt(ss)%2==0))
            odd.add(Integer.parseInt(ss));

//        for (Integer i : odd)
//            System.out.println(i);

       for (int i = 0; i < odd.size() - 1; i++) {
            for (int j = 0; j < odd.size() - i - 1; j++) {
                if (odd.get(j) > odd.get(j+1)) {
                    int tmp = odd.get(j);
                    odd.set(j,odd.get(j + 1));
                    odd.set((j + 1), tmp);
                }
            }
        }
  //      System.out.println();
       for (Integer i : odd)
            System.out.println(i);
    }
}
