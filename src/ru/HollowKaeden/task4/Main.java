package ru.HollowKaeden.task4;

public class Main {
    public static void main(String[] args) {
        CustomExecutorService executorService = new CustomExecutorService(2);
        executorService.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We run it");
        });
        executorService.submit(() -> System.out.println("Start"));
    }
}