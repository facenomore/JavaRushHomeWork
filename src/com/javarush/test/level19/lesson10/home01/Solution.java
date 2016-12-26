package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
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
        for (Map.Entry<String, Double> entry: treeMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
