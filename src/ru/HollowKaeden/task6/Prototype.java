package ru.HollowKaeden.task6;

public class Prototype implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void operation() {
        System.out.println("Prototype operation");
    }
}