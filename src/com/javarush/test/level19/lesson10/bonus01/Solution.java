package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1Reader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader file2Reader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        List<String> file1Lines = new ArrayList<>();
        while (file1Reader.ready()) {
            file1Lines.add(file1Reader.readLine());
        }

        List<String> file2Lines = new ArrayList<>();
        while (file2Reader.ready()) {
            file2Lines.add(file2Reader.readLine());
        }
        file1Reader.close();
        file2Reader.close();

        while (file1Lines.size() > 0 && file2Lines.size() > 0) {
            if (file1Lines.get(0).equals(file2Lines.get(0))) {
                lines.add(new LineItem(Type.SAME, file1Lines.get(0)));
                file1Lines.remove(0);
                file2Lines.remove(0);
            } else if ((file2Lines.size() > 1) && (file1Lines.get(0).equals(file2Lines.get(1)))) {
                lines.add(new LineItem(Type.ADDED, file2Lines.get(0)));
                file2Lines.remove(0);
            } else if ((file2Lines.size() > 1) && (!file1Lines.get(0).equals(file2Lines.get(1)))) {
                lines.add(new LineItem(Type.REMOVED, file1Lines.get(0)));
                file1Lines.remove(0);
            }
        }

        if (file1Lines.size() > 0) lines.add(new LineItem(Type.REMOVED, file1Lines.get(0)));
        else if (file2Lines.size() > 0) lines.add(new LineItem(Type.ADDED, file2Lines.get(0)));
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
