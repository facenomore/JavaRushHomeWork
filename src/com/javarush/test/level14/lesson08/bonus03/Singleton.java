package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Tod on 11.04.2016.
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton(){
    }

    static Singleton getInstance(){
       return instance;
    }
}
