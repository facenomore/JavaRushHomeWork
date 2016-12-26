package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Tod on 03.04.2016.
 */
public class MoldovanHen extends Hen
{
    public int getCountOfEggsPerMonth(){
        return 30;
    }

    public String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу "  + new MoldovanHen().getCountOfEggsPerMonth()+ " яиц в месяц.";
    }
}
