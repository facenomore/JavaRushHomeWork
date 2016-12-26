package com.javarush.test.level19.lesson10.bonus03;


/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>


Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>


text1, text2 могут быть пустыми
*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws IOException {
        String tag = args[0];
        String openTag = "<" + tag;
        String closeTag = "</" + tag + ">";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileInputStream = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        StringBuilder fileContent = new StringBuilder("");
        while (fileInputStream.ready()) {
            fileContent.append(fileInputStream.readLine());
        }
        String html = fileContent.toString();
        fileInputStream.close();

        int count = 0;
        List<Integer> indexes = new ArrayList<Integer>();
        List<TagIndexes> resultIndexes = new ArrayList<>();

        for (int i = 0; i <= html.length() - closeTag.length(); i++) {
            if (html.substring(i, i + openTag.length()).equals(openTag))
                indexes.add(i);
            if (html.substring(i, i + closeTag.length()).equals(closeTag)) {
                resultIndexes.add(new TagIndexes(indexes.get(indexes.size() - 1), i + closeTag.length()));
                indexes.remove(indexes.get(indexes.size() - 1));
            }
        }

        for (int i = 0; i < resultIndexes.size() - 1; i++) {
            for (int j = 0; j < resultIndexes.size() - i - 1; j++) {
                if (resultIndexes.get(j).getOpenIndex() > resultIndexes.get(j + 1).getOpenIndex()) {
                    TagIndexes tmp = resultIndexes.get(j);
                    resultIndexes.set(j, resultIndexes.get(j + 1));
                    resultIndexes.set(j + 1, tmp);
                }
            }
        }

        for (TagIndexes t : resultIndexes) {
            System.out.println(html.substring(t.getOpenIndex(), t.getCloseIndex()));
        }
    }

    static class TagIndexes {
        private int openIndex;
        private int closeIndex;

        public TagIndexes(int openIndex, int closeIndex) {
            this.openIndex = openIndex;
            this.closeIndex = closeIndex;
        }

        public int getOpenIndex() {
            return openIndex;
        }

        public int getCloseIndex() {
            return closeIndex;
        }

        @Override
        public String toString() {
            return "TagIndexes{" +
                    "openIndex=" + openIndex +
                    ", closeIndex=" + closeIndex +
                    '}';
        }
    }
}