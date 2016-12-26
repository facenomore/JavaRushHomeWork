package com.javarush.test.level26.lesson15.big01.command;

/*
3. Создадим LoginCommand по аналогии с другими командами, в котором захардкодим номер карточки с пином
123456789012 и 1234 соответственно.
4. Реализуйте следующую логику для команды LoginCommand:
4.1. Пока пользователь не введет валидные номер карты и пин - выполнять следующие действия
4.2. Запросить у пользователя 2 числа - номер кредитной карты, состоящий из 12 цифр, и пин - состоящий из 4 цифр
4.3. Вывести юзеру сообщение о невалидных данных, если они такими являются.
4.4. Если данные валидны, то проверить их на соответствие захардкоженным (123456789012 и 1234).
4.5. Если данные в п. 4.4. идентифицированы, то сообщить, что верификация прошла успешно.
4.6. Если данные в п. 4.4. НЕ идентифицированы, то вернуться к п.4.1.
 */

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;
/*
before=Logging in...
specify.data=Please specify your credit card number and pin code or type 'EXIT' for exiting.
success.format=Credit card [%s] is verified successfully!
not.verified.format=Credit card [%s] is not verified.
try.again.or.exit=Please try again or type 'EXIT' for urgent exiting
try.again.with.details=Please specify valid credit card number - 12 digits, pin code - 4 digits.
 */

class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        String cardNumber;
        String pin;
        Pattern pCardNumber = Pattern.compile("^\\d{12}$");
        Pattern pPin = Pattern.compile("^\\d{4}$");
        do {
            do {
                ConsoleHelper.writeMessage(res.getString("before"));
                ConsoleHelper.writeMessage(res.getString("specify.data"));
                cardNumber = ConsoleHelper.readString();
                pin = ConsoleHelper.readString();
                Matcher mCardNumber = pCardNumber.matcher(cardNumber);
                Matcher mPin = pPin.matcher(pin);
                if (mCardNumber.matches() && mPin.matches()) break;
                else ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            } while (true);
            if (validCreditCards.containsKey(cardNumber) && validCreditCards.getString(cardNumber).equals(pin)) {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));
                break;
            } else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        } while (true);
    }
}