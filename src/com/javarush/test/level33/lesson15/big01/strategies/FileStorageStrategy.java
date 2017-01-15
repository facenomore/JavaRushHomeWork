package com.javarush.test.level33.lesson15.big01.strategies;


public class FileStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    private long bucketSizeLimit = 10000;

    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    {
        for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) table[i] = new FileBucket();
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    int hash(Long k) {
        return k.hashCode();
    }

    int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    Entry getEntry(Long key) {
        int hash = (key == null) ? 0 : hash(key);
        for (Entry e = table[indexFor(hash, table.length)].getEntry();
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

    public void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        for (int i = 0; i < newTable.length; i++) {
            newTable[i] = new FileBucket();
        }
        transfer(newTable);

        for (int i = 0; i < table.length; i++) {
            table[i].remove();
            table[i] = null;
        }
        table = newTable;
    }

    void transfer(FileBucket[] newTable) {
        int newCapacity = newTable.length;
        for (int j = 0; j < table.length; j++) {
            for (Entry e = table[j].getEntry(); e != null; ) {
                Entry next = e.next;
                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i].getEntry();
                newTable[i].putEntry(e);
                e = next;
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        if ((null != table[bucketIndex]) && (table[bucketIndex].getFileSize() > getBucketSizeLimit()))
            resize(2 * table.length);
        createEntry(hash, key, value, bucketIndex);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null) return false;

        for (FileBucket bucket : table) {
            if (bucket == null) continue;
            for (Entry e = bucket.getEntry(); e != null; e = e.next) if (value.equals(e.value)) return true;
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        addEntry(hash(key), key, value, indexFor(hash(key), table.length));
    }

    @Override
    public Long getKey(String value) {
        if (value == null) return 0l;
        for (FileBucket aTable : table) {
            for (Entry e = aTable.getEntry(); e != null; e = e.next)
                if (value.equals(e.value))
                    return aTable.getEntry().getKey();
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return null == getEntry(key) ? null : getEntry(key).getValue();
    }
}
