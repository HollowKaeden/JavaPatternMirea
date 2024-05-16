package ru.HollowKaeden.task4;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomExecutorService {
    private final List<WorkerThread> threads;
    private final BlockingQueue<Runnable> taskQueue;

    public CustomExecutorService(int numThreads) {
        this.taskQueue = new LinkedBlockingQueue<>();
        this.threads = new LinkedList<>();

        for (int i = 0; i < numThreads; i++) {
            WorkerThread worker = new WorkerThread();
            worker.start();
            threads.add(worker);
        }
    }

    public void submit(Runnable task) {
        taskQueue.offer(task);
    }

    private class WorkerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void shutdown() {
        for (WorkerThread worker : threads) {
            worker.interrupt();
        }
    }
}