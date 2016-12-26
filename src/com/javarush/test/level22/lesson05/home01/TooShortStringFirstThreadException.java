package com.javarush.test.level22.lesson05.home01;

public class TooShortStringFirstThreadException extends RuntimeException {
    Exception e;

    public TooShortStringFirstThreadException(Exception e) {
        super(e);
        this.e = e;
    }
}

