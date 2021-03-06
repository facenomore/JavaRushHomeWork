package com.javarush.test.level19.lesson10.home04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stringFile = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(stringFile.readLine()));
        stringFile.close();
        while (reader.ready()){
            int count=0;
            String s= reader.readLine();
            for (int i=0; i<s.length();i++) if (s.toCharArray()[i]==' ') count++;
            String[] word = new String[count+1];
            word=s.split(" ");
            int countWord=0;
            for (String z : word) {
                if (words.contains(z)) countWord++;
            }
            if (countWord==2) System.out.println(s);
        }
    reader.close();
    }

}
