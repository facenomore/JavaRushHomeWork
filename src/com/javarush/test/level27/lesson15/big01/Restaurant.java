package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

public class Restaurant {
    public static void main(String[] args) {
        Waitor waitor = new Waitor();
        Cook cook = new Cook("Amigo");
        cook.addObserver(waitor);

        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);
        tablet.createOrder();
    }
}

/*
5. Пишем main.
Для объекта Observable добавляем свой объект Observer. См. п.2 и описание паттерна в wikipedia
Называем повара, имя не влияет на тесты. В моем варианте - это Amigo :)

Сверим выводы в консоль. Пример моего вывода:
Your order: [Water] of Tablet{number=5}
Start cooking - Your order: [Water] of Tablet{number=5}
Your order: [Water] of Tablet{number=5} was cooked by Amigo
 */