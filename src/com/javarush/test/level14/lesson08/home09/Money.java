package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double f;

    public Money(double f)
    {
        this.f = f;
    }

    public double getAmount()
    {
        return f;
    }

    public abstract String getCurrencyName();
}

