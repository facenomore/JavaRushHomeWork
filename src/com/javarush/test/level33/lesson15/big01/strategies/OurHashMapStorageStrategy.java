package com.javarush.test.level33.lesson15.big01.strategies;

public class OurHashMapStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);

    }

    int indexFor(int hash, int length) {
        return 0;
    }

    Entry getEntry(Long key) {
        Entry[] tab;
        Entry first;
        int n;
        Long k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
                (first = tab[(n - 1) & hash(key)]) != null) {
            if (first.hash == hash(key) && ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
        }
        return null;
    }

    void resize(int newCapacity) {

    }

    void transfer(Entry[] newTable) {

    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {

    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {

    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        Entry[] tab = table;
        String v;
        if (tab != null && size > 0) {
            for (int i = 0; i < tab.length; ++i) {
                for (Entry e = tab[i]; e != null; e = e.next) {
                    if ((v = e.value) == value ||
                            (value != null && value.equals(v)))
                        return true;
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {

    }

    @Override
    public Long getKey(String value) {
        return null;
    }

    @Override
    public String getValue(Long key) {
        return null;
    }
}