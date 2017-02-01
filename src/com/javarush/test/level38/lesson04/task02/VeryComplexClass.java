package com.javarush.test.level38.lesson04.task02;

/* Непроверяемые исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен
всегда кидать непроверяемое исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен
всегда кидать непроверяемое исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.
*/

import java.util.ArrayList;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Integer integer = (Integer) new Object();
    }

    public void methodThrowsNullPointerException() {
        Integer integer = null;
        if (integer == 0) ;
    }
}