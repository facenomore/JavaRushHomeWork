package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.util.Random;

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

        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Random random = new Random();

        String dictSmallLetters = "abcdefjhijklmnopqrstuvwxyz";
        String dictLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String dictDigits = "1234567890";

        int smallLetters = 0;
        int letters = 0;
        int digits = 0;

        while (true) {
            for (int i = 0; i < 8; i++) {
                int tmp = random.nextInt(3);
                if (tmp == 0) byteArrayOutputStream.write(48 + random.nextInt(10));
                if (tmp == 1) byteArrayOutputStream.write(65 + random.nextInt(26));
                if (tmp == 2) byteArrayOutputStream.write(97 + random.nextInt(26));
                if (dictSmallLetters.contains(String.valueOf(byteArrayOutputStream.toString().substring(byteArrayOutputStream.toString().length() - 1))))
                    smallLetters++;
                else if (dictLetters.contains(byteArrayOutputStream.toString().substring(byteArrayOutputStream.toString().length() - 1)))
                    letters++;
                else if (dictDigits.contains(byteArrayOutputStream.toString().substring(byteArrayOutputStream.toString().length() - 1)))
                    digits++;
            }
            if ((smallLetters > 0) && (letters > 0) && (digits > 0)) break;
            else byteArrayOutputStream.reset();
        }
        return byteArrayOutputStream;
    }
}