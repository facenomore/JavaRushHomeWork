package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader1.readLine());
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

        int count = 0;
        char[] ch = new char[7];
        if (reader.ready())
            reader.read(ch);
        String s = String.valueOf(ch);
        if ((" world ".equals(s))||(" world,".equals(s))||(",world,".equals(s))||(" world\n".equals(s))
                ||(" world.".equals(s))||(".world,".equals(s))||(".world.".equals(s))||(" world\r".equals(s))) count++;
        while (reader.ready()) {
            ch[0] = (char) reader.read();
            s = s.substring(1, 7) + ch[0];
            if ((" world ".equals(s))||(" world,".equals(s))||(",world,".equals(s))||(" world\n".equals(s))
                    ||(" world.".equals(s))||(".world,".equals(s))||(".world.".equals(s))||(" world\r".equals(s))) count++;
        }
        System.out.println(count);
        fileInputStream.close();
        reader.close();
        reader1.close();
    }
}
