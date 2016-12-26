package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public final class CommandExecutor {

    private CommandExecutor() {

    }

    static Map<Operation, Command> map = new HashMap<>();

    static {
        map.put(Operation.LOGIN, new LoginCommand());
        map.put(Operation.DEPOSIT, new DepositCommand());
        map.put(Operation.EXIT, new ExitCommand());
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.WITHDRAW, new WithdrawCommand());

    }

    public static final void execute(Operation operation) throws InterruptOperationException {
        if (map.containsKey(operation)) map.get(operation).execute();
    }

}
