package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()) {
            String s = reader.readLine();
            String year = s.substring(s.lastIndexOf(" ") + 1);
            s = s.substring(0, s.lastIndexOf(" "));
            String month = s.substring(s.lastIndexOf(" ") + 1);
            s = s.substring(0, s.lastIndexOf(" "));
            String day = s.substring(s.lastIndexOf(" ") + 1);
            s = s.substring(0, s.lastIndexOf(" "));
            DateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date dateDate = format.parse(day + " " + month + " " + year);
            PEOPLE.add(new Person(s, dateDate));
        }
        reader.close();
       /* for(Person p : PEOPLE){
            System.out.println(p.getName()+ " " + p.getBirthday());
        }*/
    }


}
