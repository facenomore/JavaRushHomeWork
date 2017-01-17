package com.javarush.test.level37.lesson04.big01.female;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.Human;

public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age) {
        return (age <= KidGirl.MAX_AGE) ? new KidGirl() : (age <= TeenGirl.MAX_AGE) ? new TeenGirl() : new Woman();
    }
}
