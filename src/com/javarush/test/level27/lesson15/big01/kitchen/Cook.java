package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable tablet, Object order) {
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + ((Order) order).getTotalCookingTime() + "min");
        setChanged();
        notifyObservers(order);
    }
}
/*
2.4. Добавим нашему повару вывод в консоль этой информации. Пусть теперь выводится аналогичное сообщение:
Start cooking - Your order: [Soup, Juice, Water] of Tablet{number=5}, cooking time 23min
 */