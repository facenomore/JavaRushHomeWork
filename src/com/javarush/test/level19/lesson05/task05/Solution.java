package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameRead = bufferedReader.readLine();
        String fileNameWrite = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileNameRead));
        PrintWriter printWriter = new PrintWriter(new FileWriter(fileNameWrite));
        String nextLine;
        while ((nextLine = fileReader.readLine()) != null) {
            String s;
            s = nextLine.replaceAll("\\p{Punct}", "");
            printWriter.println(s);
        }

        fileReader.close();
        printWriter.close();
    }
}
