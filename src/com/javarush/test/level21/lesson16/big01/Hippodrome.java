package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {

    public Horse getWinner() {
        Horse winnerHorse = new Horse("0", 0, 0);
        for (Horse h : horses) {
            if (winnerHorse.distance < h.distance) winnerHorse = h;
        }
        return winnerHorse;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public void move() {
        for (Horse h : horses) {
            h.move();
        }
    }

    public void print() {
        for (Horse h : horses) {
            h.print();
        }
        System.out.println();
        System.out.println();
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses() {
        return horses;
    }


    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        Horse horse1 = new Horse("Василек", 3, 0);
        Horse horse2 = new Horse("Горбунок", 3, 0);
        Horse horse3 = new Horse("Иноходец", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }
}