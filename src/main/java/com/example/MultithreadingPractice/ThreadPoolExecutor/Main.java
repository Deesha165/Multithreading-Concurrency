package com.example.MultithreadingPractice.ThreadPoolExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

// Custom Thread Factory
class CustomThreadFactory implements ThreadFactory {
    private final AtomicInteger threadCount = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "CustomThread-" + threadCount.getAndIncrement());
        t.setDaemon(false);
        return t;
    }
}

// Custom Runnable Wrapper (To store task number)
class CustomTask implements Runnable {
    private final int taskNumber;

    public CustomTask(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task " + taskNumber + " processed by " + Thread.currentThread().getName());
    }

    public int getTaskNumber() {
        return taskNumber;
    }
}

// Custom Rejection Handler (Handles rejected tasks)
class CustomRejectionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (r instanceof CustomTask) {
            CustomTask task = (CustomTask) r;
            System.out.println("Task " + task.getTaskNumber() + " rejected.");
        } else {
            System.out.println("A task was rejected: " + r.toString());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2, 4, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1),
                new CustomThreadFactory(),
                new CustomRejectionHandler()
        );

        for (int i = 1; i <= 6; i++) {
            poolExecutor.submit(new CustomTask(i)); // Use execute() instead of submit()
        }

        poolExecutor.shutdown();
    }
}
