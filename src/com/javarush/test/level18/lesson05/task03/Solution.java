package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        String file2=reader.readLine();
        String file3=reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(file1);
        FileOutputStream outputStream2 = new FileOutputStream(file2);
        FileOutputStream outputStream3 = new FileOutputStream(file3);

        int bufferSize=inputStream1.available()/2;
        int fileSize=inputStream1.available();
        byte[] buffer = new byte[bufferSize];

        int count = inputStream1.read(buffer);
        outputStream2.write(buffer,0,count);

        if ((fileSize%2)==1){
            int i=inputStream1.read();
            outputStream2.write(i);
        }

        count = inputStream1.read(buffer);
        outputStream3.write(buffer,0,count);

        reader.close();
        inputStream1.close();
        outputStream2.close();
        outputStream3.close();
    }
}
