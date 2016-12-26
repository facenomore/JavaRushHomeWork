package com.javarush.test.level19.lesson08.task02;

/* Ридер обертка 2
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна заменять все подстроки "te" на "??"
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        String modify = "";
/*        for (int i = 0; i < result.length() - 1; i++) {
            String s = "" + result.toCharArray()[i] + result.toCharArray()[i + 1];
            if ("te".equals(s)) {
                modify += "??";
                i++;
            } else modify += result.toCharArray()[i];
        }
        String s = "" + result.toCharArray()[result.length()-2] + result.toCharArray()[result.length()-1];
        if (!"te".equals(s)) modify+=result.toCharArray()[result.length()-1];*/
        modify = result.replace("te", "??");


        System.setOut(consoleStream);
        System.out.println(modify);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
