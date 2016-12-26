package com.javarush.test.level22.lesson05.task01;

import java.lang.reflect.Array;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.printf(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        StringBuilder resultString = new StringBuilder("");
        if (string==null) throw new TooShortStringException();
        String parts[] = string.split(" ");
        if ((parts.length <= 4)) {
            throw new TooShortStringException();
        } else {
            resultString.append(parts[1]);
            resultString.append(" ");
            resultString.append(parts[2]);
            resultString.append(" ");
            resultString.append(parts[3]);
            resultString.append(" ");
            resultString.append(parts[4]);
        }
        return resultString.toString();
    }

    public static class TooShortStringException extends Exception {
    }
}
