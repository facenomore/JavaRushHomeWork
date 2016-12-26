package com.javarush.test.level04.lesson04.task04;

/* Время года
Реализовать метод checkSeason. По номеру месяца, метод должен определить время года (зима, весна, лето, осень) и вывести на экран.
Пример для номера месяца 2:
зима
Пример для номера месяца 5:
весна
*/

//import com.sun.java.util.jar.pack.Instruction;

public class Solution
{
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int mount){
        String x;
        x=(((mount==12)||(mount==1)||(mount==2))?"зима":
                (((mount==3)||(mount==4)||(mount==5))?"весна":
                        (((mount==6)||(mount==7)||(mount==8))?"лето":"осень")));
        System.out.println(x);

        //::CODE:
    }
}