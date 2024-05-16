package ru.HollowKaeden.task5;

public class SingletonSecond {
    // Thread-Safe Singleton с двойной проверкой (Double-Checked Locking)
    private static volatile SingletonSecond instance;

    private SingletonSecond() {}

    public static SingletonSecond getInstance() {
        if (instance == null) {
            synchronized (SingletonSecond.class) {
                if (instance == null) {
                    instance = new SingletonSecond();
                }
            }
        }
        return instance;
    }
}
