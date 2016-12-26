package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Tod on 11.04.2016.
 */
public class Moon implements Planet
{
    private static Moon Moon;
    private Moon(){}

    public static Moon getInstance()
    {
        if(Moon == null)
            Moon = new Moon();
        return Moon;
    }
}
