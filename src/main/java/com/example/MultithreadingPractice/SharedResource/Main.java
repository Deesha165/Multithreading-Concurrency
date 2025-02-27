package com.example.MultithreadingPractice.SharedResource;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ExecutionException, InterruptedException, TimeoutException {



        SharedResource sharedResource=new SharedResource();
        Thread produceThread=new Thread(()->sharedResource.addItem());
        Thread consumeThread=new Thread(()->sharedResource.consumeItem());

        produceThread.start();

        consumeThread.start();
    }



}
