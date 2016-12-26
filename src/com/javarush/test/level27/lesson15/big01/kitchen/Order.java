package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private List<Dish> dishes;
    private Tablet orderedTablet;

    public int getTotalCookingTime() {
        int result = 0;
        for (Dish d : dishes) {
            result += d.getDuration();
        }
        return result;
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) return "";
        String chosenDishString = String.format("Your order: %s of %s", dishes, orderedTablet);
        return chosenDishString;
    }

    public Order(Tablet orderedTablet) throws IOException {
        this.orderedTablet = orderedTablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

}