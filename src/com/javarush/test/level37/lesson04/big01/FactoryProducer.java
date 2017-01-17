package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.female.FemaleFactory;
import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

public class FactoryProducer {
    public enum HumanFactoryType {
        MALE, FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType humanFactoryType) {
        if (humanFactoryType == HumanFactoryType.MALE) return new MaleFactory();
        else if (humanFactoryType == HumanFactoryType.FEMALE) return new FemaleFactory();
        else return null;
    }
}
/*
4. В FactoryProducer создайт публичный статический метод getFactory с аргументом HumanFactoryType.
Этот метод должен возвращать одну из фабрик: для ключа MALE - MaleFactory, для FEMALE - FemaleFactory.
 */