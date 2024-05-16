package ru.HollowKaeden.task1;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String[], String[]> mirrorer = strings ->
        {
            String[] mirroredStrings = new String[strings.length];
            for (int i = 0; i < strings.length; ++i)
            {
                mirroredStrings[i] = new StringBuilder(strings[i]).reverse().toString();
            }
            return mirroredStrings;
        };

        String[] start = {"Test", "Hello", "Hi"};
        System.out.println("Начальный массив:");
        for (String i : start) System.out.println(i);

        String[] end = mirrorer.apply(start);
        System.out.println("Конечный массив:");
        for (String i : end) System.out.println(i);
    }
}
