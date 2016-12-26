package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        //save cat to file
        File file = new File("d:/cat.dat");
        FileOutputStream fileOutput = null;
        try {
            fileOutput = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileInputStream fiStream = null;
        try {
            fiStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Solution savedObject = new Solution(4);
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(fileOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!savedObject.equals(null)) try {
            outputStream.writeObject(savedObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Solution newSavedObject = new Solution(6);

        //load cat from file

        ObjectInputStream objectStream = null;
        try {
            objectStream = new ObjectInputStream(fiStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Solution loadedObject = null;
        try {
            loadedObject = (Solution) objectStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fiStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            objectStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(savedObject.string.equals(loadedObject.string));
        System.out.println(savedObject.string);
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution() {
    }

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
