package com.javarush.test.level26.lesson15.big01.command;

/*
Сегодня мы займемся командой ExitCommand.
1. Реализуйте следующую логику в команде ExitCommand:
1.1. Спросить, действительно ли пользователь хочет выйти - варианты <y,n>.
1.2. Если пользователь подтвердит свои намерения, то попрощаться с ним.
 */

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

class ExitCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "exit_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String s = ConsoleHelper.readString().toLowerCase().trim();
        if (s.equals(res.getString("yes"))) ConsoleHelper.writeMessage(res.getString("thank.message"));
    }
}
