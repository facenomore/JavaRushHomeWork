package com.javarush.test.level08.lesson08.task01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet(){
        HashSet<String> set = new HashSet<String>();
        set.add("Люда");
        set.add("Люба");
        set.add("Люка");
        set.add("Люся");
        set.add("Лиза");
        set.add("Лада");
        set.add("Ласка");
        set.add("Лайка");
        set.add("Лямбда");
        set.add("Люси");
        set.add("Лобуда");
        set.add("Лика");
        set.add("Лом");
        set.add("Лыко");
        set.add("Линия");
        set.add("Линмей");
        set.add("Люцид");
        set.add("Люциан");
        set.add("Люциус");
        set.add("Лаванда");
        return set;
    }
}
