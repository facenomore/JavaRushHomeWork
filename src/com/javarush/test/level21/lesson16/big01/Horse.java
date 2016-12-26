package com.javarush.test.level21.lesson16.big01;

public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move() {
        this.distance += this.speed * Math.random();
    }


    public void print() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < Math.round(this.distance); i++) s.append('.');
        System.out.println(s + this.name);
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

}
