package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    protected ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        int i = 1;
        try {
            while (!currentThread.isInterrupted()) {
                map.put(String.format("Some text for %d", i), String.format("Some text for %d", i));
                i++;
                currentThread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", currentThread.getName()));
        }

    }
}
/*
1. каждые полсекунды выводить на консоль с новой строки начиная с 1 фразу [Some text for i] ,
 пример "Some text for 1"
2. при возникновении исключения выводить в консоль [[TREAD_NAME] thread was terminated],
 пример "[thread-1] thread was terminated"
*/
