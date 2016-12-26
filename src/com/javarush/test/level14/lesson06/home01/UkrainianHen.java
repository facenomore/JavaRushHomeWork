package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Tod on 03.04.2016.
 */
public class UkrainianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 40;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + new UkrainianHen().getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
