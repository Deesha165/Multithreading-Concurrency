package com.example.MultithreadingPractice.ScheduledThreadPoolExecutor;

import java.util.concurrent.*;

public class Main {
    public static void main(String [] args)
    {

        ScheduledExecutorService poolObj=
                Executors.newScheduledThreadPool(5);
        poolObj.scheduleAtFixedRate(()->{
            System.out.println("hello world");
        },0,7, TimeUnit.SECONDS);


    }

}
