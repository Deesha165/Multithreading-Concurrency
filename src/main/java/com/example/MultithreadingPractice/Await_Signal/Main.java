package com.example.MultithreadingPractice.Await_Signal;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ExecutionException, InterruptedException, TimeoutException {
        SharedResource resource=new SharedResource();

        Thread t1=new Thread(()->{

            for (int i=0;i<2;i++)
                resource.produce();
        });
        Thread t2=new Thread(()->{

            for (int i=0;i<2;i++)
                resource.consume();
        });
        t1.start();
        t2.start();
    }
}
