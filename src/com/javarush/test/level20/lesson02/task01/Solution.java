    package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            //File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("f:/data.txt");
            InputStream inputStream = new FileInputStream("f:/data.txt");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);

            System.out.println(ivanov.name);
            for (Asset a : ivanov.assets){
                System.out.println(a.getName());
                System.out.println(a.getPrice());
            }
            System.out.println();
            System.out.println(somePerson.name);
            for (Asset a : somePerson.assets){
                System.out.println(a.getName());
                System.out.println(a.getPrice());
            }
            System.out.println();
            System.out.println(somePerson.equals(ivanov));
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(name);
            printWriter.println(assets.size());
                for (Asset a : assets) {
                    printWriter.println(a.getName());
                    printWriter.println(a.getPrice());
                }

            printWriter.flush();
            //implement this method - реализуйте этот метод

        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            this.name = reader.readLine();
            int assetSize = Integer.valueOf(reader.readLine());
            for (int i =0;i<assetSize;i++){
                Asset ass = new Asset(reader.readLine());
                ass.setPrice(Double.valueOf(reader.readLine()));
                this.assets.add(ass);
            }

            //implement this method - реализуйте этот метод
        }
    }
}
