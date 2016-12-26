package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Tod on 03.04.2016.
 */
public class RussianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 20;
    }

    public String getDescription()
    {
        return  super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + new RussianHen().getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}


