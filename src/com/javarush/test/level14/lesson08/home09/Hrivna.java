package com.javarush.test.level14.lesson08.home09;

/**
 * Created by a.todchuk on 04.04.2016.
 */
public class Hrivna extends Money
{

    public Hrivna(double f)
    {
        super(f);
    }

    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }
}
