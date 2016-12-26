package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    private Order currentOrder;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());


    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder() {
        try {
            currentOrder = new Order(this);
            new AdvertisementManager(currentOrder.getTotalCookingTime()).processVideos();
            if (currentOrder.isEmpty()) return;
            ConsoleHelper.writeMessage(currentOrder.toString());
            setChanged();
            notifyObservers(currentOrder);
        } catch (NoVideoAvailableException noVideo) {
            logger.log(Level.INFO,"No video is available for the order " + currentOrder);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }
}