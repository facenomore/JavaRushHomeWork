package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "ranm" /*,"mluf", "pml", "jhv", "fde", "ful", "rlk", "kov", "ejj", "jhv", "poe"*/);
       /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
        */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> findWords = new ArrayList<>();


        for (String word : words) {
            final int LENGTH = crossword[0].length;
            final int HEIGHT = crossword.length;

            int[] arrayWord = convertWordToIntArray(word);
            final int WORD_LENGTH = arrayWord.length;

            int[] crosswordPart = new int[WORD_LENGTH];
/*
//Прямий обхід працює
            for (int i = 0; i < HEIGHT; i++)
                for (int j = 0; j < LENGTH - WORD_LENGTH; j++) {
//вибір частини массиву
                    for (int x = j, y = 0; x < j + WORD_LENGTH; x++, y++) {
                        crosswordPart[y] = crossword[i][x];
                    }
//чи належить, якщо так в список
                    if (equalsWords(arrayWord, crosswordPart)) {
                        Word findWord = new Word(word);
                        findWord.setStartPoint(j, i);
                        findWord.setEndPoint(j + WORD_LENGTH - 1, i);
                        findWords.add(findWord);
                    }
                }

//справа наліво працює
            for (int i = HEIGHT - 1; i >= 0; i--)
                for (int j = LENGTH - WORD_LENGTH - 1; j >= 0; j--) {
//вибір частини массиву
                    for (int x = j + WORD_LENGTH, y = 0; x > j; x--, y++) {
                        crosswordPart[y] = crossword[i][x];
                    }
//чи належить, якщо так в список
                    if (equalsWords(arrayWord, crosswordPart)) {
                        Word findWord = new Word(word);
                        findWord.setStartPoint(j + WORD_LENGTH, i);
                        findWord.setEndPoint(j + 1, i);
                        findWords.add(findWord);
                    }
                }

//зверху вниз працює
            for (int i = 0; i < crossword[0].length; i++) {
                for (int j = 0; j < HEIGHT - WORD_LENGTH + 1; j++) {
                    //вибір частини массиву
                    for (int x = j, y = 0; x < j + WORD_LENGTH; x++, y++) {
                        crosswordPart[y] = crossword[x][i];
                    }
//чи належить, якщо так в список
                    if (equalsWords(arrayWord, crosswordPart)) {
                        Word findWord = new Word(word);
                        findWord.setStartPoint(i, j);
                        findWord.setEndPoint(i, j + WORD_LENGTH - 1);
                        findWords.add(findWord);
                    }
                }
            }

//знизу вверх працює
            for (int i = crossword[0].length - 1; i >= 0; i--) {
                for (int j = HEIGHT - WORD_LENGTH - 1; j >= -1; j--) {
//вибір частини массиву
                    for (int x = j + WORD_LENGTH, y = 0; x > j; x--, y++) {
                        crosswordPart[y] = crossword[x][i];
                    }
//чи належить, якщо так в список  j + WORD_LENGTH
                    if (equalsWords(arrayWord, crosswordPart)) {
                        Word findWord = new Word(word);
                        findWord.setStartPoint(i, j + WORD_LENGTH);
                        findWord.setEndPoint(i, j + 1);
                        findWords.add(findWord);
                    }
                }
            }*/


            for (int i = 0; i < LENGTH; i++) {
                int x = i;
                int y = 0;

                while ((x >= 0) && (y < HEIGHT)) {
                    System.out.print((char) crossword[y][x]);
                    x--;
                    y++;
                }
                System.out.println();
            }

            int tmp = LENGTH - HEIGHT + 1;

            for (int i = 1; i < HEIGHT; i++) {
                int x = LENGTH - 1;
                int y = i;

                while ((x >= tmp) && (y < HEIGHT)) {
                    System.out.print((char) crossword[y][x]);
                    x--;
                    y++;
                }
                System.out.println();
            }
        }

        for (Word w : findWords) {
            System.out.println(w);
        }
        return findWords;
    }

    public static boolean equalsWords(int[] arrayWord, int[] crosswordPart) {
        int count = 0;
        for (int i = 0; i < arrayWord.length; i++) {
            if (arrayWord[i] != crosswordPart[i]) return false;
            else count++;
        }
        if (count == arrayWord.length) return true;
        return false;
    }

    public static int[] convertWordToIntArray(String word) {
        int[] tmp = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            tmp[i] = (int) word.toCharArray()[i];
        }
        return tmp;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
