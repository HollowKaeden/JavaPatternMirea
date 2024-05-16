package ru.HollowKaeden.task5;

public class SingletonThird {
    // Singleton с использованием вложенного класса (Static Nested Class)
    private SingletonThird() {}

    private static class SingletonHelper {
        private static final SingletonThird INSTANCE = new SingletonThird();
    }

    public static SingletonThird getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
