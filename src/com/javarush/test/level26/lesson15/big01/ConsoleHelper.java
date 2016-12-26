package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

public class ConsoleHelper {
    /*
2. Чтобы считать код валюты, добавим статический метод String askCurrencyCode() в ConsoleHelper.
Этот метод должен предлагать пользователю ввести код валюты, проверять, что код содержит 3 символа.
Если данные некорректны, то сообщить об этом пользователю и повторить.
Если данные валидны, то перевести код в верхний регистр и вернуть.

3. Чтобы считать номинал и количество банкнот, добавим статический метод String[] getValidTwoDigits(String currencyCode) в ConsoleHelper.
Этот метод должен предлагать пользователю ввести два целых положительных числа.
Первое число - номинал, второе - количество банкнот.
Никаких валидаторов на номинал нет. Т.е. 1200 - это нормальный номинал.
Если данные некорректны, то сообщить об этом пользователю и повторить.
Пример вводимых данных:
200 5

4. В классе CurrencyManipulator создайте метод void addAmount(int denomination, int count),
который добавит введенные номинал и количество банкнот

5. Пора уже увидеть приложение в действии.
В методе main захардкодь логику пункта 1.
Кстати, чтобы не было проблем с тестами на стороне сервера, добавь в метод main первой строчкой Locale.setDefault(Locale.ENGLISH);
Запускаем, дебажим, смотрим.
     */
/*
Задание 6
Чтобы отрефакторить код в соответствии с паттерном Command, нужно выделить в коде несколько логических блоков кода.
У нас пока два таких блока: 1) код операции DEPOSIT, 2) код операции INFO.
Они захардкожены в методе main. Нужно от этого избавиться.
Нужно сделать так, чтобы пользователь сам выбирал, какую операцию на данный момент нужно выполнять.

2. В классе ConsoleHelper реализуйте логику статического метода Operation askOperation()
Спросить у пользователя операцию.
Если пользователь вводит 1, то выбирается команда INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
Используйте метод, описанный в п.1.
Обработай исключение - запроси данные об операции повторно.

 */
    private static ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "common_en");
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static Operation askOperation() throws InterruptOperationException {
        String s;
        Operation o;
        while (true) {
            try {
                writeMessage(res.getString("choose.operation"));
                s = readString();
                o = Operation.getAllowableOperationByOrdinal(Integer.parseInt(s));
                break;
            } catch (NumberFormatException e) {
                writeMessage(res.getString("invalid.data"));
            }
        }
        return o;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] s;
        while (true) {
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
            String tmp = readString();
            try {
                s = tmp.split(" ");
                int nom = Integer.parseInt(s[0]);
                int kol = Integer.parseInt(s[1]);
                if (nom <= 0 || kol <= 0 || s.length != 2) {
                    writeMessage(res.getString("invalid.data"));
                    continue;
                } else return s;
            } catch (NumberFormatException e) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String s;
        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            s = readString();
            if (s.length() == 3) break;
            else writeMessage(res.getString("invalid.data"));
        }
        return s.toUpperCase();
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String s;
        try {
            s = reader.readLine();
            if (res.getString("operation.EXIT").equalsIgnoreCase(s))
                throw new InterruptOperationException();
            return s;
        } catch (IOException e) {
        }
        return null;
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}
