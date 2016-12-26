package com.javarush.test.level25.lesson02.task02;

import java.util.LinkedList;
import java.util.List;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels = new LinkedList<>();

        public Car() {
            for (String s : loadWheelNamesFromDB()) {
                try {
                    if ("FRONT_LEFT".equals(s)) wheels.add(Wheel.FRONT_LEFT);
                    else if ("FRONT_RIGHT".equals(s)) wheels.add(Wheel.FRONT_RIGHT);
                    else if ("BACK_LEFT".equals(s)) wheels.add(Wheel.BACK_LEFT);
                    else if ("BACK_RIGHT".equals(s)) wheels.add(Wheel.BACK_RIGHT);
                    else throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    System.out.println("Это не машина!");
                }
            }
            //init wheels here
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}
