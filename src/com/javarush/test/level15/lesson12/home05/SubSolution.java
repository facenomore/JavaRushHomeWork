package com.javarush.test.level15.lesson12.home05;

import java.util.Objects;

/**
 * Created by Tod on 05.04.2016.
 */
public class SubSolution extends Solution
{
    public SubSolution(char i){
        super(i);
    }
    public SubSolution(byte i){
        super(i);
    }
    public SubSolution(short i){
        super(i);
    }

    protected SubSolution(Objects s){
        super(s);
    }
    protected SubSolution(Exception s){
        super(s);
    }
    protected SubSolution(String s){
        super(s);
    }

    private SubSolution(float i){
        super();
    }
    private SubSolution(double i){
        super();
    }
    private SubSolution(long i){
        super();
    }

    SubSolution(){
        super();
    }
    SubSolution(Float i){
        super(i);
    }
    SubSolution(Double i){
        super(i);
    }

}
