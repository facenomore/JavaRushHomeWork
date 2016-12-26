package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        String file2=reader.readLine();
        FileInputStream inputStream1 = new FileInputStream(file1);
        FileOutputStream outputStream2 = new FileOutputStream(file2);
        byte[] b = new byte[inputStream1.available()];
        if (inputStream1.available()>0)
            inputStream1.read(b);
        for(int i=b.length-1;i>=0;i--)
            outputStream2.write(b[i]);
        inputStream1.close();
        outputStream2.close();
        reader.close();
    }
}
