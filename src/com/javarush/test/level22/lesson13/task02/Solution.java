package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.util.ArrayList;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);

        byte[] string = new byte[fileInputStream.available()];
        fileInputStream.read(string);
        fileInputStream.close();

        String s = new String (string,"UTF-8");

        byte[] winData = s.getBytes("Windows-1251");
        fileOutputStream.write(winData);
        fileOutputStream.close();
    }
}