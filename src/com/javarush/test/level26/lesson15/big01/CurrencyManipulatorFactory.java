package com.javarush.test.level26.lesson15.big01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class CurrencyManipulatorFactory {
    /*2. Валют может быть несколько, поэтому нам понадобится фабрика, которая будет создавать и хранить манипуляторы.
Создадим класс CurrencyManipulatorFactory со статическим методом getManipulatorByCurrencyCode(String currencyCode).
В этом методе будем создавать нужный манипулятор, если он еще не существует, либо возвращать ранее созданный.
Подумайте, где лучше хранить все манипуляторы.
Сделайте так, чтобы невозможно было создавать объекты CurrencyManipulatorFactory класса
     */
/*
В классе CurrencyManipulatorFactory создайте статический метод getAllCurrencyManipulators(), который вернет Collection всех манипуляторов.
У вас все манипуляторы хранятся в карте, не так ли? Если нет, то рефакторьте.
 */
    public static Map<String, CurrencyManipulator> currencyManipulators = new HashMap<String, CurrencyManipulator>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (!currencyManipulators.containsKey(currencyCode))
            currencyManipulators.put(currencyCode, new CurrencyManipulator(currencyCode));
        return currencyManipulators.get(currencyCode);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        Collection<CurrencyManipulator> collection = new ArrayList<>();
        for (Map.Entry<String, CurrencyManipulator> map : currencyManipulators.entrySet())
            collection.add(map.getValue());
        return collection;
    }
}
