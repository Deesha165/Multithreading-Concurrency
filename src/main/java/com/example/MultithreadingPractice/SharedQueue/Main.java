package com.example.MultithreadingPractice.SharedQueue;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ExecutionException, InterruptedException, TimeoutException {

        SharedQueue q = new SharedQueue(5);
        Thread produceThreadQueue = new Thread(() -> q.produceQueue());
        Thread consumeThreadQueue = new Thread(() -> q.consumeQueue());


        consumeThreadQueue.start();
        produceThreadQueue.start();

    }

    }
