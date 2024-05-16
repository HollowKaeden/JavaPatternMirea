package ru.HollowKaeden.task8;

import java.util.ArrayList;
import java.util.List;

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Aggregate {
    Iterator createIterator();
}

class ConcreteIterator implements Iterator {
    private List<Object> list;
    private int position = 0;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return list.get(position++);
        }
        return null;
    }
}

class ConcreteAggregate implements Aggregate {
    private List<Object> list = new ArrayList<>();

    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(list);
    }
}