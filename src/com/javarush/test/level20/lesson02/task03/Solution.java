package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties propert = new Properties();

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("f:/data.properties");
        Solution solution = new Solution();
        solution.load(fis);
        fis.close();
        solution.fillInPropertiesMap();
        for (Map.Entry p : properties.entrySet()) {
            System.out.println(p.getKey() + "    " + p.getValue());
        }
        FileOutputStream fos = new FileOutputStream("f:/new.p");
        solution.save(fos);
        fos.close();
    }

    public void fillInPropertiesMap() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        InputStream fileProperties = new FileInputStream(bufferedReader.readLine());
        bufferedReader.close();
        load(fileProperties);
        fileProperties.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        propert=new Properties();
        if (properties.size() > 0) {
            propert.putAll(properties);
            propert.store(outputStream, "");
            outputStream.close();
        }
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        propert.load(inputStream);
        inputStream.close();
        if (propert.size() > 0)
            for (Map.Entry p : propert.entrySet()) {
                if(p!=null)
                    properties.put(p.getKey().toString(), p.getValue().toString());
            }
    }

    //implement this method - реализуйте этот метод
}