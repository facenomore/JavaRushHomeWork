package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.Direction;
import com.javarush.test.level34.lesson15.big01.model.GameObject;
import com.javarush.test.level34.lesson15.big01.model.GameObjects;

import static com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Field extends JPanel {
    private View view;
    private EventListener eventListener;


    public Field(View view) {
        this.view = view;
        KeyHandler keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true);
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

    public class KeyHandler extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:  eventListener.move(Direction.LEFT);   break;
                case KeyEvent.VK_RIGHT: eventListener.move(Direction.RIGHT);  break;
                case KeyEvent.VK_UP:    eventListener.move(Direction.UP);     break;
                case KeyEvent.VK_DOWN:  eventListener.move(Direction.DOWN);   break;
                case KeyEvent.VK_R:     eventListener.restart();              break;
            }
        }
    }
}

/*
    Добавим немного интерактивности в нашу игру (перемещение игрока с помощью
клавиатуры). Начнем с обработки нажатия клавиш клавиатуры.
14.1.	Добавь в класс Field вложенный класс KeyHandler унаследованный от
KeyAdapter.
14.2.	Перегрузи у него метод keyPressed(). Если была нажата клавиша с кодом
VK_LEFT, то пошли eventListener-у событие move с параметром Direction.LEFT.
Аналогичным образом обработай нажатия клавиш с кодом VK_RIGHT, VK_UP и
VK_DOWN. Если пользователь нажал клавишу R с кодом VK_R, то вызови у слушателя
событий метод restart().
14.3.	В конструкторе класса Field:
14.3.1.	Создай объект класса KeyHandler.
14.3.2.	Установи его слушателем с помощью метода addKeyListener().
14.3.3.	Установи focusable в true (метод setFocusable()).
 */