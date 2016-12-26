package com.javarush.test.level26.lesson15.big01;

/*
В энум Operation добавьте статический метод Operation getAllowableOperationByOrdinal(Integer i)
Должен возвращать элемент энума: для 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
На некорректные данные бросать IllegalArgumentException
 */
public enum Operation {
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        Operation operation = null;
        switch (i) {
            case 1:
                operation = INFO;
                break;
            case 2:
                operation = DEPOSIT;
                break;
            case 3:
                operation = WITHDRAW;
                break;
            case 4:
                operation = EXIT;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return operation;
    }
}
