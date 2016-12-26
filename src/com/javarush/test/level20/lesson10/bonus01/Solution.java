package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[][] pow = new int[9][10];

    static {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 10; j++)
                pow[i][j] = j;

        for (int i = 1; i < 9; i++)
            for (int j = 1; j < 10; j++)
                pow[i][j] = pow[i - 1][j] * j;
    }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        int[] array = getNumbers(100000000);
        for (int i : array)
            System.out.println(i);
        Long t1 = System.currentTimeMillis();
        System.out.println("Time of program = " + (t1 - t0));
    }


    public static int[] getNumbers(int N) {
        ArrayList<Integer> resultArray = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int right = digitsOfNumericPow(i);
            if (right == i) resultArray.add(i);
        }
        int[] result = new int[resultArray.size()];
        for (int i = 0; i < resultArray.size(); i++) {
            result[i] = resultArray.get(i);
        }
        return result;
    }

    public static int digitsOfNumericPow(int numeric) {
        ArrayList<Integer> digits = digitsOfNumeric(numeric);
        int index = digits.size()-1;
        int result = 0;
        for (int digit : digits) {
            result += pow[index][digit];
        }
        return result;
    }

    public static ArrayList<Integer> digitsOfNumeric(int numeric) {
        ArrayList<Integer> digits = new ArrayList<>();
        int tmp = numeric;
        while (tmp > 0) {
            int past = tmp % 10;
            tmp = (tmp - past) / 10;
            digits.add(past);
        }
        return digits;
    }
}
