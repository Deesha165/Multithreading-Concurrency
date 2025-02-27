package com.example.MultithreadingPractice.ThreadPoolExecutor;

import java.util.concurrent.*;

public class Main {


    public static void main(String[] args)
    {

        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor
                (1,1,1, TimeUnit.HOURS,new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<String> s=CompletableFuture.supplyAsync(()->{

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "any thing";
        },poolExecutor);
    }

}
