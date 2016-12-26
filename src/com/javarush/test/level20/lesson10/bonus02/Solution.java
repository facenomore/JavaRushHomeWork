package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 3");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        if (a == null) return count;
        boolean rect = false;
//перший рядок
        for (int j = 0; j < a[0].length; j++) {
            if ((a[0][j] == 0) && (!rect)) continue;
            else if ((a[0][j] == 1) && (!rect)) {
                rect = true;
                count++;
            } else if ((a[0][j] == 0) && (rect)) {
                rect = false;
            }
        }
//наступні рядки
        for (int i = 1; i < a.length; i++) {
            byte[] tmp = a[i - 1];
            if (equals(tmp, a[i])) continue;
            else {
                for (int j = 0; j < a[i].length; j++) {
                    if ((a[i][j] == 0) && (!rect)) continue;
                    if ((a[i][j] == 1) && (tmp[j] == 1)) continue;
                    else if ((a[i][j] == 1) && (!rect)) {
                        rect = true;
                        count++;
                    } else if ((a[i][j] == 0) && (rect)) {
                        rect = false;
                    }
                }
            }
        }
        return count;
    }

    public static boolean equals(byte[] a, byte b[]) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

}

