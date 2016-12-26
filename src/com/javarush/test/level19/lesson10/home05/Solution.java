package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        String pattern = "0123456789";
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String fin="";
        while (reader.ready()) {
            int count = 0;
            String s = reader.readLine();
            for (int i = 0; i < s.length(); i++) if (s.toCharArray()[i] == ' ') count++;
            String[] word = new String[count + 1];
            word = s.split(" ");
            for (String z : word) {
                for (Character c : pattern.toCharArray()) {
                    if (z.contains(String.valueOf(c))) {
                        fin+=z;
                        fin+=" ";
                        break;
                    }
                }
            }
        }
        writer.write(fin);
        reader.close();
        writer.close();
    }
}

