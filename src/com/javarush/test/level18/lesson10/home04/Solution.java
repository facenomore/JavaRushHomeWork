package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream fileInputStream2 = new FileInputStream(reader.readLine());
        reader.close();

        File f = new File(s);
        FileReader fileReader = new FileReader(f);
        char[] buffer = new char[(int)f.length()];
        fileReader.read(buffer);
        System.out.println(new String(buffer));
        fileReader.close();

        byte[] byteBuffer = new byte[buffer.length];

        for (int i=0; i<buffer.length;i++)
            byteBuffer[i]=(byte) buffer[i];

        FileOutputStream fileOutputStream1 = new FileOutputStream(s);
        while (fileInputStream2.available()>0){
            fileOutputStream1.write(fileInputStream2.read());
        }
        fileInputStream2.close();
        fileOutputStream1.write(byteBuffer);
        fileOutputStream1.close();
    }
}
