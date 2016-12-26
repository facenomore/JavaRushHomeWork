package com.javarush.test.level26.lesson15.big01;
/*
1. Создадим класс CurrencyManipulator, который будет хранить всю информацию про выбранную валюту.
String currencyCode - код валюты, например, USD. Состоит из трех букв
Map<Integer, Integer> denominations - это Map<номинал, количество>
Чтобы можно было посмотреть, к какой валюте относится манипулятор, добавим геттер для currencyCode
Очевидно, что манипулятор никак не может функционировать без названия валюты,
поэтому добавим конструктор с этим параметром и проинициализируем currencyCode
4. В классе CurrencyManipulator создайте метод void addAmount(int denomination, int count),
который добавит введенные номинал и количество банкнот
 */
/*
1.В предыдущем таске мы реализовали основную логику операции DEPOSIT.
Но посмотреть результат так и не удалось.
Поэтому создадим в манипуляторе метод int getTotalAmount(), который посчитает общую сумму денег для выбранной валюты.

2. Добавим вызов метода getTotalAmount() в метод main.
Всё работает верно? Тогда движемся дальше.
Видно, что метод getTotalAmount() считает то, что нам необходимо для операции INFO.
Поэтому пришло время небольшого рефакторинга.
!!Читайте паттерн Command.
Однако, перед рефакторингом нужно еще разобраться в одном вопросе. Но об этом не сейчас.
 */
/*
2. Логика основного метода withdrawAmount:
2.1. Внимание!!! Метод withdrawAmount должен возвращать минимальное количество банкнот, которыми набирается запрашиваемая сумма.
Используйте Жадный алгоритм (use google).
Если есть несколько вариантов, то использовать тот, в котором максимальное количество банкнот высшего номинала.
Если для суммы 600 результат - три банкноты: 500 + 50 + 50 = 200 + 200 + 200, то выдать первый вариант.
Пример, надо выдать 600
В манипуляторе есть следующие банкноты:
500 - 2
200 - 3
100 - 1
50 - 12
Результат должен быть таким:
500 - 1
100 - 1
т.е. всего две банкноты (это минимальное количество банкнот) номиналом 500 и 100.
 */

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CurrencyManipulator {
    String currencyCode;
    Map<Integer, Integer> denominations = new TreeMap<>(Collections.reverseOrder());

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> withdrawAmount = new TreeMap<>(Collections.reverseOrder());
        int needAmount = expectedAmount;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            int i = 0;
            int count = entry.getValue();
            while ((entry.getKey() <= needAmount) && (count > 0)) {
                needAmount = needAmount - entry.getKey();
                count--;
                withdrawAmount.put(entry.getKey(), ++i);
            }
        }
        if (needAmount > 0) throw new NotEnoughMoneyException();
        else {
            for (Map.Entry<Integer, Integer> entry : withdrawAmount.entrySet()) {
                denominations.put(entry.getKey(), denominations.get(entry.getKey()) - entry.getValue());
            }
        }
        return withdrawAmount;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return (getTotalAmount() >= expectedAmount);
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (Map.Entry<Integer, Integer> i : denominations.entrySet())
            totalAmount += i.getKey() * i.getValue();
        return totalAmount;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination, count);
    }

    public boolean hasMoney() {
        return getTotalAmount() > 0;
    }
}