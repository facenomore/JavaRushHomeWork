package com.javarush.test.level34.lesson15.big01.model;

import static com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE;

public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        boolean result = false;
        switch (direction) {
            case RIGHT: {
                if ((gameObject.getX() == getX() + FIELD_SELL_SIZE) &&
                        (gameObject.getY() == getY())) result = true;
                break;
            }
            case DOWN: {
                if ((gameObject.getX() == getX()) &&
                        (gameObject.getY() == getY() + FIELD_SELL_SIZE)) result = true;
                break;
            }
            case LEFT: {
                if ((gameObject.getX() == getX() - FIELD_SELL_SIZE) &&
                        (gameObject.getY() == getY())) result = true;

                break;
            }
            case UP: {
                if ((gameObject.getX() == getX()) &&
                        (gameObject.getY() == getY() - FIELD_SELL_SIZE)) result = true;

                break;
            }
        }
        return result;
    }
}