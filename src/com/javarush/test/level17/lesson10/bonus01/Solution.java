package com.javarush.test.level17.lesson10.bonus01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args.length > 0) {
            if ((args.length == 4) && ("-c".equals(args[0]))) {
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date birth = format.parse(args[3]);
                if ("м".equals(args[2])) allPeople.add(Person.createMale(args[1], birth));
                if ("ж".equals(args[2])) allPeople.add(Person.createFemale(args[1], birth));
                System.out.println(allPeople.size()-1);
            }
            else if ((args.length == 5) && ("-u".equals(args[0]))) {
                Person person = null;
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date birth = format.parse(args[4]);
                if ("м".equals(args[3])) person = Person.createMale(args[1], birth);
                if ("ж".equals(args[3])) person = Person.createFemale(args[1], birth);
                person.setName(args[2]);
                allPeople.set(Integer.parseInt(args[1]), person);
            } else if ((args.length == 2) && ("-d".equals(args[0]))) {
                int i=Integer.valueOf(args[1]);
                allPeople.get(i).setName(null);
                allPeople.get(i).setBirthDay(null);
                allPeople.get(i).setName(null);
            } else if ((args.length == 2) && ("-i".equals(args[0]))) {
                DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                int i=Integer.valueOf(args[1]);
                if (allPeople.get(i).getSex() == Sex.MALE) System.out.println(allPeople.get(i).getName()+ " м " +  format.format(allPeople.get(i).getBirthDay()));
                if (allPeople.get(i).getSex() == Sex.FEMALE) System.out.println(allPeople.get(i).getName()+ " ж " +  format.format(allPeople.get(i).getBirthDay()));
            }
        } else System.out.println("Need to input parameters");

       /* for (Person person : allPeople) {
            DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(person.getName()+" "+  person.getSex() + " " +  format.format(person.getBirthDay()));
        }*/
    }
}