package ru.HollowKaeden.task3;

import java.util.Set;

public class Main {
    static volatile MapLock<Integer, String> maplock = new MapLock<>();
    static volatile SetSync<String> setsync = new SetSync<>();
    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            maplock.put(1, "Apple");
            System.out.println("Добавили apple с ключом 1 в первом");
            maplock.put(2, "Banana");
            System.out.println("Добавили banana с ключом 2 в первом");
            System.out.println("Получение по ключу 1 в первом: " + maplock.get(1));
            maplock.remove(1);
            System.out.println("Удалили значение по ключу 1 в первом");
            System.out.println("Размер в первом: " + maplock.size());
        });
        Thread two = new Thread(() -> {
            maplock.put(3, "Strawberry");
            System.out.println("Добавили strawberry с ключом 3 во втором");
            maplock.put(4, "Orange");
            System.out.println("Добавили orange с ключом 4 во втором");
            System.out.println("Получение по ключу 4 во втором: " + maplock.get(4));
            maplock.remove(4);
            System.out.println("Удалили значение по ключу 4 во втором");
            System.out.println("Размер во втором: " + maplock.size());
        });
        Thread three = new Thread(() -> {
            setsync.add("Tomato");
            System.out.println("Добавили tomato в третьем");
            setsync.remove("Tomato");
            System.out.println("Удалили tomato в третьем");
            System.out.println("Размер в третьем: " + setsync.size());
            setsync.add("Pickle");
            System.out.println("Добавили pickle в третьем");
            setsync.clear();
            System.out.println("Очистили в третьем");
            System.out.println("После очищения в третьем: " + setsync.size());
        });
        Thread four = new Thread(() -> {
            setsync.add("Potato");
            System.out.println("Добавили potato в четвертом");
            setsync.remove("Potato");
            System.out.println("Удалили potato в четвертом");
            System.out.println("Размер в четвертом: " + setsync.size());
            setsync.add("Beet");
            System.out.println("Добавили Beet в четвертом");
            setsync.clear();
            System.out.println("Очистили в четвёртом");
            System.out.println("После очищения в четвертом: " + setsync.size());
        });
        one.start();
        two.start();
        Thread.sleep(1500);
        System.out.println();
        three.start();
        four.start();
        Thread.sleep(1000);
    }
}
