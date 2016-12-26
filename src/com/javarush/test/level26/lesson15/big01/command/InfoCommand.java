package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "info_en");

    @Override
    public void execute() {
        Collection<CurrencyManipulator> manipulator = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        ConsoleHelper.writeMessage(res.getString("before"));
        if ((manipulator == null) || (manipulator.isEmpty())) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        } else
            for (CurrencyManipulator currencyManipulatorEntry : manipulator) {
                if (currencyManipulatorEntry.hasMoney())
                    ConsoleHelper.writeMessage(currencyManipulatorEntry.getCurrencyCode() + " - " + CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyManipulatorEntry.getCurrencyCode()).getTotalAmount());
                else ConsoleHelper.writeMessage(res.getString("no.money"));
            }
    }
}
/*
2.1. В классе CurrencyManipulatorFactory создайте статический метод getAllCurrencyManipulators(), который вернет Collection всех манипуляторов.
У вас все манипуляторы хранятся в карте, не так ли? Если нет, то рефакторьте.
2.2. В InfoCommand в цикле выведите [код валюты - общая сумма денег для выбранной валюты]
Запустим прогу и пополним счет на EUR 100 2 и USD 20 6, и посмотрим на INFO.
Все работает правильно?
 EUR - 200
 USD - 120
Отлично!
 */