package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        int age;
        boolean sex;
        int height;
        int weight;
        Human child;
        Human parents;

        Human(){}

        Human(int age,boolean sex, int height, int weight){}

        Human(int age,boolean sex, int height, int weight, Human child){}

        Human(int age,boolean sex, int height, int weight, Human child, Human parents){}

        Human(int age,boolean sex){}

        Human(int age,boolean sex, Human child){}

        Human(int age,boolean sex, Human child, Human parents){}

        Human(int age, Human parents, boolean sex){}

        Human(int age){}

        Human(int age,boolean sex, int height){}
        //напишите тут ваши переменные и конструкторы
    }
}
