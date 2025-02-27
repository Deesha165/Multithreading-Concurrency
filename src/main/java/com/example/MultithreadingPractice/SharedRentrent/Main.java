package com.example.MultithreadingPractice.SharedRentrent;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ExecutionException, InterruptedException, TimeoutException {

        ReadWriteLock lock=new ReentrantReadWriteLock();

        SharedRenterant sharedRenterant1=new SharedRenterant();


        Thread t1=new Thread(()->{
            sharedRenterant1.producer(lock);
        });

        Thread t2=new Thread(()->{
            sharedRenterant1.producer(lock);
        });
        Thread t3=new Thread(()->{
            sharedRenterant1.consumer(lock);
        });

        t1.start();
        t2.start();
        t3.start();
    }



}
