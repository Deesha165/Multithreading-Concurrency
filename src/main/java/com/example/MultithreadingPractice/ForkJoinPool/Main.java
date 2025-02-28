package com.example.MultithreadingPractice.ForkJoinPool;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        long startTime1 = System.nanoTime(); // Start time for ForkJoinPool
        Future<Integer> futureObj = forkJoinPool.submit(new ComputeSumTask(1, 1000000));
        int parallelResult = futureObj.get();
        long endTime1 = System.nanoTime(); // End time for ForkJoinPool

        System.out.println("ForkJoinPool Result: " + parallelResult);
        System.out.println("ForkJoinPool Execution Time: " + (endTime1 - startTime1) / 1_000_000 + " ms");

        // Sequential computation
        long startTime2 = System.nanoTime(); // Start time for sequential sum
        int sequentialResult = 0;
        for (int i = 1; i <= 1000000; i++) sequentialResult += i;
        long endTime2 = System.nanoTime(); // End time for sequential sum

        System.out.println("Sequential Computation Result: " + sequentialResult);
        System.out.println("Sequential Execution Time: " + (endTime2 - startTime2) / 1_000_000 + " ms");
    }
}
