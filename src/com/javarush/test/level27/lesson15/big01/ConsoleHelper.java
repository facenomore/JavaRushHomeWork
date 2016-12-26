package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String input = consoleReader.readLine();
        return input;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage("Выберите доступное блюдо или exit для выхода");
        writeMessage(Dish.allDishesToString());
        String input;
        List<Dish> dishOrder = new ArrayList<>();
        while (!(input = readString()).equalsIgnoreCase("exit")) {
            try {
                dishOrder.add(Dish.valueOf(input));
            } catch (IllegalArgumentException e) {
                writeMessage(input + " is not detected");
            }
        }
        return dishOrder;
    }
}