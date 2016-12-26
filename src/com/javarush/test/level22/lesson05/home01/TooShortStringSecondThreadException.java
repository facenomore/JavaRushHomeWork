package com.javarush.test.level22.lesson05.home01;

public class TooShortStringSecondThreadException extends RuntimeException {
    Exception e;

    public TooShortStringSecondThreadException(Exception e) {
        super(e);
        this.e = e;
    }
}
