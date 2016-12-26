package com.javarush.test.level17.lesson10.bonus02;

import com.javarush.test.level17.lesson10.bonus01.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public volatile static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args.length > 0) {
            if ("-c".equals(args[0])) {
                for (int i = 1; i < args.length; i = i + 3) {
                    String args1 = args[i];
                    String args2 = args[i + 1];
                    String args3 = args[i + 2];
                    DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    Date birth = format.parse(args3);
                    if ("м".equals(args2)) allPeople.add(Person.createMale(args1, birth));
                    if ("ж".equals(args2)) allPeople.add(Person.createFemale(args1, birth));
                    System.out.println(allPeople.size()-1);
                }
            } else if ("-u".equals(args[0])) {
                Person person = null;
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                for (int i = 1; i < args.length; i = i + 4) {
                    String args1 = args[i];
                    String args2 = args[i + 1];
                    String args3 = args[i + 2];
                    String args4 = args[i + 3];
                    Date birth = format.parse(args4);
                    if ("м".equals(args3)) person=Person.createMale(args1, birth);
                    if ("ж".equals(args3)) person=Person.createFemale(args1, birth);
                    person.setName(args2);
                    allPeople.set(Integer.parseInt(args1), person);
                }
            } else if ("-d".equals(args[0])) {
                for (int j = 1; j < args.length; j++) {
                    String args1 = args[j];
                    int i = Integer.valueOf(args1);
                    allPeople.get(i).setName(null);
                    allPeople.get(i).setBirthDay(null);
                    allPeople.get(i).setName(null);
                }
            } else if ("-i".equals(args[0])) {
                DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                for (int j = 1; j < args.length; j++) {
                    String args1 = args[j];
                    int i = Integer.valueOf(args1);
                    if (allPeople.get(i).getSex() == Sex.MALE)
                        System.out.println(allPeople.get(i).getName() + " м " + format.format(allPeople.get(i).getBirthDay()));
                    if (allPeople.get(i).getSex() == Sex.FEMALE)
                        System.out.println(allPeople.get(i).getName() + " ж " + format.format(allPeople.get(i).getBirthDay()));
                }
            }
        } else System.out.println("Need to input parameters");
    }
}