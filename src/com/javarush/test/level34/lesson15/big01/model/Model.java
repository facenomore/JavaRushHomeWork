package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

public class Model {
    public static final int FIELD_SELL_SIZE = 20;

    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("src/com/javarush/test/level34/lesson15/big01/res/levels.txt"));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restart();
    }

/*
15.4.	void move(Direction direction). Метод должен:
15.4.1.	Проверить столкновение со стеной (метод checkWallCollision()), если есть
столкновение – выйти из метода.
15.4.2.	Проверить столкновение с ящиками (метод checkBoxCollision()), если есть
столкновение – выйти из метода.
15.4.3.	Передвинуть игрока в направлении direction.
15.4.4.	Проверить завершен ли уровень.
*/

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();

        if (checkWallCollision(player, direction)) return;
        if (checkBoxCollision(direction)) return;

        switch (direction) {
            case DOWN:
                player.move(0, FIELD_SELL_SIZE);
                break;
            case LEFT:
                player.move(-FIELD_SELL_SIZE, 0);
                break;
            case RIGHT:
                player.move(FIELD_SELL_SIZE, 0);
                break;
            case UP:
                player.move(0, -FIELD_SELL_SIZE);
                break;
        }

        checkCompletion();
    }

    /*
    15.1.	boolean checkWallCollision(CollisionObject gameObject, Direction direction). Этот
    метод проверяет столкновение со стеной. Он должен вернуть true, если при движении
    объекта gameObject в направлении direction произойдет столкновение со стеной,
    иначе false. Для определения столкновения используй метод isCollision() у игрового
    объекта.
     */
    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls())
            if (gameObject.isCollision(wall, direction))
                return true;
        return false;
    }

    /*
    15.2.	boolean checkBoxCollision(Direction direction). Этот метод проверяет
    столкновение с ящиками. Метод должен:
    15.2.1.	Вернуть true, если игрок не может быть сдвинут в направлении direction (там
    находится: или ящик, за которым стена; или ящик за которым еще один ящик).
    15.2.2.	Вернуть false, если игрок может быть сдвинут в направлении direction (там
    находится: или свободная ячейка; или дом; или ящик, за которым свободная
    ячейка или дом). При это, если на пути есть ящик, который может быть сдвинут, то
    необходимо переместить этот ящик на новые координаты. Обрати внимание, что
    все объекты перемещаются на фиксированное значение FIELD_SELL_SIZE, не
    зависящее от размеров объекта, которые используются для его отрисовки.
    Подсказка: для определения столкновений используй методы isCollision() игровых
    объектов и метод checkWallCollision() модели.
    */
    public boolean checkBoxCollision(Direction direction) {

        Player player = gameObjects.getPlayer();

        GameObject stoped = null;
        for (GameObject gameObject : gameObjects.getAll()) {
            if (!(gameObject instanceof Player)
                    && !(gameObject instanceof Home)
                    && player.isCollision(gameObject, direction))
                stoped = gameObject;
        }

        if (stoped == null) return false;

        if (stoped instanceof Box) {
            Box stopedBox = (Box) stoped;
            if (checkWallCollision(stopedBox, direction)) return true;

            for (Box box : gameObjects.getBoxes()) {
                if (stopedBox.isCollision(box, direction)) return true;
            }

            switch (direction) {
                case LEFT:
                    stopedBox.move(-FIELD_SELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(FIELD_SELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -FIELD_SELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, FIELD_SELL_SIZE);
                    break;
            }
        }
        return false;
    }

/*
15.3.	void checkCompletion(). Этот метод должен проверить пройден ли уровень (на
всех ли домах стоят ящики, их координаты должны совпадать). Если условие
выполнено, то проинформировать слушателя событий, что текущий уровень завершен.
*/

    public void checkCompletion() {
        int homeCount = 0;
        int boxCount = 0;
        for (Home home : getGameObjects().getHomes()) {
            homeCount++;
            for (Box box : getGameObjects().getBoxes()) {
                if ((box.getX() == home.getX()) && (box.getY() == home.getY()))
                    boxCount++;
            }
        }
        if (homeCount == boxCount) eventListener.levelCompleted(currentLevel);
    }
}
/*
Пришло время реализовать метод модели, отвечающий за движение move(), но для
начала реализуем вспомогательные методы. Добавь в класс модели методы:

Запусти программу и проверь, что игрока можно перемещать, он может перемещать
ящики, стены преграждают движение, а при перемещении всех ящиков в дома выводится
сообщение о прохождении уровня.
 */