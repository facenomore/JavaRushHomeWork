package com.javarush.test.level30.lesson15.big01;

import java.io.Serializable;

public class Message implements Serializable {

    private final MessageType type;
    private final String data;

    public Message(MessageType type) {
        this.type = type;
        this.data = null;
    }

    public Message(MessageType type, String data) {
        this.type = type;
        this.data = data;
    }

    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}
/*
    Сообщение Message – это данные которые одна сторона отправляет, а вторая принимает.
Каждое сообщение должно иметь тип MessageType, а некоторые и дополнительные
данные, например, текстовое сообщение должно содержать текст. Т.к. сообщения будут
создаваться в одной программе, а читаться в другой, удобно воспользоваться механизмом
сериализации для перевода класса в последовательность битов и наоборот.
Добавь в класс Message:
4.1.	Поддержку интерфейса Serializable
4.2.	Final поле типа MessageType type, которое будет содержать тип сообщения
4.3.	Final поле типа String data, которое будет содержать данные сообщения
4.4.	Геттеры для этих полей
4.5.	Конструктор, принимающий только MessageType, он должен проинициализировать
поле type переданным параметром, а поле data с помощью null.
4.6.	Конструктор, принимающий MessageType type и String data. Он должен также
инициализировать все поля класса.
 */