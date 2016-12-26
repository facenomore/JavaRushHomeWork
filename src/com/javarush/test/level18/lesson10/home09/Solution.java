package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String s = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                s = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                File file = new File(s);
                if (!file.exists()) throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                System.out.println(s);
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            }
        }

    }
}
