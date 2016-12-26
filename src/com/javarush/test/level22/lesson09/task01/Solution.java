package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        StringBuilder s = new StringBuilder("");
        while (fileReader.ready()) {
            s.append(fileReader.readLine());
            s.append(" ");
        }
        fileReader.close();
        String[] words = s.toString().split(" ");
        for (int i = 0; i < words.length; i++) {
            StringBuilder firstWord = new StringBuilder(words[i]);
            String tmp = firstWord.reverse().toString();
            for (int j = i + 1; j < words.length; j++) {
                if ((words[i].equals(" "))) break;
                else {
                    if (words[j].equals(tmp)) {
                        result.add(new Pair(words[i], words[j]));
                        words[j] = " ";
                        break;
                    }
                }
            }
        }
        for (Pair p : result) System.out.println(p.toString());

    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
