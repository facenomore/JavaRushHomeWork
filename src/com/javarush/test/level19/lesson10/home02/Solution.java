package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader(args[0]));

        TreeMap<String, Double> treeMap = new TreeMap<>();

        String[] arr = new String[2];
        while (reader.ready()){
            arr=reader.readLine().split(" ");
            if(!treeMap.containsKey(arr[0])) treeMap.put(arr[0],Double.valueOf(arr[1]));
            else treeMap.put(arr[0],treeMap.get(arr[0]) + Double.valueOf(arr[1]));
        }
        reader.close();
        double max = 0.0;

        for (Map.Entry<String, Double> entry: treeMap.entrySet()){
            if (entry.getValue()>max) max=entry.getValue();
        }
        for (Map.Entry<String, Double> entry: treeMap.entrySet()){
            if (entry.getValue()==max) System.out.println(entry.getKey());
        }
    }
}

