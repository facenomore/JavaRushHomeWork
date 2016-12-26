package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("f:/data.txt", null);
            OutputStream outputStream = new FileOutputStream("f:/data.txt");
            InputStream inputStream = new FileInputStream("f:/data.txt");

            JavaRush javaRush = new JavaRush();
            User ua = new User();
            ua.setBirthDate(new Date());
            ua.setCountry(User.Country.UKRAINE);
            ua.setFirstName("Андрій");
            ua.setLastName("Тодчук");
            ua.setMale(true);
            User ru = new User();
            User other = new User();


            javaRush.users.add(ua);
            javaRush.users.add(ru);
            javaRush.users.add(other);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            for (User u : loadedObject.users) {
                System.out.println(u.getFirstName());
                System.out.println(u.getLastName());
                System.out.println(u.getBirthDate());
                System.out.println(u.isMale());
                System.out.println(u.getCountry());
            }
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (int i = 0; i < users.size(); i++) {
                printWriter.println(users.get(i).getFirstName());
                printWriter.println(users.get(i).getLastName());
                printWriter.println(users.get(i).getBirthDate());
                printWriter.println(users.get(i).isMale());
                printWriter.println(users.get(i).getCountry());
                printWriter.flush();
            }
            printWriter.flush();
            printWriter.close();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                User use = new User();
                String s;
                s = reader.readLine();
                if (!s.equals("null")) use.setFirstName(s);
                else use.setFirstName(null);
                s = reader.readLine();
                if (!s.equals("null")) use.setLastName(s);
                else use.setLastName(null);
                DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                s = reader.readLine();
                if (!s.isEmpty() && !(s.equals("null"))) {
                    Date dateDate = format.parse(s);
                    use.setBirthDate(dateDate);
                } else use.setBirthDate(null);
                s = reader.readLine();
                use.setMale(Boolean.valueOf(s));
                s = reader.readLine();
                if (s.equals(User.Country.UKRAINE.toString())) {
                    use.setCountry(User.Country.UKRAINE);
                } else if (s.equals(User.Country.RUSSIA.toString())){
                    use.setCountry(User.Country.RUSSIA);
                } else use.setCountry(User.Country.OTHER);
                users.add(use);
            }
            reader.close();
            //implement this method - реализуйте этот метод
        }
    }
}
