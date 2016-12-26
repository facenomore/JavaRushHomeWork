package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Tod on 11.04.2016.
 */
public class Sun implements Planet
{
    private static Sun Sun;
    private Sun(){}

    public static Sun getInstance()
    {
        if(Sun == null)
            Sun = new Sun();
        return Sun;
    }
}

