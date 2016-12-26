package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
       /* map.put("name","Ivanov");
        map.put("country","Ukraine");
        map.put("city","Kiev");
        map.put("age",null);*/
        System.out.println(getCondition(map).toString());
    }


    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        if ((params == null) || (params.size() == 0)) return result;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                result.append(entry.getKey());
                result.append(" = '");
                result.append(entry.getValue());
                result.append("' and ");
            }
        }
        int tmp = result.length();
        if (tmp > 5) result.delete(tmp - 5, tmp);
        return result;
    }
}
