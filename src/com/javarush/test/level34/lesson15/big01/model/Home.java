package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

import static com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE;

public class Home extends GameObject {
    public Home(int x, int y) {
        super(x + FIELD_SELL_SIZE / 2 - 1, y + FIELD_SELL_SIZE / 2 - 1);
        setHeight(2);
        setWidth(2);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.drawOval(getX(), getY(), getWidth(), getHeight());
    }
}
