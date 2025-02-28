package com.example.MultithreadingPractice.CompletableFuture;

import java.util.concurrent.*;

public class Main {
    public static void main(String [] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2, 4, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy()
        );

       CompletableFuture<String> asyncTask1=CompletableFuture.supplyAsync(()->{

           return "Concept and";
       },poolExecutor).thenApplyAsync((String value)->{
           return value+" coding";
       });
        System.out.println(asyncTask1.get());
////////////////////////////////////
        CompletableFuture<String> asyncTask2=CompletableFuture.supplyAsync(()->{

            return "hello";
        },poolExecutor).thenComposeAsync((String value)->{
            return CompletableFuture.supplyAsync(()->value+" world");
        });
        System.out.println(asyncTask2.get());


        CompletableFuture<String>async3=CompletableFuture.supplyAsync(()->{

            try {
                System.out.println("task run by "+Thread.currentThread().getName());
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "value ";
        },poolExecutor);

        CompletableFuture<Integer>async4=CompletableFuture.supplyAsync(()->{
            try {
                System.out.println("task run by "+Thread.currentThread().getName());
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 5;
        },poolExecutor);

        CompletableFuture<String>async5=async3.thenCombineAsync(async4,(String val1,Integer val2)-> val1+val2);

        System.out.println(async5.get());

        poolExecutor.shutdown();
    }
}
