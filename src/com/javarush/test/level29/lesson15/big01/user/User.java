package com.javarush.test.level29.lesson15.big01.user;

public class User {
    private String name;
    private String surname;
    private int age;
    private boolean man;
    private Address address;


    private Work work;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

    public String getAddress() {
        return address.getCountry() + " " + address.getCity() + " " + address.getHouse();
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public void printInfo() {
        System.out.println("Имя: " + this.getName());
        System.out.println("Фамилия: " + this.getSurname());
        printAdditionalInfo();
    }

    public void printAdditionalInfo() {
        if (this.getAge() < 16)
            System.out.println("Пользователь моложе 16 лет");
        else
            System.out.println("Пользователь старше 16 лет");
    }

    public String getBoss() {
        return work.getBoss();
    }
}

/*
14.1.	Перемещение поля. Замени поля isManAnya и isManRoma полем man в нужном классе.
Добавь сеттер и геттер для нового поля (при выборе имен методов учти тип поля).
14.2.	Извлечение класса.
14.2.1.	Добавь класс Address в пакет user.
14.2.2.	Перенеси поля country, city и house в новый класс.
14.2.3.	Добавь сеттеры и геттеры для них.
14.2.4.	Перепиши класс User, используя поле класса Address address.
14.3.	Встраивание класса. Класс House почти ничего не делает, избавься от него.
14.4.	Сокрытие делегирования.
14.4.1.	Добавь в класс User метод getBoss().
14.4.2.	Перепиши реализацию метода getBoosName(User user) класса UserHelper.
 */