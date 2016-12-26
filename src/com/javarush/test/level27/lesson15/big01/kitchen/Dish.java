package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Arrays;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        return values().length == 0 ? "" : Arrays.toString(values()).substring(1, Arrays.toString(values()).length() - 1);
    }
}

/*
1. Предположим, у нас известно время приготовления каждого блюда в минутах. Захардкодим его в классе Dish.
1.1. Измените создание элементов энама - Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
1.2. Создайте поле private int duration с геттером.
Чтобы создать геттер, нажмите Alt+Insert и выберите пункт Getter. Далее выберите имя поля и нажмите OK(Enter).
 */