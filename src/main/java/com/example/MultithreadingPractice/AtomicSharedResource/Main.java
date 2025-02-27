package com.example.MultithreadingPractice.AtomicSharedResource;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ExecutionException, InterruptedException, TimeoutException {

        AtomicSharedResource r=new AtomicSharedResource();

        Long start=System.nanoTime();

        Thread t1=new Thread(()->{
            for(int i=1;i<=100000;i++)
                r.addCount();
        });
        Thread t2=new Thread(()->{
            for(int i=1;i<=100000;i++)
                r.addCount();
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (Exception ex)
        {

        }
        Long end=System.nanoTime();

        System.out.println(r.getCount()+" "+ (end-start)/1_000_000);

    }

}
