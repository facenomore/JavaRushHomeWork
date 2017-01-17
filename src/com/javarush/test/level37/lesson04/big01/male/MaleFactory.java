package com.javarush.test.level37.lesson04.big01.male;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.Human;

public class MaleFactory implements AbstractFactory {
    public Human getPerson(int age) {
        return (age <= KidBoy.MAX_AGE) ? new KidBoy() : (age <= TeenBoy.MAX_AGE) ? new TeenBoy() : new Man();
    }
}
