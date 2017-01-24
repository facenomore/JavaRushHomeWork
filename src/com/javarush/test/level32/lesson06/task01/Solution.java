package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
        }
    }

    public static ByteArrayOutputStream getPassword() {
        ArrayList<String> passwords = new ArrayList<>();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String dict = "abcdefjhijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        String dictSmallLetters = "abcdefjhijklmnopqrstuvwxyz";
        String dictLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String dictDigits = "1234567890";
        char[] password = new char[8];
        byte[] bytePassword = new byte[8];


        int smallLetters = 0;
        int letters = 0;
        int digits = 0;

        while (true) {
            for (int i = 0; i < 8; i++) {
                password[i] = dict.toCharArray()[(int) (dict.length() * Math.random())];

                bytePassword[i] = (byte) password[i];
                if (dictSmallLetters.contains(String.valueOf(password[i]))) smallLetters++;
                else if (dictLetters.contains(String.valueOf(password[i]))) letters++;
                else if (dictDigits.contains(String.valueOf(password[i]))) digits++;
            }
            if ((smallLetters > 0) && (letters > 0) && (digits > 0)) {
                try {
                    byteArrayOutputStream.write(bytePassword);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return byteArrayOutputStream;
    }
}
