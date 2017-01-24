package com.javarush.test.level37.lesson10.big01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Cloneable, Serializable, Set<E> {

    private final static Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>((int) Math.max(16, collection.size() / .75f));
        this.addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return null == map.put(e, PRESENT);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public Object clone() {
        AmigoSet<E> amigoSet = null;
        try {
            amigoSet = new AmigoSet<>(this.map.keySet());
        } catch (Exception e) {
            throw new InternalError();
        }
        return amigoSet;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();

        objectOutputStream.writeObject(map.size());
        for (E e : map.keySet()) objectOutputStream.writeObject(e);

        objectOutputStream.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        objectOutputStream.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();

        int size = (int) objectInputStream.readObject();
        Set<E> set = new HashSet<>();
        for (int i = 0; i < size; i++) set.add((E) objectInputStream.readObject());

        int capacity = (int) objectInputStream.readObject();
        float loadFactor = (float) objectInputStream.readObject();

        map = new HashMap<>(capacity, loadFactor);
        for (E e : set) map.put(e, PRESENT);

    }
}