package com.example.MultithreadingPractice.DeamonThread;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ExecutionException, InterruptedException, TimeoutException {

        System.out.println("main thread started");
        SharedResource resource=new SharedResource();
        Thread t1=new Thread(()->{

            resource.produce();

        });

        t1.setDaemon(true);// no release for the lock
        t1.start();


        System.out.println("main thread finished");


    }
}
