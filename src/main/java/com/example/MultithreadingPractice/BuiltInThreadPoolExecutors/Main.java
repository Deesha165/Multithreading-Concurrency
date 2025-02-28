package com.example.MultithreadingPractice.BuiltInThreadPoolExecutors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String [] args) throws ExecutionException, InterruptedException {
//fixed thread pool
        ExecutorService fixedPoolExecutor= Executors.newFixedThreadPool(5);
        System.out.println( fixedPoolExecutor.submit(()-> "this is async task").get());
       fixedPoolExecutor.shutdown();
// cached thread pool
        ExecutorService cachedPoolExecutor=Executors.newCachedThreadPool();
        System.out.println(cachedPoolExecutor.submit(()->"cached task").get());

        cachedPoolExecutor.shutdown();
    }
}
