package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by a.todchuk on 12.04.2016.
 */
public abstract class DrinkMaker {

    abstract void getRightCup(); //- выбрать подходящую чашку

    abstract void putIngredient(); //- положить ингредиенты

    abstract void pour(); //- залить жидкостью

    void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }

}
