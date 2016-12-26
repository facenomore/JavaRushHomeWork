package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(java.lang.String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream
        // according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream
        // в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("d:/data.txt");
            InputStream inputStream = new FileInputStream("d:/data.txt");

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            System.out.println(object.string1.number);
            System.out.println(object.string2.number);
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4


            loadedObject.load(inputStream);
            System.out.println(loadedObject.string1.number);
            System.out.println(loadedObject.string2.number);
            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(this.string1.number);
            printWriter.println(this.string2.number);
            printWriter.flush();
            printWriter.close();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            this.string1.number=Integer.valueOf(reader.readLine());
            this.string2.number=Integer.valueOf(reader.readLine());
            reader.close();
            //implement this method - реализуйте этот метод
        }
    }

    public static int countStrings;

    public static class String {
        private int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
