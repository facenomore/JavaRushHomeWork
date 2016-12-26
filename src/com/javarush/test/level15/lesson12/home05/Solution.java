package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

import com.sun.org.apache.bcel.internal.generic.FLOAD;

import java.util.Objects;

public class Solution {
    public Solution(char i){
    }
    public Solution (byte i){
    }
    public Solution(short i){
    }

    protected Solution(Objects s){
    }
    protected Solution(Exception s){
    }
    protected Solution(String s){
    }

    private Solution(float i){
    }
    private Solution(double i){
    }
    private Solution(long i){
    }

    Solution(){
    }
    Solution(Float i){
    }
    Solution(Double i){
    }
}

