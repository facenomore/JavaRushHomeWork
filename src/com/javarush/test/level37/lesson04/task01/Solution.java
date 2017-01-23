package com.javarush.test.level37.lesson04.task01;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* Круговой итератор
Класс Solution наследуется от ArrayList.
Напишите свой класс RoundIterator внутри Solution, который будет итератором для списка Solution.
Итератор должен ходить по кругу по всем элементам.
В остальном поведение должно быть идентичным текущему итератору.
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public class RoundIterator implements Iterator<T> {
        int cursor;

        @Override
        public boolean hasNext() {
            return (Solution.this.size() > 0);
        }

        @Override
        public T next() {
            int i = cursor;
            if (i >= Solution.this.size()) i = 0;
            cursor = i + 1;
            return Solution.this.get(i);
        }

        @Override
        public void remove() {
            iterator().remove();
        }
    }
}
