package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "Тут","приключилась","вторая","странность,","касающаяся","одного","Берлиоза","Он","внезапно","перестал","икать,","сердце","его","стукнуло","и","на","мгновенье",
                "куда-то","провалилось","потом","вернулось","тупой","иглой","засевшей","нем");
        list = fix(list);

        for (String s : list)
        {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list)
    {
        int x=0,y=0;
        for (int i=0; i<list.size();i++){
            for (int j=0; j<list.get(i).length();j++){
                if (list.get(i).charAt(j)=='р') x++;
                if (list.get(i).charAt(j)=='л') y++;
            }
            if ((x>0)&&(y==0)){
                list.remove(i);
                i--;
            }
            else if ((x==0)&&(y>0)){
                list.add(i,list.get(i));
                i++;
            }
            x=0;
            y=0;
        }

        return list;
    }
}