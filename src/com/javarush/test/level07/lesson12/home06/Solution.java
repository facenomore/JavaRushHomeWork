package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> people= new ArrayList<Human>();
        people.add(new Human("Коля", true, 55));
        people.add(new Human("Петя", true, 60));
        people.add(new Human("Вика", false, 54));
        people.add(new Human("Настя", false, 52));
        people.add(new Human("Вова", true, 45,people.get(0),people.get(2)));
        people.add(new Human("Ира", false, 40,people.get(1),people.get(3)));
        people.add(new Human("Андрей", true, 25,people.get(4),people.get(5)));
        people.add(new Human("Богдан", true, 23,people.get(4),people.get(5)));
        people.add(new Human("Аня", true, 20,people.get(4),people.get(5)));

        for (int i=0;i<people.size();i++)
            System.out.println(people.get(i).toString());
        //напишите тут ваш код
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother){
           this.name=name;
            this.sex=sex;
            this.age=age;
            this.father=father;
            this.mother=mother;
        }
        public Human(String name ,boolean sex, int age){
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.father=null;
            this.mother=null;
        }
        //напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
