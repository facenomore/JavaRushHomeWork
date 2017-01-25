package com.javarush.test.level33.lesson15.big01.strategies;

import com.google.common.collect.HashBiMap;

public class HashBiMapStorageStrategy implements StorageStrategy {
    private HashBiMap<Long, String> data = HashBiMap.create();

    @Override
    public boolean containsKey(Long key) {
        return this.data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return this.data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        this.data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        return this.data.inverse().get(value);
    }

    @Override
    public String getValue(Long key) {
        return this.data.get(key);
    }
}
/*
12.2.1.	Иметь интерфейс StorageStrategy.
12.2.2.	Внутри иметь только одно поле data с типом HashBiMap.
12.3.	Проверь новую стратегию в методе main(). Запусти программу и сравни
скорость работы пяти стратегий.

 */