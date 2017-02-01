package com.javarush.test.level38.lesson06.home01;

public class ExceptionFactory {
    public static Throwable getException(Enum anEnum) {
        if (anEnum != null) {
            String message = anEnum.toString().substring(0, 1).toUpperCase()
                    + anEnum.toString().substring(1).toLowerCase().replace("_", " ");
            if (anEnum instanceof ExceptionApplicationMessage) return new Exception(message);
            else if (anEnum instanceof ExceptionDBMessage) return new RuntimeException(message);
            else if (anEnum instanceof ExceptionUserMessage) return new Error(message);
        }
        return new IllegalArgumentException();
    }
}