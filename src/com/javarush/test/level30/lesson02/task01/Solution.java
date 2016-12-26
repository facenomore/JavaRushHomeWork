package com.javarush.test.level30.lesson02.task01;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        int radix = 8;
        String intString = s;
        if (!"0".equals(s.substring(0, 1))) {
            radix = 10;
        } else if ("0b".equals(s.substring(0, 2))) {
            radix = 2;
            intString = s.substring(2, s.length());
        } else if ("0x".equals(s.substring(0, 2))) {
            radix = 16;
            intString = s.substring(2, s.length());
        } else {
            intString = s.substring(1, s.length());
        }

        Integer i = Integer.parseInt(intString, radix);
        return i.toString();
    }
}
