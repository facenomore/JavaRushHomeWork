package com.javarush.test.level29.lesson15.big01.human;

public class UniversityPerson {
    private University university;
    private String name;
    private int age;

    public UniversityPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public void printData() {
        System.out.println(getPosition() + ": " + getName());
    }

    public String getPosition() {
        return "";
    }

}
