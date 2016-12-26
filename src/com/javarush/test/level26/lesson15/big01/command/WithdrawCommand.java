package com.javarush.test.level26.lesson15.big01.command;


/*
1. Реализуйте следующий алгоритм для команды WithdrawCommand:
1.1. Считать код валюты (метод уже есть)
1.2. Получить манипулятор для этой валюты.
1.3. Пока пользователь не введет корректные данные выполнять:
1.3.1. Попросить ввести сумму
1.3.2. Если введены некорректные данные, то сообщить об этом пользователю и вернуться к п. 1.3.
1.3.3. Проверить, достаточно ли средств на счету.
Для этого в манипуляторе создайте метод boolean isAmountAvailable(int expectedAmount), который вернет true, если денег достаточно для выдачи.
Если недостаточно, то вернуться к п. 1.3.
1.3.4. Списать деньги со счета. Для этого в манируляторе создайте метод
Map<Integer, Integer> withdrawAmount(int expectedAmount), который вернет карту Map<номинал, количество>.
Подробно логику этого метода смотрите в п.2.
1.3.5. Вывести пользователю результат из п. 1.3.4. в следующем виде:
<табуляция>номинал - количество
Сортировка - от большего номинала к меньшему.
Вывести сообщение об успешной транзакции.
1.3.6. Перехватить исключение NotEnoughMoneyException, уведомить юзера о нехватке банкнот и вернуться к п. 1.3.

 */

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        Integer expectedAmount;
        try {
            do {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                String s = ConsoleHelper.readString();
                try {
                    expectedAmount = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                    expectedAmount = -1;
                }
                if (!manipulator.isAmountAvailable(expectedAmount))
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            } while ((expectedAmount < 0) || (!manipulator.isAmountAvailable(expectedAmount)));

            for (Map.Entry<Integer, Integer> mapEntry : manipulator.withdrawAmount(expectedAmount).entrySet()) {
                ConsoleHelper.writeMessage("\t" + mapEntry.getKey() + " - " + mapEntry.getValue());
            }
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), expectedAmount, currencyCode));
        } catch (NotEnoughMoneyException e) {
            ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
        }
    }
}
/*
before=Withdrawing...
success.format=%d %s was withdrawn successfully
specify.amount=Please specify integer amount for withdrawing.
specify.not.empty.amount=Please specify valid positive integer amount for withdrawing.
not.enough.money=Not enough money on your account, please try again
exact.amount.not.available=Exact amount is not available
 */