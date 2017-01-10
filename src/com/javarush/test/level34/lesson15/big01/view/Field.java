package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.GameObject;
import com.javarush.test.level34.lesson15.big01.model.GameObjects;

import static com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private View view;
    private EventListener eventListener;


    public Field(View view) {
        this.view = view;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, FIELD_SELL_SIZE * 25, FIELD_SELL_SIZE * 25);

        GameObjects gameObjects = view.getGameObjects();
        for (GameObject gameObject : gameObjects.getAll()) {
            gameObject.draw(g);
        }
    }
}