package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();


    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while (!"exit".equals(s)) {
            s = reader.readLine();
            if (!"exit".equals(s) && (s != null) && (new File(s).exists()))
                new ReadThread(s).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }


        @Override
        public void run() {

            super.run();
            HashMap<Integer, Integer> byteCount = new HashMap<>();
            int max = 0;
            int maxCountByte = 0;

            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available() > 0) {
                    int b = fileInputStream.read();
                    if (!byteCount.containsKey(b)) byteCount.put(b, 1);
                    else byteCount.put(b, byteCount.get(b) + 1);
                }
                fileInputStream.close();

                for (Map.Entry<Integer, Integer> entry : byteCount.entrySet()) {
                    if (max < entry.getValue()) {
                        max = entry.getValue();
                        maxCountByte = entry.getKey();
                    }
                }

                synchronized (resultMap) {
                    resultMap.put(fileName, maxCountByte);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
