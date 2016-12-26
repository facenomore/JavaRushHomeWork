package com.javarush.test.level34.lesson15.big01.model;

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
        int tmpLevel = level;
        int x = FIELD_SELL_SIZE / 2;
        int y = FIELD_SELL_SIZE / 2;

        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player;

        walls.add(new Wall(x, y));
        walls.add(new Wall(x, y * 2));
        walls.add(new Wall(x, y * 3));

        boxes.add(new Box(x * 2, y * 2));
        homes.add(new Home(x * 3, y * 3));
        player = new Player(x * 4, y * 4);

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