package com.example.MultithreadingPractice.Future_Runnable;


import java.util.concurrent.*;

public class Main {
    public static void main(String [] args)
    {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2, 4, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy()
        );

        Future<?> futureObj=poolExecutor.submit(()->{

            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("this is the task which thread will execute");
        });
        System.out.println(futureObj.isDone());

        try {
            futureObj.get(2,TimeUnit.SECONDS);
        }
        catch (Exception ex)
        {
        }
        System.out.println(futureObj.isDone());
 poolExecutor.shutdown();
    }
}
