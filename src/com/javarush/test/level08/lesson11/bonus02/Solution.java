package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        List<String> addresses = new ArrayList<String>();
        List<String> city = new ArrayList<>();
        while (true)
        {
            String getCity = reader.readLine();
            if (getCity.isEmpty()) break;
            String family = reader.readLine();
            city.add(getCity);
            addresses.add(family);
        }

        //read home number
        String cityName = reader.readLine();

        if (city.contains(cityName))
        {
            int number;
            for (int i = 0; i < city.size(); i++)
            {
                if (cityName.equals(city.get(i)))
                {
                    number = i;
                    String familySecondName = addresses.get(number);
                    System.out.println(familySecondName);
                    break;
                }
            }
        }
    }
}
