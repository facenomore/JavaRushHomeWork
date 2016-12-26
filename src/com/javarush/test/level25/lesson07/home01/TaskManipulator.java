package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private String threadName;
    private Thread thread;

    @Override
    public void run() {
        try {
            Thread.sleep(0);
            while (!thread.isInterrupted()) {
                System.out.println(threadName);
                Thread.sleep(90);
            }
        } catch (InterruptedException e) {
        }

    }

    @Override
    public void start(String threadName) {
        this.threadName = threadName;
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
