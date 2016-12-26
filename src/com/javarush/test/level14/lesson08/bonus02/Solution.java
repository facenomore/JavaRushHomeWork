package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x,y,z;
        x=Integer.parseInt(reader.readLine());
        y=Integer.parseInt(reader.readLine());
        z=x<y?x:y;
        for (int i=z;i>0;i--)
            if ((x%i==0)&&(y%i==0)) {
            z = i;
            break;
        }
        System.out.println(z);
    }
}