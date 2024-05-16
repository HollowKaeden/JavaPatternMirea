package ru.HollowKaeden.task5;

public class SingletonFirst {
    // Простой Singleton (Eager Initialization)
    private static final SingletonFirst instance = new SingletonFirst();

    private SingletonFirst() {}

    public static SingletonFirst getInstance() {
        return instance;
    }
}
