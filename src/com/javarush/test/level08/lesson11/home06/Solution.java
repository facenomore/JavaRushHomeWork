package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human petya = new Human("Петя",true, 8);
        Human vasya = new Human("Вася",true, 10);
        Human ira = new Human("Ира",false, 3);
        ArrayList<Human> children1 = new ArrayList<>();
        children1.add(petya);
        children1.add(vasya);
        children1.add(ira);
        Human nikolay = new Human("Николай", true, 30, children1);
        Human vasilisa = new Human("Василиса", false, 30, children1);
        ArrayList<Human> pearent1 = new ArrayList<>();
        pearent1.add(nikolay);
        ArrayList<Human> pearent2 = new ArrayList<>();
        pearent2.add(vasilisa);
        Human afanasiy = new Human("Афанасий",true, 60, pearent1);
        Human paraska = new Human("Параска",false, 55, pearent1);
        Human sava = new Human("Сава",true, 60, pearent2);
        Human gafonia = new Human("Гафонья",false, 55, pearent2);
        System.out.println(petya.toString());
        System.out.println(vasya.toString());
        System.out.println(ira.toString());
        System.out.println(nikolay.toString());
        System.out.println(vasilisa.toString());
        System.out.println(afanasiy.toString());
        System.out.println(paraska.toString());
        System.out.println(sava.toString());
        System.out.println(gafonia.toString());
        //напишите тут ваш код
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
        //напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
