package ru.HollowKaeden.task3;

import java.util.HashSet;
import java.util.Set;

public class SetSync<T> {
    private final Set<T> set = new HashSet<>();

    public synchronized  boolean add(T element) {
        return set.add(element);
    }

    public synchronized boolean contains(T element) {
        return set.contains(element);
    }

    public synchronized boolean remove(T element) {
        return set.remove(element);
    }

    public synchronized int size() {
        return set.size();
    }

    public synchronized void clear() {
        set.clear();
    }

    public synchronized boolean isEmpty() {
        return set.isEmpty();
    }
}
