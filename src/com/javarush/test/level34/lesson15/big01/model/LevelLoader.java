package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        if (level > 60) level = level % 60;
        if (level == 0) level = 60;
        String maze = String.format("Maze: %d", level);

        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toAbsolutePath().toString()))) {
            while (!maze.equals(reader.readLine())) ;

            reader.readLine();
            int sizeX = Integer.valueOf(reader.readLine().substring(8, 10));
            int sizeY = Integer.valueOf(reader.readLine().substring(8, 10));
            reader.readLine();
            reader.readLine();
            reader.readLine();

            for (int i = 0; i < sizeY; i++) {
                String line = reader.readLine();
                for (int j = 0; j < sizeX; j++) {
                    char object = line.charAt(j);
                    int coordX = FIELD_SELL_SIZE / 2 + FIELD_SELL_SIZE * j;
                    int coordY = FIELD_SELL_SIZE / 2 + FIELD_SELL_SIZE * i;
                    switch (object) {
                        case 'X':
                            walls.add(new Wall(coordX, coordY));
                            break;

                        case '*':
                            boxes.add(new Box(coordX, coordY));
                            break;

                        case '.':
                            homes.add(new Home(coordX, coordY));
                            break;

                        case '&':
                            boxes.add(new Box(coordX, coordY));
                            homes.add(new Home(coordX, coordY));
                            break;
                        case '@':
                            player = new Player(coordX, coordY);
                            break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameObjects(walls, boxes, homes, player);
    }
}

/*
Задание 10.

	В игре будет несколько уровней, все уровни будут храниться в текстовом файле. Сейчас мы
напишем тестовую реализацию загрузчика уровней LevelLoader. Почему тестовую? Полный
функционал нам пока не нужен, он довольно сложный, оставим его на потом. А пока:
10.1.	Создай класс LevelLoader в пакете model.
10.2.	Добавь в класс конструктор, принимающий Path levels. Параметр levels – это
путь к тестовому файлу, содержащему описание уровней.
10.3.	Добавь в класс LevelLoader метод GameObjects getLevel(int level). Пока не важно,
что будет возвращать этот метод. Пусть он всегда возвращает набор из: одного игрока,
одного дома, одного ящика и нескольких стен. Так будет проще отладить работу игры.
Координаты каждого объекта должны быть не нулевые и кратны половине
FIELD_SELL_SIZE (центр каждого объекта должен быть в середине ячейки поля).
 */