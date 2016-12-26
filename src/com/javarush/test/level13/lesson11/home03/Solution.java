package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName;

        do{
            sourceFileName = reader.readLine();
        } while (getSourceFileExist(sourceFileName));

        FileInputStream fileInputStream = new FileInputStream(sourceFileName);

        //String destinationFileName = reader.readLine();
        //FileOutputStream fileOutputStream = new FileOutputStream(destinationFileName);

        while (fileInputStream.available() > 0)
        {

            int data = fileInputStream.read();
            System.out.print((char) data);
        //    fileOutputStream.write(data);
        }

        fileInputStream.close();
        //fileOutputStream.close();
    }

    private static boolean getSourceFileExist(String sourceFileName)
    {
        try
        {
            new FileInputStream(sourceFileName);
            return false;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Файл не существует.");
            return true;
        }
    }}
