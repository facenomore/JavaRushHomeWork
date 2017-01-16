package com.javarush.test.level25.lesson09.task03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    public static void main(String[] args) {
        Throwable e = new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        new Solution().uncaughtException(Thread.currentThread(), e);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<String> messages = new ArrayList<>();
        Throwable tmp = e;
        if (e != null) messages.add(e.toString());
        while (tmp.getCause() != null) {
            tmp = tmp.getCause();
            messages.add(tmp.toString());
        }

        Collections.reverse(messages);
        for (String message : messages) System.out.println(message);

    }
}