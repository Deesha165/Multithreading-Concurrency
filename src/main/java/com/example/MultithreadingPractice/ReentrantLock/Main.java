package com.example.MultithreadingPractice.ReentrantLock;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ExecutionException, InterruptedException, TimeoutException {

        ReentrantLock lock=new ReentrantLock();
        SharedResource resource1=new SharedResource();
        SharedResource resource2=new SharedResource();
        Thread t1=new Thread(()->{
           resource1.produce(lock);
        });

        Thread t2=new Thread(()->{
           resource2.produce(lock);
        });

        t1.start();
        t2.start();
    }

}
