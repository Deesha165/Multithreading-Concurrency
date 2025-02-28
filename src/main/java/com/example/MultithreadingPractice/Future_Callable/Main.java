package com.example.MultithreadingPractice.Future_Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String [] args)
    {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2, 4, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy()
        );

        Future<List<Integer>>futureObj=poolExecutor.submit(()->{
            Thread.sleep(4000);
            List<Integer>list = new ArrayList<>();
            list.add(1);
            return list;
        });
        try {
            List<Integer>result=futureObj.get();
            System.out.println(result.get(0));
        }
        catch (Exception ex)
        {

        }

        poolExecutor.shutdown();

    }
}
