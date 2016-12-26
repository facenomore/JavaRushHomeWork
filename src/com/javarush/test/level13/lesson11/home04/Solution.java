package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        String destinationFileName = reader.readLine();
        FileOutputStream fileOutputStream = new FileOutputStream(destinationFileName);
        do
        {
            s = reader.readLine();
            for(int i=0;i<s.length();i++)
                fileOutputStream.write(s.toCharArray()[i]);
            fileOutputStream.write('\r');
            fileOutputStream.write('\n');
        }
        while (!s.equals("exit"));

        FileInputStream fileInputStream = new FileInputStream(destinationFileName);

        while (fileInputStream.available() > 0)
        {

            int data = fileInputStream.read();
            System.out.print((char) data);
            //    fileOutputStream.write(data);
        }

    }
}