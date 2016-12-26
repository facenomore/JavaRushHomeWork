package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.*;
import com.javarush.test.level34.lesson15.big01.model.Box;


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
        Wall wall = new Wall(0, 0);
        wall.draw(g);
        Box box = new Box(20, 20);
        Player player = new Player(0, 0);
        Home home = new Home(0, 20);
        home.draw(g);
        box.draw(g);
        player.draw(g);
    }
}