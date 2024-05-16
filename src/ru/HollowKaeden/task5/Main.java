package ru.HollowKaeden.task5;


public class Main {
    public static void main(String[] args) {
        // Простой Singleton (Eager Initialization)
        SingletonFirst first1 = SingletonFirst.getInstance();
        SingletonFirst first2 = SingletonFirst.getInstance();
        // Thread-Safe Singleton с двойной проверкой (Double-Checked Locking)
        SingletonSecond second1 = SingletonSecond.getInstance();
        SingletonSecond second2 = SingletonSecond.getInstance();
        // Singleton с использованием вложенного класса (Static Nested Class)
        SingletonThird third1 = SingletonThird.getInstance();
        SingletonThird third2 = SingletonThird.getInstance();

        if (first1 == first2) System.out.println("SingletonFirst прошёл проверку!");
        if (second1 == second2) System.out.println("SingletonSecond прошёл проверку!");
        if (third1 == third2) System.out.println("SingletonThird прошёл проверку!");
    }
}
