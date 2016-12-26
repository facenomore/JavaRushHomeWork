package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес.
 Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //напишите тут ваш код
    private String name=null;
    private int weigth=5;
    private int age=5;
    private String color;
    private String adress=null;

    public Cat(String name){
        this.name=name;
    }

    public Cat(String name,int weigth,int age){
        this.name=name;
        this.weigth=weigth;
        this.age=age;
    }

    public Cat(String name,int age){
        this.name=name;
        this.age=age;
        this.weigth=5;
    }

    public Cat(int weigth,String color){
        this.weigth=weigth;
        this.color=color;
        this.name=null;
        this.adress=null;
        this.age=5;
    }

    public Cat(int weigth,String color, String adress){
        this.weigth=weigth;
        this.color=color;
        this.adress=adress;
    }

}
