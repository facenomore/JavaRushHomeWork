package com.javarush.test.level28.lesson06.home01;

public class MyThread extends Thread {
    private static int threadPriority = 1;

    public MyThread() {
        setPriority(threadPriority);
        threadPriority++;
        if (threadPriority == 11) threadPriority = 1;
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority(threadPriority);
        threadPriority++;
        if (threadPriority == 11) threadPriority = 1;
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority(threadPriority);
        threadPriority++;
        if (threadPriority == 11) threadPriority = 1;
    }

    public MyThread(String name) {
        super(name);
        setPriority(threadPriority);
        threadPriority++;
        if (threadPriority == 11) threadPriority = 1;
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority(threadPriority);
        threadPriority++;
        if (threadPriority == 11) threadPriority = 1;
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority(threadPriority);
        threadPriority++;
        if (threadPriority == 11) threadPriority = 1;
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority(threadPriority);
        threadPriority++;
        if (threadPriority == 11) threadPriority = 1;
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority(threadPriority);
        threadPriority++;
        if (threadPriority == 11) threadPriority = 1;
    }
}