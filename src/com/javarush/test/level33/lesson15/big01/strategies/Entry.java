package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.Serializable;
import java.util.Objects;

public class Entry implements Serializable {
    int hash;
    Long key;
    String value;
    Entry next;

    public Entry(int hash, Long key, String value, Entry next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

}
/*
7.3.	Добавь в Entry следующие поля: Long key, String value, Entry next, int hash. Как
видишь, наша реализация будет поддерживать только тип Long для ключа и только
String для значения. Область видимости полей оставь по умолчанию.
7.4.	Добавь и реализуй конструктор Entry(int hash, Long key, String value, Entry next).
7.5.	Добавь и реализуй методы: Long getKey(), String getValue(), int hashCode() и String
toString(). Реализовывать остальные методы оригинального Entry не нужно, мы
пишем упрощенную версию.

 */