package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Tod on 03.04.2016.
 */
public class BelarusianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 35;
    }


    public String getDescription()
    {
        String s = super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + new BelarusianHen().getCountOfEggsPerMonth() + " яиц в месяц.";
        return  s;
    }
}
